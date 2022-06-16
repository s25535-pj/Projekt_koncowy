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
        Random random = new Random();

        //random.nextInt(max - min + 1) + min max = 29 min = 1, rogi planszy nie mogą być startem
        int start = random.nextInt(SIZE - 2) + 1;

        //Wyznaczenie pozycji startowej
        int y = 0;
        int x = start;
        System.out.println("Start z pozycji x = " + start + ", y = 0");


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
                panel.add(cell);
            }
        }

        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


        //Tworzenie ścian planszy
        for (int i = 0; i < SIZE; i++) {
            buttons[i][0].setBackground((Color.BLACK));
            cellBlock[i][0] = 1;
            buttons[i][SIZE - 1].setBackground((Color.BLACK));
            cellBlock[i][SIZE - 1] = 1;
            buttons[0][i].setBackground((Color.BLACK));
            cellBlock[0][i] = 1;
            buttons[SIZE - 1][i].setBackground((Color.BLACK));
            cellBlock[SIZE - 1][i] = 1;
        }

        //Pokoloruj start
        buttons[0][start].setBackground((Color.YELLOW));
        y += 1;

        while(true) {
            int liczba = 1;
            switch (liczba) {

                case 1:
                    if (cellBlock[y + 1][x] == 0) {
                        buttons[y + 1][x].setBackground((Color.pink));
                        cellBlock[y + 1][x] = 1;
                        y += 1;
                    }
                    break;
                case 2:
                    if (cellBlock[y - 1][x] == 0) {
                        buttons[y - 1][x].setBackground((Color.pink));
                        cellBlock[y - 1][x] = 1;
                        y -= 1;
                    }
                    break;
                case 3:
                    if (cellBlock[y][x + 1] == 0) {
                        buttons[y][x + 1].setBackground((Color.pink));
                        cellBlock[y][x + 1] = 1;
                        x += 1;
                    }
                    break;
                case 4:
                    if (cellBlock[y][x - 1] == 0) {
                        buttons[y][x - 1].setBackground((Color.pink));
                        cellBlock[y][x - 1] = 1;
                        x -= 1;
                    }
                    break;
            }
        }

//        for (int i = 0; i< 30; i++) {
//            for (int j= 0; j < 30; j++) {
//                if(cellBlock[i][j] == 0){
//                    buttons[i][j].setBackground((Color.GRAY));
//                }
//                Thread.sleep(10);
//            }
//        }
    }
}

