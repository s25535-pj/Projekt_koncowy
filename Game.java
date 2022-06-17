import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends FillTheBoard implements KeyListener {

	public void startGame(){
		y = 1;
		x = start;
		buttons[y][x].setBackground(Color.YELLOW);
		JFrame listener = new JFrame();
		listener.addKeyListener(this);
		listener.setVisible(true);
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

	public void moveUp() {
		System.out.println("w");
		if (cellBlock[y-1][x] == 1) {
            y -= 1;
			cellBlock[y][x] = 2;
			buttons[y][x].setBackground(Color.YELLOW);

		}
	}

	public void moveDown() {
		System.out.println("s");
		if (cellBlock[y+1][x] == 1) {
            y += 1;
			cellBlock[y][x] = 2;
			buttons[y][x].setBackground(Color.YELLOW);
		}
	}

	public void moveRight() {
		System.out.println("d");
		if (cellBlock[y][x+1] == 1) {
            x += 1;
			cellBlock[y][x] = 2;
			buttons[y][x].setBackground(Color.YELLOW);
		}
	}

	public void moveLeft() {
		System.out.println("a");
		if (cellBlock[y][x-1] == 1) {
            x -= 1;
			cellBlock[y][x] = 2;
			buttons[y][x].setBackground(Color.YELLOW);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}

