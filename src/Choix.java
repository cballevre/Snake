

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Choix extends JPanel implements ActionListener {

    Snake snake;
    JComboBox nbFood;
    JComboBox gridSize;

    public Choix(Snake snake) {

        this.snake = snake;

        setLayout(new BorderLayout());
        JLabel titre = new JLabel("Choix des paramètres");
        titre.setHorizontalAlignment(JLabel.CENTER);
        titre.setPreferredSize(new Dimension(100, 30));
        add(titre, BorderLayout.NORTH);

        JPanel zoneCentre = new JPanel();
        zoneCentre.setLayout(new GridLayout(2, 2));

        zoneCentre.add(new JLabel("Quantitée de nourriture"));

        String[] nbFoods = {"5", "10", "15", "20"};
        nbFood = new JComboBox(nbFoods);
        nbFood.setSelectedIndex(0);
        zoneCentre.add(nbFood);

        zoneCentre.add(new JLabel("Dimensions de la grille"));

        String[] gridSizes = {"10x10", "20x20", "30x30", "40x40"};
        gridSize = new JComboBox(gridSizes);
        gridSize.setSelectedIndex(0);
        zoneCentre.add(gridSize);

        add(zoneCentre, BorderLayout.CENTER);

        JButton btn = new JButton("Valider");
        add(btn, BorderLayout.SOUTH);

        btn.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        String[] result = ((String) gridSize.getSelectedItem()).split("x");
        int gridX = Integer.parseInt(result[0]);
        int gridY = Integer.parseInt(result[1]);

        snake.start(Integer.parseInt((String) nbFood.getSelectedItem()), gridX, gridY);

    }

}
