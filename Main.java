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
        Random random = new Random();
        Stack<Integer> stosx = new Stack<Integer>();
        Stack<Integer> stosy = new Stack<Integer>();

        //random.nextInt(max - min + 1) + min max = 29 min = 1, rogi planszy nie mogą być startem
        int start = random.nextInt(SIZE - 2) + 1;
        start = 16;
        int x = start;
        int y = 0;
        //Wyznaczenie pozycji startowej

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
                buttons[i][j].setBackground(Color.WHITE);
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


        int z = 1000;
        buttons[y + 1][x].setBackground((Color.LIGHT_GRAY));
                        buttons[y + 2][x].setBackground((Color.DARK_GRAY));
                        cellBlock[y + 1][x] = 1;
                        cellBlock[y + 2][x] = 1;
                        cellBlock[y][x+1] = 1;
                        cellBlock[y][x-1] = 1;
                        stosx.push(x);
                        stosy.push(y);
                        y += 2;
        while(z > 0) {
            z--;
            Thread.sleep(100);
            int liczba = random.nextInt(4 - 1 + 1) + 1;

            if ((liczba == 1) && (cellBlock[y + 2][x] == 0)) { //w dół
                buttons[y + 1][x].setBackground((Color.LIGHT_GRAY));
                buttons[y + 2][x].setBackground((Color.DARK_GRAY));
                cellBlock[y + 1][x] = 1;
                cellBlock[y + 2][x] = 1;
                cellBlock[y][x + 1] = 1;
                cellBlock[y][x - 1] = 1;
//                        buttons[y][x+1].setBackground((Color.BLACK));
//                        buttons[y][x-1].setBackground((Color.BLACK));
                stosx.push(x);
                stosy.push(y);
                y += 2;

            }
            if ((liczba == 2) && (cellBlock[y - 2][x] == 0)) { //w górę
                buttons[y - 1][x].setBackground((Color.LIGHT_GRAY));
                buttons[y - 2][x].setBackground((Color.DARK_GRAY));
                cellBlock[y - 1][x] = 1;
                cellBlock[y - 2][x] = 1;
                cellBlock[y][x + 1] = 1;
                cellBlock[y][x - 1] = 1;
//                        buttons[y][x+1].setBackground((Color.BLACK));
//                        buttons[y][x-1].setBackground((Color.BLACK));
                stosx.push(x);
                stosy.push(y);
                y -= 2;
            }

            if ((liczba == 3) && (cellBlock[y][x + 2] == 0)) { //w prawo
                buttons[y][x + 1].setBackground((Color.LIGHT_GRAY));
                buttons[y][x + 2].setBackground((Color.DARK_GRAY));
                cellBlock[y][x + 1] = 1;
                cellBlock[y][x + 2] = 1;
                cellBlock[y + 1][x] = 1;
                cellBlock[y - 1][x] = 1;
//                        buttons[y+1][x].setBackground((Color.BLACK));
//                        buttons[y-1][x].setBackground((Color.BLACK));
                stosx.push(x);
                stosy.push(y);
                x += 2;
            }
            if ((liczba == 4) && (cellBlock[y][x - 2] == 0)) { //w lewo
                buttons[y][x - 1].setBackground((Color.LIGHT_GRAY));
                buttons[y][x - 2].setBackground((Color.DARK_GRAY));
                cellBlock[y][x - 1] = 1;
                cellBlock[y][x - 2] = 1;
                cellBlock[y + 1][x] = 1;
                cellBlock[y - 1][x] = 1;
//                        buttons[y+1][x].setBackground((Color.BLACK));
//                        buttons[y-1][x].setBackground((Color.BLACK));
                stosx.push(x);
                stosy.push(y);
                x -= 2;
            }
            if (!stosx.empty() && (cellBlock[y][x - 2] == 1) && (cellBlock[y][x + 2] == 1) && (cellBlock[y - 2][x] == 1) && (cellBlock[y + 2][x] == 1))  {
                System.out.print("Zawracam, x = " + stosx.pop());
                System.out.println(", y = " + stosy.pop());
            }
        }

        //Pokoloruj start
        buttons[0][start].setBackground((Color.YELLOW));
        buttons[1][start].setBackground(Color.RED);

        while(!stosx.empty()) {
            System.out.println(stosx.pop() + "   " + stosy.pop());
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

    void createCell(int x, int y){

    }
}

