import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JFrame implements KeyListener{


	JLabel label;
	ImageIcon icon;

	Game(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(null);
		this.addKeyListener(this);

		icon = new ImageIcon("rocket.png");

		label = new JLabel();
		label.setBounds(0, 0, 100, 100);
		label.setIcon(icon);
		this.getContentPane().setBackground(Color.black);
		this.add(label);
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//keyTyped = Invoked when a key is typed. Uses KeyChar, char output
		switch (e.getKeyChar()) {
			case 'w' -> System.out.println('w');
			case 's' -> System.out.println('s');
			case 'd' -> System.out.println('d');
			case 'a' -> System.out.println('a');
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}

//	public void moveUp() {
//		if (cellBlock[y][x] == 1) {
//			System.out.println("w");
//			cellBlock[y][x] = 2;
//			buttons[y][x].setBackground(Color.YELLOW);
//			y -= 1;
//		}
//	}

//	public void moveDown() {
//		if (cellBlock[y][x] == 1) {
//			System.out.println("s");
//			cellBlock[y][x] = 2;
//			buttons[y][x].setBackground(Color.YELLOW);
//			y += 1;
//		}
//	}
//
//	public void moveRight() {
//		if (cellBlock[y][x] == 1) {
//			System.out.println("d");
//			cellBlock[y][x] = 2;
//			buttons[y][x].setBackground(Color.YELLOW);
//			x += 1;
//		}
//	}
//
//	public void moveLeft() {
//		if (cellBlock[y][x] == 1) {
//			System.out.println("a");
//			cellBlock[y][x] = 2;
//			buttons[y][x].setBackground(Color.YELLOW);
//			x -= 1;
//		}
//	}

