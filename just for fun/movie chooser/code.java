import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
public class MoviePick {
    public static void main(String args[]) throws IOException {



        MoviePick.CreateWindow();
        //System.out.println(movie);
    }

    private static void CreateWindow() {
        JFrame moviepicker = new JFrame("Movie Picker");
        moviepicker.setLayout(null);
        moviepicker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        moviepicker.setSize(1080,720);
        //moviepicker.pack();
        JButton pick = new JButton("Pick Movie");
        pick.setBounds((moviepicker.getWidth()-125),(int)(moviepicker.getHeight()/2),100,45);
        JLabel Movie = new JLabel("Movie");
        Movie.setBounds(25, 100, 800, 300);
        Movie.setFont(new Font("Comic Sans",Font.PLAIN, 50));
        moviepicker.add(Movie);
        moviepicker.add(pick);
        moviepicker.setVisible(true);

        pick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String movie = null;
                try {
                    movie = MoviePick.choose();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Movie.setText(movie);
            }
        });
    }



    private static String choose() throws IOException {

        //Create an arraylist that contains all the movies we've seen
        Scanner Tracer2 = new Scanner(new File("C://Users/gifte/Desktop/Seen.txt"));
        String end = "";
        while (Tracer2.hasNext()) {
            end = end + "\r\n" + Tracer2.nextLine();
        }
        System.out.println(end);
        //System.out.println(Seen.size());




        //creates arraylist of movies
        Scanner Tracer = new Scanner(new File("C://Users/gifte/Desktop/Movies.txt"));
        ArrayList movies = new ArrayList();
        String mov = "";
        while (Tracer.hasNext()) {
            movies.add(Tracer.nextLine());;
        }
        for(int i = 0; i < movies.size(); i ++) {
            mov = mov + movies.get(i) + "\r\n" ;
        }

        //create the file writer
        FileWriter pp = new FileWriter("C://Users/gifte/Desktop/Seen.txt");
        FileWriter poopoo = new FileWriter("C://Users/gifte/Desktop/Movies.txt");

        //finds a random number and puts the movie into a string
        int number = (int) (movies.size() * Math.random());
        System.out.println(number);
            String movie = (String) (movies.get(number));


        System.out.println("");

        //section that tests if we've already seen it or if its a series what movie in the series to watch
        int movienum = 1;
            pp.write(end + movie);
            pp.close();
            System.out.println(mov);
            mov = mov.substring(0,mov.indexOf(movie))+mov.substring(mov.indexOf(movie) + movie.length()+2);
            System.out.println(mov);
            poopoo.write(mov);
            poopoo.close();
            return(movie);
    }
}