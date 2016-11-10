import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Snake extends JFrame implements KeyListener {

    private static Snake app;

    public Snake() {
        setSize(new Dimension(400, 200));
        setTitle("SnakeV1.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel choix = new Choix(this);
        getContentPane().add(choix, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Snake();
    }

    public void start(int nbFood, int gridX, int gridY) {

        getContentPane().removeAll();

        JPanel zoneDeJeu = new ZoneDeJeu(this, nbFood, gridX, gridY);
        addKeyListener(this);

        setFocusable(true);
        requestFocus();
        getContentPane().add(zoneDeJeu, BorderLayout.CENTER);
        setResizable(false);
        pack();
        validate();
    }

    public void end() {
        JPanel gameOver = new JPanel();
        JLabel perdu = new JLabel("Perdu ! Mais tu as attient le score de " + Serpent.nbFood);
        gameOver.add(perdu, BorderLayout.CENTER);
        getContentPane().removeAll();
        getContentPane().add(gameOver, BorderLayout.CENTER);
        validate();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Serpent.setDirection(KeyEvent.getKeyText(e.getKeyCode()));
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

}
