import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dziala");

        JFrame frame = new JFrame();//ramka
        JButton button = new JButton("Click!"); //przycisk
        button.setBounds(130,100,100,40); //x, y, szerokość, wysokość

        frame.add(button);

        frame.setSize(400,500); //szerokosc, wysokosc
        frame.setLayout(new GridLayout(10, 10));//bez menedżera "layoutu"
        frame.setVisible(true);//ramka ma być widoczna
    }
}
