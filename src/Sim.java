import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * Main simulation class for a 2D Particle Collision Simulator.
 * Sets up a graphical interface using Swing to define simulation parameters
 * (e.g. particle size, mass, velocity) and then runs the physics simulation
 * displaying bouncing and colliding particles.
 */
public class Sim extends JPanel implements ActionListener {
  private static final long serialVersionUID = 1L;
  Timer t1 = new Timer(18, this);
  static SecureRandom sr = new SecureRandom();
  static int numOfLines = 30;
  static int numOfParticles = 10;
  static int velocityRange = 7;
  static int sx = 0;
  static Particle[] particles = new Particle[numOfParticles];
  static Dimension d;
  static Line[] lines = new Line[numOfLines];

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < numOfParticles; i++) {
      switch (i + 1) {
      case 1:
        g.setColor(Color.RED);
        break;
      case 2:
        g.setColor(Color.BLUE);
        break;
      case 3:
        g.setColor(Color.CYAN);
        break;
      case 4:
        g.setColor(Color.GREEN);
        break;
      case 5:
        g.setColor(Color.ORANGE);
        break;
      case 6:
        g.setColor(Color.YELLOW);
        break;
      case 7:
        g.setColor(Color.PINK);
        break;
      case 8:
        g.setColor(Color.MAGENTA);
        break;
      case 9:
        g.setColor(Color.WHITE);
        break;
      case 10:
        g.setColor(Color.GRAY);
      }
      g.drawString(Integer.toString(i + 1), (int)particles[i].x,
                   (int)particles[i].y);
      g.fillOval((int)particles[i].x, (int)particles[i].y,
                 (int)particles[i].radius * 2, (int)particles[i].radius * 2);
    }
    g.setColor(Color.WHITE);
    if (numOfLines != 0) {
      for (int i = 0; i < numOfLines; i++) {
        g.drawLine((int)lines[i].x1, (int)lines[i].y1, (int)lines[i].x2,
                   (int)lines[i].y2);
      }
    }
    t1.start();
  }

  public Sim(int x, int y) {
    numOfParticles = x;
    numOfLines = y;
  }

  /**
   * Entry point of the application.
   * Initializes the settings GUI where the user configures simulation parameters,
   * handles input, and eventually starts the physics simulation window.
   */
  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setTitle("Simulation");
    JFrame settings = new JFrame();
    settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    settings.setTitle("Settings");
    JPanel setP = new JPanel();
    setP.setBackground(Color.LIGHT_GRAY);
    settings.setSize(400, 500);
    setP.setSize(400, 500);
    setP.setLayout(null);
    settings.setResizable(false);
    settings.setLocationRelativeTo(null);
    settings.getContentPane().remove(settings);

    JTextField tf = new JTextField("Height", 4);
    tf.setBounds(120, 5, 55, 20);
    JTextField tf2 = new JTextField("Width", 4);
    tf2.setBounds(40, 5, 55, 20);
    JTextField tf3 = new JTextField("Number Of Particles", 11);
    tf3.setBounds(200, 5, 155, 20);
    tf.setFont(new Font("Helvetica", Font.BOLD, 14));
    tf2.setFont(new Font("Helvetica", Font.BOLD, 14));
    tf3.setFont(new Font("Helvetica", Font.BOLD, 14));

    JTextField pos1 = new JTextField();
    JTextField pos11 = new JTextField();
    JTextField pos2 = new JTextField();
    JTextField pos22 = new JTextField();
    JTextField pos3 = new JTextField();
    JTextField pos33 = new JTextField();
    JTextField pos4 = new JTextField();
    JTextField pos44 = new JTextField();
    JTextField pos5 = new JTextField();
    JTextField pos55 = new JTextField();
    JTextField pos6 = new JTextField();
    JTextField pos66 = new JTextField();
    JTextField pos7 = new JTextField();
    JTextField pos77 = new JTextField();
    JTextField pos8 = new JTextField();
    JTextField pos88 = new JTextField();
    JTextField pos9 = new JTextField();
    JTextField pos99 = new JTextField();
    JTextField pos10 = new JTextField();
    JTextField pos1010 = new JTextField();

    JLabel j1 = new JLabel("XVelocity");
    j1.setForeground(Color.BLUE);
    j1.setBounds(20, 65, 105, 15);
    JLabel j2 = new JLabel("YVelocity");
    j2.setForeground(Color.YELLOW);
    j2.setBounds(85, 65, 105, 15);
    JLabel j3 = new JLabel("Mass");
    j3.setForeground(Color.BLACK);
    j3.setBounds(160, 65, 105, 15);
    JLabel j4 = new JLabel("Radius");
    j4.setForeground(Color.RED);
    j4.setBounds(220, 65, 105, 15);
    JLabel j5 = new JLabel("X");
    j5.setForeground(Color.MAGENTA);
    j5.setBounds(295, 65, 105, 15);
    JLabel j6 = new JLabel("Y");
    j6.setForeground(Color.MAGENTA);
    j6.setBounds(345, 65, 105, 15);

    JLabel j10 = new JLabel("1");
    j10.setBounds(5, 90, 15, 15);
    JTextField tf11 = new JTextField();
    tf11.setBounds(20, 90, 55, 20);
    JTextField tf12 = new JTextField();
    tf12.setBounds(85, 90, 55, 20);
    JTextField tf13 = new JTextField();
    tf13.setBounds(150, 90, 55, 20);
    JTextField tf14 = new JTextField();
    tf14.setBounds(215, 90, 55, 20);
    pos1.setBounds(280, 90, 40, 20);
    pos11.setBounds(330, 90, 40, 20);

    JLabel j20 = new JLabel("2");
    j20.setBounds(5, 115, 15, 15);
    JTextField tf21 = new JTextField();
    tf21.setBounds(20, 115, 55, 20);
    JTextField tf22 = new JTextField();
    tf22.setBounds(85, 115, 55, 20);
    JTextField tf23 = new JTextField();
    tf23.setBounds(150, 115, 55, 20);
    JTextField tf24 = new JTextField();
    tf24.setBounds(215, 115, 55, 20);
    pos2.setBounds(280, 115, 40, 20);
    pos22.setBounds(330, 115, 40, 20);

    JLabel j30 = new JLabel("3");
    j30.setBounds(5, 140, 15, 15);
    JTextField tf31 = new JTextField();
    tf31.setBounds(20, 140, 55, 20);
    JTextField tf32 = new JTextField();
    tf32.setBounds(85, 140, 55, 20);
    JTextField tf33 = new JTextField();
    tf33.setBounds(150, 140, 55, 20);
    JTextField tf34 = new JTextField();
    tf34.setBounds(215, 140, 55, 20);
    pos3.setBounds(280, 140, 40, 20);
    pos33.setBounds(330, 140, 40, 20);

    JLabel j40 = new JLabel("4");
    j40.setBounds(5, 165, 15, 15);
    JTextField tf41 = new JTextField();
    tf41.setBounds(20, 165, 55, 20);
    JTextField tf42 = new JTextField();
    tf42.setBounds(85, 165, 55, 20);
    JTextField tf43 = new JTextField();
    tf43.setBounds(150, 165, 55, 20);
    JTextField tf44 = new JTextField();
    tf44.setBounds(215, 165, 55, 20);
    pos4.setBounds(280, 165, 40, 20);
    pos44.setBounds(330, 165, 40, 20);

    JLabel j50 = new JLabel("5");
    j50.setBounds(5, 190, 15, 15);
    JTextField tf51 = new JTextField();
    tf51.setBounds(20, 190, 55, 20);
    JTextField tf52 = new JTextField();
    tf52.setBounds(85, 190, 55, 20);
    JTextField tf53 = new JTextField();
    tf53.setBounds(150, 190, 55, 20);
    JTextField tf54 = new JTextField();
    tf54.setBounds(215, 190, 55, 20);
    pos5.setBounds(280, 190, 40, 20);
    pos55.setBounds(330, 190, 40, 20);

    JLabel j60 = new JLabel("6");
    j60.setBounds(5, 215, 15, 15);
    JTextField tf61 = new JTextField();
    tf61.setBounds(20, 215, 55, 20);
    JTextField tf62 = new JTextField();
    tf62.setBounds(85, 215, 55, 20);
    JTextField tf63 = new JTextField();
    tf63.setBounds(150, 215, 55, 20);
    JTextField tf64 = new JTextField();
    tf64.setBounds(215, 215, 55, 20);
    pos6.setBounds(280, 215, 40, 20);
    pos66.setBounds(330, 215, 40, 20);

    JLabel j70 = new JLabel("7");
    j70.setBounds(5, 240, 15, 15);
    JTextField tf71 = new JTextField();
    tf71.setBounds(20, 240, 55, 20);
    JTextField tf72 = new JTextField();
    tf72.setBounds(85, 240, 55, 20);
    JTextField tf73 = new JTextField();
    tf73.setBounds(150, 240, 55, 20);
    JTextField tf74 = new JTextField();
    tf74.setBounds(215, 240, 55, 20);
    pos7.setBounds(280, 240, 40, 20);
    pos77.setBounds(330, 240, 40, 20);

    JLabel j80 = new JLabel("8");
    j80.setBounds(5, 265, 15, 15);
    JTextField tf81 = new JTextField();
    tf81.setBounds(20, 265, 55, 20);
    JTextField tf82 = new JTextField();
    tf82.setBounds(85, 265, 55, 20);
    JTextField tf83 = new JTextField();
    tf83.setBounds(150, 265, 55, 20);
    JTextField tf84 = new JTextField();
    tf84.setBounds(215, 265, 55, 20);
    pos8.setBounds(280, 265, 40, 20);
    pos88.setBounds(330, 265, 40, 20);

    JLabel j90 = new JLabel("9");
    j90.setBounds(5, 290, 15, 15);
    JTextField tf91 = new JTextField();
    tf91.setBounds(20, 290, 55, 20);
    JTextField tf92 = new JTextField();
    tf92.setBounds(85, 290, 55, 20);
    JTextField tf93 = new JTextField();
    tf93.setBounds(150, 290, 55, 20);
    JTextField tf94 = new JTextField();
    tf94.setBounds(215, 290, 55, 20);
    pos9.setBounds(280, 290, 40, 20);
    pos99.setBounds(330, 290, 40, 20);

    JLabel j100 = new JLabel("10");
    j100.setBounds(5, 315, 15, 15);
    JTextField tf101 = new JTextField();
    tf101.setBounds(20, 315, 55, 20);
    JTextField tf102 = new JTextField();
    tf102.setBounds(85, 315, 55, 20);
    JTextField tf103 = new JTextField();
    tf103.setBounds(150, 315, 55, 20);
    JTextField tf104 = new JTextField();
    tf104.setBounds(215, 315, 55, 20);
    pos10.setBounds(280, 315, 40, 20);
    pos1010.setBounds(330, 315, 40, 20);

    JCheckBox def = new JCheckBox("All Default");
    def.setBounds(20, 340, 84, 20);

    JCheckBox load = new JCheckBox("Load: ");
    load.setBounds(20, 370, 60, 20);
    JTextField loadd = new JTextField();
    loadd.setBounds(80, 370, 280, 20);

    JCheckBox loadLines = new JCheckBox("Load Lines: ");
    loadLines.setBounds(20, 430, 95, 20);
    JTextField loadL = new JTextField();
    loadL.setBounds(115, 430, 245, 20);

    JCheckBox save = new JCheckBox("Save: ");
    save.setBounds(20, 400, 60, 20);
    JTextField saved = new JTextField();
    saved.setBounds(80, 400, 280, 20);

    JCheckBox jCh = new JCheckBox("All Radius Same As 1st");
    jCh.setBounds(210, 340, 160, 20);

    JButton bt = new JButton("Start The Simulation");
    bt.setBackground(Color.BLACK);
    bt.setForeground(Color.RED);
    bt.setFont(new Font("serif", Font.BOLD, 20));
    bt.setBounds(20, 30, 350, 30);

    setP.add(loadLines);
    setP.add(loadL);
    setP.add(j5);
    setP.add(j6);

    setP.add(pos1010);
    setP.add(pos99);
    setP.add(pos88);
    setP.add(pos77);
    setP.add(pos66);
    setP.add(pos55);
    setP.add(pos44);
    setP.add(pos33);
    setP.add(pos22);
    setP.add(pos11);
    setP.add(pos1);
    setP.add(pos2);
    setP.add(pos3);
    setP.add(pos4);
    setP.add(pos5);
    setP.add(pos6);
    setP.add(pos7);
    setP.add(pos8);
    setP.add(pos9);
    setP.add(pos10);

    setP.add(saved);
    setP.add(save);
    setP.add(loadd);
    setP.add(load);

    setP.add(def);
    setP.add(jCh);

    setP.add(tf104);
    setP.add(tf103);
    setP.add(tf102);
    setP.add(tf101);
    setP.add(j100);

    setP.add(tf94);
    setP.add(tf93);
    setP.add(tf92);
    setP.add(tf91);
    setP.add(j90);

    setP.add(tf84);
    setP.add(tf83);
    setP.add(tf82);
    setP.add(tf81);
    setP.add(j80);

    setP.add(tf74);
    setP.add(tf73);
    setP.add(tf72);
    setP.add(tf71);
    setP.add(j70);

    setP.add(tf64);
    setP.add(tf63);
    setP.add(tf62);
    setP.add(tf61);
    setP.add(j60);

    setP.add(tf54);
    setP.add(tf53);
    setP.add(tf52);
    setP.add(tf51);
    setP.add(j50);

    setP.add(tf44);
    setP.add(tf43);
    setP.add(tf42);
    setP.add(tf41);
    setP.add(j40);

    setP.add(tf24);
    setP.add(tf23);
    setP.add(tf22);
    setP.add(tf21);
    setP.add(j20);

    setP.add(tf34);
    setP.add(tf33);
    setP.add(tf32);
    setP.add(tf31);
    setP.add(j30);

    setP.add(tf3);
    setP.add(tf2);
    setP.add(tf);
    setP.add(bt);
    setP.add(j1);
    setP.add(j2);
    setP.add(j3);
    setP.add(j4);

    setP.add(j10);
    setP.add(tf11);
    setP.add(tf12);
    setP.add(tf13);
    setP.add(tf14);

    settings.add(setP);
    settings.setVisible(true);
    bt.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        float[] xl = new float[10];
        float[] yl = new float[10];
        float[] massl = new float[10];
        float[] radiusl = new float[10];
        float[] xvell = new float[10];
        float[] yvell = new float[10];
        int[] flagl = new int[10];
        int X = 200, Y = 200, a = 1;
        if (def.isSelected()) {
          X = 800;
          Y = 1200;
          a = 10;
        } else if (!load.isSelected()) {
          X = Integer.parseInt(tf.getText());
          Y = Integer.parseInt(tf2.getText());
          a = Integer.parseInt(tf3.getText());
        } else if (load.isSelected()) {
          File f = new File(loadd.getText() + ".txt");
          Scanner loading;
          try {
            loading = new Scanner(f);
            Y = loading.nextInt();
            X = loading.nextInt();
            a = loading.nextInt();
            for (int i = 0; i < a; i++) {
              flagl[i]++;
              xvell[i] = loading.nextFloat();
              yvell[i] = loading.nextFloat();
              massl[i] = loading.nextFloat();
              radiusl[i] = loading.nextFloat();
              xl[i] = loading.nextFloat();
              yl[i] = loading.nextFloat();
            }
            loading.close();
          } catch (FileNotFoundException e1) {
          }
        }
        float[] mass = new float[a];
        float[] radius = new float[a];
        float[] xvel = new float[a];
        float[] yvel = new float[a];
        int[] flag = new int[a];
        float[] x = new float[a];
        float[] y = new float[a];
        if (load.isSelected()) {
          for (int i = 0; i < a; i++) {
            flag[i] = flagl[i];
            mass[i] = massl[i];
            radius[i] = radiusl[i];
            xvel[i] = xvell[i];
            yvel[i] = yvell[i];
            x[i] = xl[i];
            y[i] = yl[i];
          }
        }
        if (!(tf11.getText().equals("") || tf12.getText().equals("") ||
              tf13.getText().equals("") || tf14.getText().equals("") ||
              pos1.getText().equals("") || pos11.getText().equals(""))) {
          xvel[0] = Float.parseFloat(tf11.getText());
          yvel[0] = Float.parseFloat(tf12.getText());
          mass[0] = Float.parseFloat(tf13.getText());
          radius[0] = Float.parseFloat(tf14.getText());
          x[0] = Float.parseFloat(pos1.getText());
          y[0] = Float.parseFloat(pos11.getText());
          flag[0]++;
        }
        if (!(tf21.getText().equals("") || tf22.getText().equals("") ||
              tf23.getText().equals("") || tf24.getText().equals("") ||
              pos2.getText().equals("") || pos22.getText().equals(""))) {
          xvel[1] = Float.parseFloat(tf21.getText());
          yvel[1] = Float.parseFloat(tf22.getText());
          mass[1] = Float.parseFloat(tf23.getText());
          radius[1] = Float.parseFloat(tf24.getText());
          x[1] = Float.parseFloat(pos2.getText());
          y[1] = Float.parseFloat(pos22.getText());
          flag[1]++;
        }
        if (!(tf31.getText().equals("") || tf32.getText().equals("") ||
              tf33.getText().equals("") || tf34.getText().equals("") ||
              pos3.getText().equals("") || pos33.getText().equals(""))) {
          xvel[2] = Float.parseFloat(tf31.getText());
          yvel[2] = Float.parseFloat(tf32.getText());
          mass[2] = Float.parseFloat(tf33.getText());
          radius[2] = Float.parseFloat(tf34.getText());
          x[2] = Float.parseFloat(pos3.getText());
          y[2] = Float.parseFloat(pos33.getText());
          flag[2]++;
        }
        if (!(tf41.getText().equals("") || tf42.getText().equals("") ||
              tf43.getText().equals("") || tf44.getText().equals("") ||
              pos4.getText().equals("") || pos44.getText().equals(""))) {
          xvel[3] = Float.parseFloat(tf41.getText());
          yvel[3] = Float.parseFloat(tf42.getText());
          mass[3] = Float.parseFloat(tf43.getText());
          radius[3] = Float.parseFloat(tf44.getText());
          x[3] = Float.parseFloat(pos4.getText());
          y[3] = Float.parseFloat(pos44.getText());
          flag[3]++;
        }
        if (!(tf51.getText().equals("") || tf52.getText().equals("") ||
              tf53.getText().equals("") || tf54.getText().equals("") ||
              pos5.getText().equals("") || pos55.getText().equals(""))) {
          xvel[4] = Float.parseFloat(tf51.getText());
          yvel[4] = Float.parseFloat(tf52.getText());
          mass[4] = Float.parseFloat(tf53.getText());
          radius[4] = Float.parseFloat(tf54.getText());
          x[4] = Float.parseFloat(pos5.getText());
          y[4] = Float.parseFloat(pos55.getText());
          flag[4]++;
        }
        if (!(tf61.getText().equals("") || tf62.getText().equals("") ||
              tf63.getText().equals("") || tf64.getText().equals("") ||
              pos6.getText().equals("") || pos66.getText().equals(""))) {
          xvel[5] = Float.parseFloat(tf61.getText());
          yvel[5] = Float.parseFloat(tf62.getText());
          mass[5] = Float.parseFloat(tf63.getText());
          radius[5] = Float.parseFloat(tf64.getText());
          x[5] = Float.parseFloat(pos6.getText());
          y[5] = Float.parseFloat(pos66.getText());
          flag[5]++;
        }
        if (!(tf71.getText().equals("") || tf72.getText().equals("") ||
              tf73.getText().equals("") || tf74.getText().equals("") ||
              pos7.getText().equals("") || pos77.getText().equals(""))) {
          xvel[6] = Float.parseFloat(tf71.getText());
          yvel[6] = Float.parseFloat(tf72.getText());
          mass[6] = Float.parseFloat(tf73.getText());
          radius[6] = Float.parseFloat(tf74.getText());
          x[6] = Float.parseFloat(pos7.getText());
          y[6] = Float.parseFloat(pos77.getText());
          flag[6]++;
        }
        if (!(tf81.getText().equals("") || tf82.getText().equals("") ||
              tf83.getText().equals("") || tf84.getText().equals("") ||
              pos8.getText().equals("") || pos88.getText().equals(""))) {
          xvel[7] = Float.parseFloat(tf81.getText());
          yvel[7] = Float.parseFloat(tf82.getText());
          mass[7] = Float.parseFloat(tf83.getText());
          radius[7] = Float.parseFloat(tf84.getText());
          x[7] = Float.parseFloat(pos8.getText());
          y[7] = Float.parseFloat(pos88.getText());
          flag[7]++;
        }
        if (!(tf91.getText().equals("") || tf92.getText().equals("") ||
              tf93.getText().equals("") || tf94.getText().equals("") ||
              pos9.getText().equals("") || pos99.getText().equals(""))) {
          xvel[8] = Float.parseFloat(tf91.getText());
          yvel[8] = Float.parseFloat(tf92.getText());
          mass[8] = Float.parseFloat(tf93.getText());
          radius[8] = Float.parseFloat(tf94.getText());
          x[8] = Float.parseFloat(pos9.getText());
          y[8] = Float.parseFloat(pos99.getText());
          flag[8]++;
        }
        if (!(tf101.getText().equals("") || tf102.getText().equals("") ||
              tf103.getText().equals("") || tf104.getText().equals("") ||
              pos10.getText().equals("") || pos1010.getText().equals(""))) {
          xvel[9] = Float.parseFloat(tf101.getText());
          yvel[9] = Float.parseFloat(tf102.getText());
          mass[9] = Float.parseFloat(tf103.getText());
          radius[9] = Float.parseFloat(tf104.getText());
          x[9] = Float.parseFloat(pos10.getText());
          y[9] = Float.parseFloat(pos1010.getText());
          flag[9]++;
        }
        int numL = 0;
        if (loadLines.isSelected()) {
          File f3 = new File(loadL.getText() + ".txt");
          Scanner ll;
          try {
            ll = new Scanner(f3);
            numL = ll.nextInt();
            for (int i = 0; i < numL; i++) {
              lines[i] = new Line(ll.nextFloat(), ll.nextFloat(),
                                  ll.nextFloat(), ll.nextFloat());
            }
          } catch (FileNotFoundException e1) {
            e1.printStackTrace();
          }
        }
        Sim t = new Sim(a, numL);
        t.setBackground(Color.BLACK);
        t.setSize(Y, X);
        f.add(t);
        f.setSize(Y, X);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        d = new Dimension(f.getSize());
        for (int i = 0; i < numOfParticles; i++) {
          if (flag[i] == 1) {
            if (jCh.isSelected()) {
              radius[i] = radius[0];
            }
            particles[i] =
                new Particle(x[i], y[i], xvel[i], yvel[i], mass[i], radius[i]);
          } else {
            int rd;
            if (jCh.isSelected()) {
              rd = (int)radius[0];
            } else {
              rd = 10 + sr.nextInt(30);
            }
            radius[i] = rd;
            mass[i] = 10 + sr.nextInt(1000);
            yvel[i] = sr.nextInt(velocityRange) - (velocityRange / 2);
            xvel[i] = sr.nextInt(velocityRange) - (velocityRange / 2);
            x[i] = sr.nextInt(d.width - 15 - 2 * rd);
            y[i] = sr.nextInt(d.height - 35 - 2 * rd);
            particles[i] =
                new Particle(x[i], y[i], xvel[i], yvel[i], mass[i], radius[i]);
          }
        }
        if (save.isSelected()) {
          File f1 = new File(saved.getText() + ".txt");
          try {
            PrintStream save = new PrintStream(f1);
            save.print(Y + " ");
            save.print(X + " ");
            save.println(a);
            for (int i = 0; i < a; i++) {
              save.println(xvel[i] + " " + yvel[i] + " " + mass[i] + " " +
                           radius[i] + " " + x[i] + " " + y[i]);
            }
            save.close();
          } catch (FileNotFoundException e1) {
            e1.printStackTrace();
          }
        }
        f.setVisible(true);
      }
    });
  }

  /**
   * The main simulation loop triggered by the Swing Timer.
   * Updates physics states for all particles including movement, wall collisions,
   * particle-to-particle collisions, and boundary line collisions, then redraws the scene.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < numOfParticles; i++) {
      if (sx == 0) {
        particles[i].bounceOffXWall();
        particles[i].bounceOffYWall();
        particles[i].bounceOffXWall();
        particles[i].bounceOffYWall();
        sx++;
      }
      if (particles[i].x < 0 ||
          particles[i].x > d.width - 15 - 2 * particles[i].radius) {
        particles[i].bounceOffXWall();
      }
      if (particles[i].y < 0 ||
          particles[i].y > d.height - 35 - 2 * particles[i].radius) {
        particles[i].bounceOffYWall();
      }
      for (int j = i + 1; j < numOfParticles; j++) {
        particles[i].collide(particles[j]);
      }
      if (numOfLines != 0) {
        for (int j = 0; j < numOfLines; j++) {
          lines[j].bounceoff(particles[i]);
        }
      }
      particles[i].move();
    }
    repaint();
  }
}
