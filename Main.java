import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dziala");

        JFrame frame = new JFrame();//okno
        frame.setSize(1000,1000); //szerokosc, wysokosc okna
//        frame.setLayout(new GridLayout(3, 3));//menedżer ułożenia przycisków
//
//        frame.add(new JButton("1"));
//        frame.add(new JButton("2"));
//        frame.add(new JButton("3"));
//        frame.add(new JButton("4"));
//        frame.add(new JButton("5"));
//        frame.add(new JButton("6"));
//        frame.add(new JButton("7"));
//        frame.add(new JButton("8"));
//        frame.add(new JButton("9"));

        frame.setLayout(new GridLayout(15,15));
        for(int i = 0; i < 225; i++){
            frame.add(new JButton("0"));
        }


        frame.setVisible(true);//ramka ma być widoczna
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
