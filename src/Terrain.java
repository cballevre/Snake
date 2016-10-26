

import java.awt.Color;
import java.awt.Graphics;

public class Terrain {

    private boolean[][] grid;
    private int gridX;
    private int gridY;

    public Terrain(int nbFood, int gridX, int gridY) {

        this.gridX = gridX;
        this.gridY = gridY;

        grid = new boolean[gridX][gridY];
        int nbFoodCreate = 0;

        while (nbFoodCreate != nbFood) {
            int x = alea(0, gridX);
            int y = alea(0, gridY);
            if (grid[x][y] != true) {
                grid[x][y] = true;
                nbFoodCreate += 1;
            }
        }

    }

    public void dessiner(Graphics g) {
        for (int i = 0; i < gridX; i++) {
            for (int j = 0; j < gridY; j++) {
                if (grid[i][j] == true) {
                    g.setColor(Color.red);
                    g.fillRect(i * 20, j * 20, 20, 20);
                }
            }
        }
    }

    public int alea(int min, int max) {
        return min + (int) (Math.random() * ((max - min)));
    }

    public boolean[][] getGrid() {
        return grid;
    }
}
