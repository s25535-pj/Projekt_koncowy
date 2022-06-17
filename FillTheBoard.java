import java.awt.*;
import java.util.Random;
import java.util.Stack;

public class FillTheBoard extends Board {

    Random random = new Random();
    int[][] deadEnd = new int[SIZE][SIZE];
    Stack<Integer> pathX = new Stack<Integer>();
    Stack<Integer> pathY = new Stack<Integer>();

    int x = getStartPosition();
    int y = 0;

    public void fillTheBoard() throws InterruptedException {
        addStart();
        firstMove();
        while(true) {
            makeWay();
            slowDown(TIME);
            if (emptyStack()) break;
            deadEnd();
        }
        addEnd();
        finishTheBoard();
    }

    public void makeWay(){
        int way = random.nextInt(4)+1;
        switch (way) {
            case 1 -> goDown();
            case 2 -> goUp();
            case 3 -> goRight();
            case 4 -> goLeft();
        }
    }

    public void addStart(){
        buttons[0][x].setBackground(Color.YELLOW);
        cellBlock[y][x] = 1;
    }
    public void firstMove(){
        if (cellBlock[y + 2][x] == 0) { //w dół
            buttons[y + 1][x].setBackground((Color.LIGHT_GRAY));
            buttons[y + 2][x].setBackground((Color.DARK_GRAY));
            cellBlock[y + 1][x] = 1;
            cellBlock[y + 2][x] = 1;
            cellBlock[y + 1][x + 1] = 2;
            cellBlock[y + 1][x - 1] = 2;
            pathX.push(x);
            pathY.push(y);
            y += 2;
        }
    }
    public boolean goDown() {
        if (cellBlock[y + 2][x] == 0) { //w dół
            buttons[y + 1][x].setBackground((Color.LIGHT_GRAY));
            buttons[y + 2][x].setBackground((Color.DARK_GRAY));
            cellBlock[y + 1][x] = 1;
            cellBlock[y + 2][x] = 1;
            cellBlock[y + 1][x + 1] = 2;
            cellBlock[y + 1][x - 1] = 2;
            cellBlock[y - 1][x + 1] = 2;
            cellBlock[y - 1][x - 1] = 2;
            pathX.push(x);
            pathY.push(y);
            y += 2;
            return true;
        }
        return false;
    }

    public boolean goUp() {
        if ((y >= 2) && (cellBlock[y - 2][x] == 0)) { //w górę
                buttons[y - 1][x].setBackground((Color.LIGHT_GRAY));
                buttons[y - 2][x].setBackground((Color.DARK_GRAY));
                cellBlock[y - 1][x] = 1;
                cellBlock[y - 2][x] = 1;
                cellBlock[y - 1][x + 1] = 2;
                cellBlock[y - 1][x - 1] = 2;
                cellBlock[y + 1][x + 1] = 2;
                cellBlock[y + 1][x - 1] = 2;
                pathX.push(x);
                pathY.push(y);
                y -= 2;
                return true;
            }
        return false;
    }

    public boolean goRight() {
        if (cellBlock[y][x + 2] == 0) { //w prawo
                buttons[y][x + 1].setBackground((Color.LIGHT_GRAY));
                buttons[y][x + 2].setBackground((Color.DARK_GRAY));
                cellBlock[y][x + 1] = 1;
                cellBlock[y][x + 2] = 1;
                cellBlock[y + 1][x + 1] = 2;
                cellBlock[y - 1][x + 1] = 2;
                cellBlock[y + 1][x - 1] = 2;
                cellBlock[y - 1][x - 1] = 2;
                pathX.push(x);
                pathY.push(y);
                x += 2;
                return true;
        }
        return false;
    }

    public boolean goLeft(){
        if (cellBlock[y][x - 2] == 0) { //w lewo
            buttons[y][x - 1].setBackground((Color.LIGHT_GRAY));
            buttons[y][x - 2].setBackground((Color.DARK_GRAY));
            cellBlock[y][x - 1] = 1;
            cellBlock[y][x - 2] = 1;
            cellBlock[y + 1][x - 1] = 2;
            cellBlock[y - 1][x - 1] = 2;
            cellBlock[y + 1][x + 1] = 2;
            cellBlock[y - 1][x + 1] = 2;
            pathX.push(x);
            pathY.push(y);
            x -= 2;
            return true;
        }
        return false;
    }

    public boolean emptyStack(){
        return pathX.empty();
    }

    public void deadEnd(){
        if(!goDown() && !goUp() && !goLeft() && !goRight()){
            x = pathX.pop();
            y = pathY.pop();
            buttons[y][x].setBackground(Color.GREEN);
            if (y == SIZE - 3) {
                buttons[y][x].setBackground(Color.CYAN);
                deadEnd[y][x] = 1;
            }
        }
    }

    public void addEnd(){
        int koniec = (random.nextInt(12) + 2) * 2;
        System.out.println("Koniec = " + koniec);
        for (int i = 0; i < SIZE; i++) {
            if ((deadEnd[SIZE - 3][koniec] == 1)) {
                buttons[SIZE - 2][koniec].setBackground(Color.LIGHT_GRAY);
                buttons[SIZE - 1][koniec].setBackground(Color.YELLOW);
                cellBlock[SIZE - 2][koniec] = 1;
                cellBlock[SIZE - 1][koniec] = 1;
            }
        }
    }

    public void finishTheBoard(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((cellBlock[i][j] == 0) || cellBlock[i][j] == 2) {
                    buttons[i][j].setBackground(Color.DARK_GRAY);
                }
                else {
                    buttons[i][j].setBackground(Color.LIGHT_GRAY);
                }
            }
        }
    }

    public void slowDown(int TIME) throws InterruptedException {
        Thread.sleep(TIME);
    }
}
