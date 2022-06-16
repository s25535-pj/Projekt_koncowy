import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    JButton button = new JButton();
    MyFrame(){

        button.setBounds(450,450,100,100);
        button.setText("przycisk");
        button.setFocusable(false);
        button.setBorder(BorderFactory.createBevelBorder(3));
        button.addActionListener(e-> System.out.println("Działa"));
        button.addActionListener(e-> button.setEnabled(false));
        button.addActionListener(e-> button.setBackground(Color.BLACK));

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000,1000);
        this.setVisible(true);

        this.add(button);

    }



}
