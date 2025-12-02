package Game;

import java.awt.*;
import java.awt.event.*;


public class BallWorld extends Frame implements Runnable {

    
    public static final int FrameWidth = 400;
    public static final int FrameHeight = 300;

    private Ball aBall;
    private int counter = 0;
    private Thread animator; 
    private static class Ball {
        private int x = 50, y = 50, radius = 20;
        private int xMotion = 3, yMotion = 3;
        private Color color;

        public Ball() {
           
        }

        public void setColor(Color ballColor) {
            this.color = ballColor;
        }

        public void setMotion(int xM, int yM) {
            this.xMotion = xM;
            this.yMotion = yM;
        }

        public void move() {
            x += xMotion;
            y += yMotion;
        }

        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, radius * 2, radius * 2);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getSize() {
            return radius * 2;
        }

        public int getXMotion() {
            return xMotion;
        }

        public int getYMotion() {
            return yMotion;
        }

       
        public void reverseMotion(int newXMotion, int newYMotion) {
            this.xMotion = newXMotion;
            this.yMotion = newYMotion;
        }
    }
   
    public BallWorld(Color ballColor) {
        
        setSize(FrameWidth, FrameHeight);
        setTitle("Ball World");

      
        aBall = new Ball();
        aBall.setColor(ballColor);
        aBall.setMotion(5, 5); 

        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        
        animator = new Thread(this);
        animator.start();
    }

    
    public static void main(String[] args) {
        BallWorld world = new BallWorld(Color.red);
        world.setVisible(true); 
    }

   
    @Override
    public void run() {
        while (counter < 500) { 
            repaint();
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            counter++;
        }
        System.exit(0);
    }

  
    public void paint(Graphics g) {
        // 1️⃣ Draw the ball
        aBall.paint(g);

        // 2️⃣ Move it slightly
        aBall.move();

        // 3️⃣ Boundary Check and Bouncing Logic
        boolean bounced = false;

        // Check horizontal walls (Left: 0, Right: FrameWidth)
        if (aBall.getX() <= 0 || aBall.getX() + aBall.getSize() >= FrameWidth) {
            aBall.reverseMotion(-aBall.getXMotion(), aBall.getYMotion());
            bounced = true;
        }

        // Check vertical walls (Top: 0, Bottom: FrameHeight)
        // We account for the frame's title bar by using getInsets().top
        Insets insets = getInsets();
        int safeFrameHeight = FrameHeight - insets.top;

        if (aBall.getY() <= insets.top || aBall.getY() + aBall.getSize() >= safeFrameHeight) {
            aBall.reverseMotion(aBall.getXMotion(), -aBall.getYMotion());
            bounced = true;
        }

        // 4️⃣ Finally, redraw the frame is handled by the run() method's repaint()
    }
}
