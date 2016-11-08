import java.awt.*;

/**
 * Created by Célestin on 03/11/2016.
 */
public class Border extends Case {

    public Border(int x, int y, Graphics g){
        super(x, y);
        setColor(new Color(181, 18, 65));
        dessiner(g);
    }
}
