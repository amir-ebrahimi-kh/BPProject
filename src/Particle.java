
/**
 * Represents a circular moving particle in the 2D physics simulation.
 * Particles have position, velocity, mass, and radius, and can collide with
 * other particles and boundaries.
 */
public class Particle {
  public float x;
  public float y;
  public float xVel;
  public float yVel;
  public float mass;
  public float radius;
  public float theta;
  public float V;

  Particle(float x, float y, float xVel, float yVel, float m, float r) {
    this.x = x;
    this.y = y;
    this.xVel = xVel;
    this.yVel = yVel;
    this.mass = m;
    this.radius = r;
  }

  public void move() {
    x += xVel;
    y += yVel;
  }

  public void collide(Particle b) {
    float distancesq = (this.x + this.radius - (b.x + b.radius)) *
                           (this.x + this.radius - (b.x + b.radius)) +
                       (this.y + this.radius - (b.y + b.radius)) *
                           (this.y + this.radius - (b.y + b.radius));
    float radssq = (this.radius + b.radius) * (this.radius + b.radius);
    if (distancesq < radssq) {
      this.theta = (float)Math.atan2(this.yVel, this.xVel);
      this.V =
          (float)Math.sqrt(Math.pow(this.xVel, 2) + Math.pow(this.yVel, 2));
      b.theta = (float)Math.atan2(b.yVel, b.xVel);
      b.V = (float)Math.sqrt(Math.pow(b.xVel, 2) + Math.pow(b.yVel, 2));

      float phi = (float)Math.atan2((b.y + b.radius - (this.y + this.radius)),
                                    (b.x + b.radius - (this.x + this.radius)));
      float totalm = this.mass + b.mass;
      float thisb = this.mass - b.mass;
      float bthis = b.mass - this.mass;

      this.xVel = (float)(((this.V * Math.cos(this.theta - phi) * thisb +
                            2 * b.mass * b.V * Math.cos(b.theta - phi)) /
                           totalm) *
                              Math.cos(phi) +
                          this.V * Math.sin(this.theta - phi) *
                              Math.cos(phi + (Math.PI / 2)));
      this.yVel = (float)(((this.V * Math.cos(this.theta - phi) * thisb +
                            2 * b.mass * b.V * Math.cos(b.theta - phi)) /
                           totalm) *
                              Math.sin(phi) +
                          this.V * Math.sin(this.theta - phi) *
                              Math.sin(phi + (Math.PI / 2)));
      b.xVel = (float)(((b.V * Math.cos(b.theta - phi) * bthis +
                         2 * this.mass * this.V * Math.cos(this.theta - phi)) /
                        totalm) *
                           Math.cos(phi) +
                       b.V * Math.sin(b.theta - phi) *
                           Math.cos(phi + (Math.PI / 2)));
      b.yVel = (float)(((b.V * Math.cos(b.theta - phi) * bthis +
                         2 * this.mass * this.V * Math.cos(this.theta - phi)) /
                        totalm) *
                           Math.sin(phi) +
                       b.V * Math.sin(b.theta - phi) *
                           Math.sin(phi + (Math.PI / 2)));
    }
  }

  public void bounceOffXWall() { xVel *= -1f; }

  public void bounceOffYWall() { yVel *= -1f; }
}
