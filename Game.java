import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Game extends FillTheBoard implements KeyListener {

	JFrame frame = new JFrame();
	JLabel label;

	Game() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(0, 0);
		frame.setLayout(null);
		frame.addKeyListener(this);

		frame.getContentPane().setBackground(Color.black);
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
			case 'w' -> moveUp();
			case 's' -> moveDown();
			case 'd' -> moveRight();
			case 'a' -> moveLeft();
		}

	}
//	public void moveUp() {
//		System.out.println("w");
//		if (cellBlock[y][x] == 1) {
//			cellBlock[y][x] = 2;
//			buttons[y][x].setBackground(Color.YELLOW);
//			y -= 1;
//		}
//	}
//
//	public void moveDown() {
//		System.out.println("s");
//		if (cellBlock[y][x] == 1) {
//			System.out.println("działa");
//			cellBlock[y][x] = 2;
//			buttons[y][x].setBackground(Color.YELLOW);
//			y += 1;
//		}
//	}
//
//	public void moveRight() {
//		System.out.println("d");
//		if (cellBlock[y][x] == 1) {
//			cellBlock[y][x] = 2;
//			buttons[y][x].setBackground(Color.YELLOW);
//			x += 1;
//		}
//	}
//
//	public void moveLeft() {
//		System.out.println("a");
//		if (cellBlock[y][x] == 1) {
//			cellBlock[y][x] = 2;
//			buttons[y][x].setBackground(Color.YELLOW);
//			x -= 1;
//		}
//	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}

