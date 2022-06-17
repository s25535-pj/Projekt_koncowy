import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Rozmiar planszy, blokada pól
        int SIZE = 31;
        int[][] cellBlock = new int[SIZE][SIZE];
        int[][] deadEnd = new int[SIZE][SIZE];
        Random random = new Random();
        Stack<Integer> stosx = new Stack<Integer>();
        Stack<Integer> stosy = new Stack<Integer>();

        //random.nextInt(max - min + 1) + min max = 29 min = 1, rogi planszy nie mogą być startem
        int start = (random.nextInt(12) + 2) * 2;
        System.out.println("Start = " + start);
        //start = 16;
        int x = start;
        int y = 0;
        //Wyznaczenie pozycji startowej


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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


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


        buttons[y + 1][x].setBackground((Color.LIGHT_GRAY));
        buttons[y + 2][x].setBackground((Color.DARK_GRAY));
        cellBlock[y][x] = 1;
        cellBlock[y + 1][x] = 1;
        cellBlock[y + 2][x] = 1;
        cellBlock[y + 1][x + 1] = 2;
        cellBlock[y + 1][x - 1] = 2;
        cellBlock[y][x + 1] = 2;
        cellBlock[y][x - 1] = 2;
        stosx.push(x);
        stosy.push(y);
        y += 2;


        int z = 1000;
        while (true) {
            Thread.sleep(1);
            int liczba = random.nextInt(4 - 1 + 1) + 1;

            if ((liczba == 1) && (cellBlock[y + 2][x] == 0)) { //w dół
                buttons[y + 1][x].setBackground((Color.LIGHT_GRAY));
                buttons[y + 2][x].setBackground((Color.DARK_GRAY));
                cellBlock[y + 1][x] = 1;
                cellBlock[y + 2][x] = 1;
                cellBlock[y + 1][x + 1] = 2;
                cellBlock[y + 1][x - 1] = 2;
                cellBlock[y - 1][x + 1] = 2;
                cellBlock[y - 1][x - 1] = 2;
                stosx.push(x);
                stosy.push(y);
                y += 2;

            }
            if ((liczba == 2) && (y >= 2) && (cellBlock[y - 2][x] == 0)) { //w górę
                buttons[y - 1][x].setBackground((Color.LIGHT_GRAY));
                buttons[y - 2][x].setBackground((Color.DARK_GRAY));
                cellBlock[y - 1][x] = 1;
                cellBlock[y - 2][x] = 1;
                cellBlock[y - 1][x + 1] = 2;
                cellBlock[y - 1][x - 1] = 2;
                cellBlock[y + 1][x + 1] = 2;
                cellBlock[y + 1][x - 1] = 2;
                stosx.push(x);
                stosy.push(y);
                y -= 2;
            }

            if ((liczba == 3) && (cellBlock[y][x + 2] == 0)) { //w prawo
                buttons[y][x + 1].setBackground((Color.LIGHT_GRAY));
                buttons[y][x + 2].setBackground((Color.DARK_GRAY));
                cellBlock[y][x + 1] = 1;
                cellBlock[y][x + 2] = 1;
                cellBlock[y + 1][x + 1] = 2;
                cellBlock[y - 1][x + 1] = 2;
                cellBlock[y + 1][x - 1] = 2;
                cellBlock[y - 1][x - 1] = 2;
                stosx.push(x);
                stosy.push(y);
                x += 2;
            }
            if ((liczba == 4) && (cellBlock[y][x - 2] == 0)) { //w lewo
                buttons[y][x - 1].setBackground((Color.LIGHT_GRAY));
                buttons[y][x - 2].setBackground((Color.DARK_GRAY));
                cellBlock[y][x - 1] = 1;
                cellBlock[y][x - 2] = 1;
                cellBlock[y + 1][x - 1] = 2;
                cellBlock[y - 1][x - 1] = 2;
                cellBlock[y + 1][x + 1] = 2;
                cellBlock[y - 1][x + 1] = 2;
                stosx.push(x);
                stosy.push(y);
                x -= 2;
            }
            if (stosx.empty()) {
                break;
            }
            if ((cellBlock[y][x - 2] != 0) && (cellBlock[y][x + 2] != 0) && (cellBlock[y - 2][x] != 0) && (cellBlock[y + 2][x] != 0)) {
                x = stosx.pop();
                y = stosy.pop();
                buttons[y][x].setBackground(Color.GREEN);
                if (y == SIZE - 3) {
                    buttons[y][x].setBackground(Color.CYAN);
                    deadEnd[y][x] = 1;
                }

            }
        }

        //Pokoloruj start
        buttons[0][start].setBackground((Color.YELLOW));
        buttons[1][start].setBackground(Color.RED);

        int koniec = (random.nextInt(12) + 2) * 2;
        System.out.println("Koniec = " + koniec);
        for (int i = 0; i < SIZE; i++) {
            if ((deadEnd[SIZE - 3][koniec] == 1)) {
                buttons[SIZE - 2][koniec].setBackground(Color.YELLOW);
                cellBlock[SIZE - 2][koniec] = 1;
                cellBlock[SIZE - 1][koniec] = 1;
            }
        }

        //Wykończenie planszy
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((cellBlock[i][j] == 0) || cellBlock[i][j] == 2) {
                    buttons[i][j].setBackground(Color.DARK_GRAY);
                } else {
                    buttons[i][j].setBackground(Color.LIGHT_GRAY);
                }
            }
        }

//        JButton[] sterowanie = new JButton[4];
//        JFrame frame2 = new JFrame("Sterowanie");
//        frame2.setSize(100, 100);
//        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame2.setVisible(true);
//
//        JButton w = new JButton("W");
//        sterowanie[0] = w;
//        sterowanie[0].addActionListener(e -> {
//            JButton w1 = (JButton) e.getSource();
//            w1.setBackground(Color.RED);
//
//        });
//        frame2.add(w);
        goUp(start,2, cellBlock, buttons);


    }

    public static void goUp(int x, int y, int[][] cellBlock, JButton[][] buttons) {
        if(cellBlock[y][x] == 1){
            System.out.println("koloruje!");
            buttons[y][x].setBackground(Color.yellow);
            cellBlock[y][x] = 2;
        }
    }
}



