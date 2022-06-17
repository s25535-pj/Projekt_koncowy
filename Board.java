import javax.swing.*;
import java.awt.*;

public class Board {

    static int SIZE = 31;
    int[][] cellBlock = new int[SIZE][SIZE];

    public void createBoard() throws InterruptedException {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));
        frame.add(panel);
        JButton[][] buttons = new JButton[SIZE][SIZE];


        //Tworzenie Planszy z cellsami; i to kolumny, j to wiersze
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton cell = new JButton();
                buttons[i][j] = cell;
                buttons[i][j].addActionListener(e -> cell.setBackground(Color.BLACK));
                buttons[i][j].setBackground(Color.WHITE);
                panel.add(cell);
            }
        }

        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //Ograniczanie planszy
        for (int i = 0; i < SIZE; i++) {
            Thread.sleep(10);
            buttons[i][0].setBackground((Color.BLACK));
            cellBlock[i][0] = 2;
            buttons[i][SIZE - 1].setBackground((Color.BLACK));
            cellBlock[i][SIZE - 1] = 2;
            buttons[0][i].setBackground((Color.BLACK));
            cellBlock[0][i] = 2;
            buttons[SIZE - 1][i].setBackground((Color.BLACK));
            cellBlock[SIZE - 1][i] = 2;
        }
    }
}
