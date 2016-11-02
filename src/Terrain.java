
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
        int nbFoodCreate = 0;

        for(int i=0; i < gridX; i++){
            for (int j = 0; j < gridY; j++) {
                grid[i][j] = 0;
            }
        }

        for(int k=0; k < gridX; k++){
            grid[k][0] = 2;
            grid[k][gridY-1] = 2;
        }

        for(int h=0; h < gridY; h++){
            grid[0][h] = 2;
            grid[gridX-1][h] = 2;
        }

        while (nbFoodCreate != nbFood) {
            int x = alea(0, gridX);
            int y = alea(0, gridY);
            if (grid[x][y] == 0) {
                grid[x][y] = 1;
                nbFoodCreate += 1;
            }
        }

    }

    public void dessiner(Graphics g) {
        for (int i = 0; i < gridX; i++) {
            for (int j = 0; j < gridY; j++) {
                if (grid[i][j] == 1) {
                    new Food(i, j, g);
                }else if(grid[i][j] == 2){
                    g.setColor(new Color(181, 18, 65));
                    g.fillRect(i * 20, j * 20, 20, 20);
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
