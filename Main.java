import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Rozmiar planszy, blokada pól
        int SIZE = 30;
        int[][] cellBlock = new int[SIZE][SIZE];

        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));
        frame.add(panel);
        JButton[][] buttons = new JButton[SIZE][SIZE];

        //Tworzenie Planszy z cellsami; x to kolumny, y to wiersze
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                JButton cell = new JButton();
                buttons[x][y] = cell;
                buttons[x][y].addActionListener(e -> cell.setBackground(Color.BLACK));
                panel.add(cell);
            }
        }

        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        //Tworzenie ścian planszy
        for(int i = 0; i <SIZE; i++) {
            buttons[i][0].setBackground((Color.BLACK));
            cellBlock[i][0] = 1;
            buttons[i][SIZE-1].setBackground((Color.BLACK));
            cellBlock[i][SIZE-1] = 1;
            buttons[0][i].setBackground((Color.BLACK));
            cellBlock[0][i] = 1;
            buttons[SIZE-1][i].setBackground((Color.BLACK));
            cellBlock[SIZE-1][i] = 1;
        }

        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 30; y++) {
                if(cellBlock[x][y] == 0){
                    buttons[x][y].setBackground((Color.GRAY));
                }
                Thread.sleep(10);
            }
        }
    }
}

