
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Serpent {

    private static int direction = 3;
    private Vector<Case> coordonnee;
    private boolean[][] grid;
    private ZoneDeJeu zoneDeJeu;
    private Snake snake;

    public Serpent(Snake snake, ZoneDeJeu zoneDeJeu, boolean[][] grid) {

        this.snake = snake;
        this.zoneDeJeu = zoneDeJeu;
        this.grid = grid;


        coordonnee = new Vector<Case>();
        coordonnee.add(new Case(0, 0));

        new Processus(this);

    }

    public static void setDirection(String keyText) {
        switch (keyText) {
            case "Haut":
                direction = 0;
                break;
            case "Bas":
                direction = 1;
                break;
            case "Gauche":
                direction = 2;
                break;
            case "Droite":
                direction = 3;
                break;
        }
    }

    public void deplacer() {

        if (grid[coordonnee.firstElement().getX()][coordonnee.firstElement().getY()] == true) {
            coordonnee.add(new Case(coordonnee.lastElement().getX() + 1, coordonnee.lastElement().getY()));
            grid[coordonnee.firstElement().getX()][coordonnee.firstElement().getY()] = false;
        } else if (coordonnee.firstElement().getX() == coordonnee.lastElement().getX() && coordonnee.lastElement().getX() == coordonnee.firstElement().getY() && coordonnee.size() > 1) {
            snake.end();
        } else if (grid[coordonnee.firstElement().getX()][coordonnee.firstElement().getY()]) {
            snake.end();
        }


        switch (direction) {
            case 0:
                changeDirection(-1, 'y');
                break;
            case 1:
                changeDirection(+1, 'y');
                break;
            case 2:
                changeDirection(-1, 'x');
                break;
            case 3:
                changeDirection(+1, 'x');
                break;
        }

    }

    public void changeDirection(int dir, char axis) {


        if (coordonnee.size() > 1) {
            if (axis == 'y') {
                if (coordonnee.firstElement().getY() + dir == coordonnee.get(1).getY()) {
                    coordonnee.remove(coordonnee.lastElement());
                    coordonnee.add(0, new Case(coordonnee.firstElement().getX(), coordonnee.firstElement().getY() + opposit(dir)));
                } else {
                    coordonnee.remove(coordonnee.lastElement());
                    coordonnee.add(0, new Case(coordonnee.firstElement().getX(), coordonnee.firstElement().getY() + dir));
                }
            } else if (axis == 'x') {
                if (coordonnee.firstElement().getX() + dir == coordonnee.get(1).getX()) {
                    coordonnee.remove(coordonnee.lastElement());
                    coordonnee.add(0, new Case(coordonnee.firstElement().getX() + opposit(dir), coordonnee.firstElement().getY()));
                } else {
                    coordonnee.remove(coordonnee.lastElement());
                    coordonnee.add(0, new Case(coordonnee.firstElement().getX() + dir, coordonnee.firstElement().getY()));
                }
            }
        } else {
            if (axis == 'y') {
                for (int i = 0; i < coordonnee.size(); i++) {
                    coordonnee.get(i).setY(coordonnee.get(i).getY() + dir);
                }

            } else if (axis == 'x') {

                for (int i = 0; i < coordonnee.size(); i++) {
                    coordonnee.get(i).setX(coordonnee.get(i).getX() + dir);
                }
            }
        }
    }

    public int opposit(int nb) {

        int result;

        if (nb > 0) {
            result = nb - (nb + 1);
        } else {
            result = nb + (nb + 1);
        }

        return result;
    }

    public void dessiner(Graphics g) {

        for (int i = 0; i < coordonnee.size(); i++) {
            g.setColor(Color.green);
            g.fillRect(coordonnee.get(i).getX() * 20, coordonnee.get(i).getY() * 20, 20, 20);
        }

    }

    public void repaint() {
        zoneDeJeu.repaint();
    }


}
