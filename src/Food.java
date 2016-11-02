import java.awt.*;

/**
 * Created by Célestin on 01/11/2016.
 */
public class Food extends Case {

    public Food(int x, int y, Graphics g){
        super(x, y);
        setColor(Color.white);
        dessiner(g);
    }

}
