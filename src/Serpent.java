

import java.awt.Graphics;
import java.util.Vector;

import Case.Case;

public class Serpent {

    private static Key direction = Key.NONE;
    private Vector<Case> coordonnee;
    private int[][] grid;
    private ZoneDeJeu zoneDeJeu;
    private Snake snake;
    public static int nbFood;

    public Serpent(Snake snake, ZoneDeJeu zoneDeJeu, int[][] grid) {

        this.snake = snake;
        this.zoneDeJeu = zoneDeJeu;
        this.grid = grid;

        coordonnee = new Vector<Case>();
        coordonnee.add(new Case(2, 2));

        new Processus(this);

    }

    public static void setDirection(Key key) {
        direction = key;
    }

    public void deplacer() {

        if (grid[coordonnee.firstElement().getX()][coordonnee.firstElement().getY()] == 1) {
            coordonnee.add(new Case(coordonnee.lastElement().getX() + 1, coordonnee.lastElement().getY()));
            grid[coordonnee.firstElement().getX()][coordonnee.firstElement().getY()] = 0;
            zoneDeJeu.getTerrain().newFood();
            this.nbFood += 1;
        } else if (grid[coordonnee.firstElement().getX()][coordonnee.firstElement().getY()] == 2) {
            snake.end();
        } else if (mordreLaQueue()) {
            snake.end();
        }

        switch (direction) {
            case UP:
                changeDirection(-1, 'y');
                break;
            case DOWN:
                changeDirection(+1, 'y');
                break;
            case LEFT:
                changeDirection(-1, 'x');
                break;
            case RIGHT:
                changeDirection(+1, 'x');
                break;
            default:
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

    public boolean mordreLaQueue(){

        int x = coordonnee.firstElement().getX();
        int y = coordonnee.firstElement().getY();
        boolean result = false;

        if(coordonnee.size() > 1)
            for(int i = 1; i < coordonnee.size(); i++)
                if(x == coordonnee.get(i).getX() && y == coordonnee.get(i).getY())
                    result = true;

        return result;
    }

}
