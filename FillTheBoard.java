import javax.swing.*;
import java.awt.*;

public class FillTheBoard extends Board {

    int way = 1;
    int x = getStartPosition();
    int y = 0;

    public void firstMove(){
        if ((way == 1) && (cellBlock[y + 2][x] == 0)) { //w dół
            buttons[y + 1][x].setBackground((Color.LIGHT_GRAY));
            buttons[y + 2][x].setBackground((Color.DARK_GRAY));
            cellBlock[y + 1][x] = 1;
            cellBlock[y + 2][x] = 1;
            cellBlock[y + 1][x + 1] = 2;
            cellBlock[y + 1][x - 1] = 2;
//            stosx.push(x);
//            stosy.push(y);
            y += 2;


        }
    }

    public void goDown() {
        if ((way == 1) && (cellBlock[y + 2][x] == 0)) { //w dół
            buttons[y + 1][x].setBackground((Color.LIGHT_GRAY));
            buttons[y + 2][x].setBackground((Color.DARK_GRAY));
            cellBlock[y + 1][x] = 1;
            cellBlock[y + 2][x] = 1;
            cellBlock[y + 1][x + 1] = 2;
            cellBlock[y + 1][x - 1] = 2;
            cellBlock[y - 1][x + 1] = 2;
            cellBlock[y - 1][x - 1] = 2;
//            stosx.push(x);
//            stosy.push(y);
            y += 2;


        }

    }
    public void goUp() {
        if ((way == 2) && (y >= 2) && (cellBlock[y - 2][x] == 0)) { //w górę
                buttons[y - 1][x].setBackground((Color.LIGHT_GRAY));
                buttons[y - 2][x].setBackground((Color.DARK_GRAY));
                cellBlock[y - 1][x] = 1;
                cellBlock[y - 2][x] = 1;
                cellBlock[y - 1][x + 1] = 2;
                cellBlock[y - 1][x - 1] = 2;
                cellBlock[y + 1][x + 1] = 2;
                cellBlock[y + 1][x - 1] = 2;
//                stosx.push(x);
//                stosy.push(y);
                y -= 2;
            }
    }

    public void goRight() {
        if ((way == 3) && (cellBlock[y][x + 2] == 0)) { //w prawo
                buttons[y][x + 1].setBackground((Color.LIGHT_GRAY));
                buttons[y][x + 2].setBackground((Color.DARK_GRAY));
                cellBlock[y][x + 1] = 1;
                cellBlock[y][x + 2] = 1;
                cellBlock[y + 1][x + 1] = 2;
                cellBlock[y - 1][x + 1] = 2;
                cellBlock[y + 1][x - 1] = 2;
                cellBlock[y - 1][x - 1] = 2;
//                stosx.push(x);
//                stosy.push(y);
                x += 2;
            }

    }
    public void goLeft(){
        if ((way == 4) && (cellBlock[y][x - 2] == 0)) { //w lewo
                buttons[y][x - 1].setBackground((Color.LIGHT_GRAY));
                buttons[y][x - 2].setBackground((Color.DARK_GRAY));
                cellBlock[y][x - 1] = 1;
                cellBlock[y][x - 2] = 1;
                cellBlock[y + 1][x - 1] = 2;
                cellBlock[y - 1][x - 1] = 2;
                cellBlock[y + 1][x + 1] = 2;
                cellBlock[y - 1][x + 1] = 2;
//                stosx.push(x);
//                stosy.push(y);
                x -= 2;
            }
    }
}
