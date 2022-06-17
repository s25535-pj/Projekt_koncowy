import javax.swing.*;
import java.awt.*;

public class Generator {

    public static void main(String[] args) throws InterruptedException {
		Generator generator = new Generator();
        Generator.createMap();
        Generator.limitMap();
	}

    static int SIZE = 31;

    static int[][] cellBlock = new int[SIZE][SIZE];

    public int[][] getCellBlock() {
        return cellBlock;
    }
    public static void setCellBlock(int x, int y, int value) {
        cellBlock[y][x] = value;
    }

    static JButton[][] buttons = new JButton[SIZE][SIZE];


//    int[][] deadEnd = new int[SIZE][SIZE];

    public static void createMap(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));
//        JButton[][] buttons = new JButton[SIZE][SIZE];

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

    public static void limitMap() throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            Thread.sleep(10);
            buttons[i][0].setBackground((Color.BLACK));
            setCellBlock(i,0,2);
            buttons[i][SIZE - 1].setBackground((Color.BLACK));
            setCellBlock(i,SIZE - 1, 2);
            buttons[0][i].setBackground((Color.BLACK));
            setCellBlock(0, i, 2);
            buttons[SIZE - 1][i].setBackground((Color.BLACK));
            setCellBlock(SIZE - 1, i, 2);
        }

    }

}
