package main.GUI;
import javax.swing.JFrame;


public class Game extends JFrame{
    public static Game game = new Game();
    public Game() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Michael Vs. Lalapan");

        Map map = new Map();
        window.add(map);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        map.startGameThread();
    }

    public static Game startGame() {
        return game;
    }
}