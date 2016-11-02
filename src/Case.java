import java.awt.*;

public class Case {

    private static final int SIZE = 20;

    private int x;
    private int y;
    private Color color;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = new Color(0, 232, 159);
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {

        this.x = x;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {

        this.y = y;
    }

    public void setColor(Color color) {

        this.color = color;
    }

    public Color getColor() {

        return color;
    }

    public static int getSize(){

        return SIZE;
    }

    public void dessiner(Graphics g){
        g.setColor(color);
        g.fillRect(x * SIZE, y * SIZE, SIZE, SIZE);
    }

}
