
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import java.util.regex.Matcher;

public class Serpent {

    private static int direction = 0;
    private Vector<Case> coordonnee;
    private int[][] grid;
    private ZoneDeJeu zoneDeJeu;
    private Snake snake;

    public Serpent(Snake snake, ZoneDeJeu zoneDeJeu, int[][] grid) {

        this.snake = snake;
        this.zoneDeJeu = zoneDeJeu;
        this.grid = grid;


        coordonnee = new Vector<Case>();
        coordonnee.add(new Case(2, 2));

        new Processus(this);

    }

    public static void setDirection(String keyText) {
        switch (keyText) {
            case "Haut":
                direction = 1;
                break;
            case "Bas":
                direction = 2;
                break;
            case "Gauche":
                direction = 3;
                break;
            case "Droite":
                direction = 4;
                break;
        }
    }

    public void deplacer() {

        if (grid[coordonnee.firstElement().getX()][coordonnee.firstElement().getY()] == 1) {
            coordonnee.add(new Case(coordonnee.lastElement().getX() + 1, coordonnee.lastElement().getY()));
            grid[coordonnee.firstElement().getX()][coordonnee.firstElement().getY()] = 0;
        } else if (grid[coordonnee.firstElement().getX()][coordonnee.firstElement().getY()] == 2) {
            snake.end();
        }

        switch (direction) {
            case 0:
                break;
            case 1:
                changeDirection(-1, 'y');
                break;
            case 2:
                changeDirection(+1, 'y');
                break;
            case 3:
                changeDirection(-1, 'x');
                break;
            case 4:
                changeDirection(+1, 'x');
                break;
        }

    }

    public void changeDirection(int dir, char axis){

        int coorX;
        int coorY;

        coorX = coordonnee.firstElement().getX();
        coorY = coordonnee.firstElement().getY();

        if(axis == 'x'){
            if(coordonnee.size() > 1)
                if(coorX == coordonnee.get(1).getX() - dir)
                    dir = opposit(dir);
            coorX += dir;
        }else{
            if(coordonnee.size() > 1)
                if(coorY == coordonnee.get(1).getY() - dir)
                    dir = opposit(dir);
            coorY += dir;
        }

        coordonnee.remove(coordonnee.lastElement());
        coordonnee.add(0, new Case(coorX, coorY));
    }

    public int opposit(int nb) {

        int result;

        if (nb > 0) {
            result = nb - (nb + 1);
        } else {
            result = Math.abs(nb);
        }

        return result;
    }

    public void dessiner(Graphics g) {

        for (int i = 0; i < coordonnee.size(); i++) {
            coordonnee.get(i).dessiner(g);
        }

    }

    public void repaint() {
        zoneDeJeu.repaint();
    }


}
