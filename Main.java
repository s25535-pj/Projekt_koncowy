import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) throws InterruptedException {


        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(30, 30));
        frame.add(panel);

        JButton[][] buttons = new JButton[30][30];

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                JButton cell = new JButton();
                buttons[i][j] = cell;
                buttons[i][j].addActionListener(e -> cell.setBackground(Color.BLACK));
                panel.add(cell);
            }
        }

        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                buttons[i][j].setBackground((Color.GRAY));
                Thread.sleep(10);
            }
        }
    }
}

