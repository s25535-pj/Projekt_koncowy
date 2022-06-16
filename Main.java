import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dziala");

        JFrame frame = new JFrame();//okno

        frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton("3"));
        frame.add(new JButton("4"));
        frame.add(new JButton("5"));
//        JButton button = new JButton("Click!"); //przycisk
//        JButton button2 = new JButton("Pac!"); //przycisk2
//        button.setBounds(130,100,100,40); //x, y, szerokość, wysokość
//
//        frame.add(button);
//        frame.add(button2);

        frame.setSize(400,500); //szerokosc, wysokosc
        frame.setLayout(new GridLayout(10, 10));//menedżer "layoutu"
        frame.setVisible(true);//ramka ma być widoczna
    }
}
