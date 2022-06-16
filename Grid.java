import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grid {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(5, 5));
        frame.add(panel);

        JButton[][] buttons = new JButton[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                JButton cell = new JButton("q");
                buttons[i][j] = cell;
                panel.add(cell);
            }
        }

        buttons[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton qq = (JButton) e.getSource();
                qq.setText("Q");
            }
        });
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
