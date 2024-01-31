import javax.swing.*;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class DVD extends JFrame{
    public static void main(String[] args){
        int right = 1;
        int up = 1;
        int speed = 5;
        Random rand = new Random();


        JFrame wall = new JFrame();
        wall.setVisible(true);
        wall.setTitle("Practice");
        wall.setSize(100, 100);
        wall.setLocation(100, 100);
        wall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wall.setVisible(true);

        GraphicsDevice gd = wall.getGraphicsConfiguration().getDevice();
        int width = gd.getDisplayMode().getWidth() - wall.getSize().width;
        int height = gd.getDisplayMode().getHeight() - wall.getSize().height;

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
                wall.getContentPane().setBackground(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
                System.out.println(wall.getLocationOnScreen());
            }
            if(y >= height || y <= 0){
                up *= -1;
                wall.getContentPane().setBackground(new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
                System.out.println(wall.getLocationOnScreen());
            }

            if ((x > width || x < 0) && (y > height || y < 0)) {
                blah = false;
            }

            wall.setLocation((x + (speed * right)), (y + (speed * up)));
        }
    }
}
