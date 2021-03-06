
import Case.Border;
import Case.Food;

import java.awt.Color;
import java.awt.Graphics;

public class Terrain {

    private int[][] grid;
    private int gridX;
    private int gridY;
    private int nbFood;

    public Terrain(int nbFood, int gridX, int gridY) {

        this.gridX = gridX;
        this.gridY = gridY;
        this.nbFood = nbFood;

        constructGrid();

    }

    public void constructGrid(){

        grid = new int[gridX][gridY];

        for(int i=0; i < gridX; i++){
            for (int j = 0; j < gridY; j++) {
                grid[i][j] = 0;
            }
        }

        for(int k=1; k < (gridX-1); k++){
            grid[k][1] = 2;
            grid[k][gridY-2] = 2;
        }

        for(int h=1; h < (gridY-1); h++){
            grid[1][h] = 2;
            grid[gridX-2][h] = 2;
        }

        newFood();

    }

    public void newFood(){
        int x = alea(1, gridX-1);
        int y = alea(1, gridY-1);

        if (grid[x][y] == 0) {
            grid[x][y] = 1;
        }else{
            newFood();
        }
    }

    public void dessiner(Graphics g) {
        for (int i = 0; i < gridX; i++) {
            for (int j = 0; j < gridY; j++) {
                if (grid[i][j] == 1) {
                    new Food(i, j, g);
                }else if(grid[i][j] == 2){
                    new Border(i, j, g);
                }
            }
        }
    }

    public int alea(int min, int max) {
        return min + (int) (Math.random() * ((max - min)));
    }

    public int[][] getGrid() {
        return grid;
    }


}
