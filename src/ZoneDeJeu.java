
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ZoneDeJeu extends JPanel {

    private Terrain terrain;
    private Processus processus;
    private Serpent serpent;

    private int gridX;
    private int gridY;

    public ZoneDeJeu(Snake snake, int nbFood, int gridX, int gridY) {

        this.gridX = gridX;
        this.gridY = gridY;

        setPreferredSize(new Dimension((gridX * Case.getSize()) + 40,(gridY * Case.getSize()) + 40));
        terrain = new Terrain(nbFood, gridX, gridY);
        serpent = new Serpent(snake, this, terrain.getGrid());
    }

    public Serpent getSerpent(){
        return serpent;
    }

    public Terrain getTerrain(){
        return terrain;
    }

    public void paint(Graphics g) {
        g.setColor(new Color(1, 44, 57));
        g.fillRect(0, 0, gridX * 20 +40, gridY * 20+40);
        terrain.dessiner(g);
        serpent.dessiner(g);
    }

}
