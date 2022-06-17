import javax.swing.*;
import java.awt.*;

public class Generator {

    public static void main(String[] args) {
		Generator generator = new Generator();
        Generator.CreateMap();
	}

    static int SIZE = 31;
//    int[][] cellBlock = new int[SIZE][SIZE];
//    int[][] deadEnd = new int[SIZE][SIZE];

    public static void CreateMap(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));
        JButton[][] buttons = new JButton[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton cell = new JButton();
                buttons[i][j] = cell;
                buttons[i][j].addActionListener(e -> cell.setBackground(Color.BLACK));
                buttons[i][j].setBackground(Color.WHITE);
                panel.add(cell);
            }
        }
        frame.add(panel);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
