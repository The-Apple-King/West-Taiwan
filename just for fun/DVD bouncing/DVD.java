import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class DVD extends JPanel{

    double angleInRadians = 0;
    Color backgroundColor = new Color(255,255,255);
    Color squareColor = new Color(0,0,0);

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(backgroundColor); // Use the current background color
        g2d.fillRect(0, 0, getWidth(), getHeight());

        AffineTransform old = g2d.getTransform();
        g2d.rotate(angleInRadians, 60, 50); // Rotate around the center of the rectangle
        g2d.setColor(squareColor); // Set the color to red
        g2d.fillRect(35, 25, 50, 50); // Fill the rectangle
        g2d.setTransform(old);
        angleInRadians += 0.1; // This will control the speed of rotation
    }

    public static void main(String[] args){
        int right = 1;
        int up = 1;
        int speed = 12;
        Random rand = new Random();


        JFrame wall = new JFrame();
        wall.setVisible(true);
        wall.setTitle("Practice");
        wall.setSize(100, 150);
        wall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wall.setVisible(true);
        DVD rect = new DVD();
        wall.getContentPane().add(rect);
        
        GraphicsDevice gd = wall.getGraphicsConfiguration().getDevice();
        int width = gd.getDisplayMode().getWidth() - wall.getSize().width;
        int height = gd.getDisplayMode().getHeight() - wall.getSize().height;
        wall.setLocation(rand.nextInt(width), rand.nextInt(height));

        boolean blah = true;

        while(blah) {
            try {
                TimeUnit.MILLISECONDS.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // get current position
            int x = wall.getLocation().x;
            int y = wall.getLocation().y;

            
            if(x >= width || x <= 0){
                right *= -1;
                rect.backgroundColor = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
                rect.squareColor = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
                System.out.println(wall.getLocationOnScreen());
            }
            if(y >= height || y <= 0){
                up *= -1;
                rect.backgroundColor = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
                rect.squareColor = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
                System.out.println(wall.getLocationOnScreen());
            }
            
            if ((x > width || x < 0) && (y > height || y < 0)) {
                try {
                    File soundFile = new File("C:\\Users\\TheAppleKing\\Documents\\Projects\\just for fun\\DVD bouncing\\1_up.wav"); // your .wav file
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
                    
                    // Get a sound clip resource.
                    Clip clip = AudioSystem.getClip();
                    
                    // Open audio clip and load samples from the audio input stream.
                    clip.open(audioIn);
                    clip.start();
                }catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
                blah = false;
            }
            
            rect.repaint();
            wall.setLocation((x + (speed * right)), (y + (speed * up)));
        }
    }
}
