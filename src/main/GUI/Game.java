package main.GUI;
import javax.swing.JFrame;


public class Game extends JFrame{
    public static Game game = new Game();
    public Game() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Michael Vs. Lalapan");

        WindowPanel wp = new WindowPanel();
        window.add(wp);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        wp.setUp();

        wp.startGameThread();
    }

    public static Game startGame() {
        return game;
    }
}