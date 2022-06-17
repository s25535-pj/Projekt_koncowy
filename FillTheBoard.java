import javax.swing.*;
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
    int way;


    public void fillTheBoard() throws InterruptedException {
        firstMove();
        while(true){
            way = random.nextInt(4)+1;
            switch (way) {
                case 1:
                    goDown();
                    break;
                case 2:
                    goUp();
                    break;
                case 3:
                    goRight();
                    break;
                case 4:
                    goLeft();
                    break;
            }
            slowDown(TIME);
            if(emptyStack()) break;
            deadEnd();

        }
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
    public void goDown() {
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


        }

    }
    public void goUp() {
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
            }
    }
    public void goRight() {
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
            }

    }
    public void goLeft(){
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
            }
    }

    public boolean emptyStack(){
        return pathX.empty();
    }

    public void deadEnd(){
        if ((cellBlock[y][x - 2] != 0) && (cellBlock[y][x + 2] != 0) && (cellBlock[y - 2][x] != 0) && (cellBlock[y + 2][x] != 0)) {
            x = pathX.pop();
            y = pathY.pop();
            buttons[y][x].setBackground(Color.GREEN);
            if (y == SIZE - 3) {
                buttons[y][x].setBackground(Color.CYAN);
                deadEnd[y][x] = 1;
            }
        }
    }
    public void slowDown(int TIME) throws InterruptedException {
        Thread.sleep(TIME);
    }
}
