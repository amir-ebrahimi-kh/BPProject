/**
 * Represents a boundary line in the 2D physics simulation.
 * Lines have a position and can interact with particles by bouncing them off.
 */
public class Line {
  public float x1;
  public float y1;
  public float x2;
  public float y2;
  public final float mass = 100000000000000000000000000000000000000f;
  public float theta;
  public final float V = 0;
  public float len;

  Line(float x1, float y1, float x2, float y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    len = (float)Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
  }

  /**
   * Handles the collision and bouncing of a particle off this line boundary.
   * Calculates the closest point on the line to the particle and updates the
   * particle's velocity if a collision occurs.
   *
   * @param b the particle that may be bouncing off this line
   */
  public void bounceoff(Particle b) {
    float dot = (float)((((b.x + b.radius - x1) * (x2 - x1)) +
                         ((b.y + b.radius - y1) * (y2 - y1))) /
                        Math.pow(len, 2));
    float closestX = x1 + (dot * (x2 - x1));
    float closestY = y1 + (dot * (y2 - y1));
    float dis = (float)Math.sqrt(Math.pow(closestX - (b.radius + b.x), 2) +
                                 Math.pow(closestY - (b.radius + b.y), 2));
    if (dis < b.radius && isOnline(closestX, closestY)) {
      this.theta = (float)Math.atan2(0, 0);
      b.theta = (float)Math.atan2(b.yVel, b.xVel);
      b.V = (float)Math.sqrt(Math.pow(b.xVel, 2) + Math.pow(b.yVel, 2));
      float phi = (float)Math.atan2((b.y + b.radius - (closestY)),
                                    (b.x + b.radius - (closestX)));
      float totalm = this.mass + b.mass;
      float bthis = b.mass - this.mass;
      if (true) {

        b.xVel =
            (float)(((b.V * Math.cos(b.theta - phi) * bthis +
                      2 * this.mass * this.V * Math.cos(this.theta - phi)) /
                     totalm) *
                        Math.cos(phi) +
                    b.V * Math.sin(b.theta - phi) *
                        Math.cos(phi + (Math.PI / 2)));
        b.yVel =
            (float)(((b.V * Math.cos(b.theta - phi) * bthis +
                      2 * this.mass * this.V * Math.cos(this.theta - phi)) /
                     totalm) *
                        Math.sin(phi) +
                    b.V * Math.sin(b.theta - phi) *
                        Math.sin(phi + (Math.PI / 2)));
      }
    }
  }

  public boolean isOnline(float x, float y) {
    if (Math.min(x1, x2) <= x && x <= Math.max(x1, x2) &&
        Math.min(y1, y2) <= y && y <= Math.max(y1, y2)) {
      return true;
    }
    return false;
  }
}
