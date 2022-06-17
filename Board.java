import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board {

    final int SIZE = 31; //TO musi być liczba nieparzysta!
    final int TIME = 1;
    final int BOARD_SIZE = 1000;

    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));
    Random random = new Random();
    int[][] cellBlock = new int[SIZE][SIZE];
    JButton[][] buttons = new JButton[SIZE][SIZE];

    public void createBoard() {
        System.out.println("Creating board");
        frame.add(panel);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton cell = new JButton();
                buttons[i][j] = cell;
                buttons[i][j].addActionListener(e -> cell.setBackground(Color.BLACK));
                buttons[i][j].setBackground(Color.WHITE);
                panel.add(cell);
            }
        }
        frame.setSize(BOARD_SIZE, BOARD_SIZE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void limitBoard() throws InterruptedException {
        System.out.println("Limiting board");

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

    public int getStartPosition(){
        int start = (random.nextInt(SIZE-3) + 2);
        if((start % 2 != 0 ) && (start > SIZE-3)){
            start -= 1;
        }
        else if(start % 2 != 0 ){
            start += 1;
        }
        System.out.println("Start = "+start);
        return start;
    }
}
