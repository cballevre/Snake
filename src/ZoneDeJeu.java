
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ZoneDeJeu extends JPanel {

    private Terrain terrain;
    private Serpent serpent;

    private int gridX;
    private int gridY;

    public ZoneDeJeu(Snake snake, int nbFood, int gridX, int gridY) {

        this.gridX = gridX;
        this.gridY = gridY;

        setPreferredSize(new Dimension(gridX * 20, gridY * 20));
        terrain = new Terrain(nbFood, gridX, gridY);
        serpent = new Serpent(snake, this, terrain.getGrid());
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, gridX * 20, gridY * 20);
        terrain.dessiner(g);
        serpent.dessiner(g);
    }

}
