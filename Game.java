import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends FillTheBoard implements KeyListener {

	boolean gameHasEnded = true;
	boolean fistGame = true;

	public static void main(String[] args) throws InterruptedException {

		Game plansza = new Game();
        plansza.createBoard();

		while(true){
			if(plansza.gameHasEnded) {
				START(plansza);
				plansza.gameHasEnded = false;
			}
			Thread.sleep(2000);
		}
	}

	public static void START(Game plansza) throws InterruptedException {
        plansza.limitBoard();
        plansza.fillTheBoard();
        plansza.startGame();
    }

	public void startGame(){
		y = 1;
		x = start;
		buttons[y][x].setBackground(Color.YELLOW);
		if(fistGame){
			JFrame listener = new JFrame();
			listener.addKeyListener(this);
			listener.setVisible(true);
			fistGame = false;
		}
	}

	public void endGame(){
		System.out.println("koniec");
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				buttons[i][j].setBackground(Color.LIGHT_GRAY);
				cellBlock[i][j] = 0;
			}
		}
		start = getStartPosition();
		x = start;
		y = 0;
		gameHasEnded = true;
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
		else if((x == koniec) && (y-1 == SIZE-1 )){
				endGame();
		}
	}

	public void moveDown() {
		System.out.println("s");
		if (cellBlock[y+1][x] == 1) {
            y += 1;
			cellBlock[y][x] = 2;
			buttons[y][x].setBackground(Color.YELLOW);
		}
		else if((x == koniec) && (y+1 == SIZE-1 )){
				endGame();
		}
	}

	public void moveRight() {
		System.out.println("d");
		if (cellBlock[y][x+1] == 1) {
            x += 1;
			cellBlock[y][x] = 2;
			buttons[y][x].setBackground(Color.YELLOW);
		}
		else if((x+1 == koniec) && (y == SIZE-1 )){
				endGame();
		}
	}

	public void moveLeft() {
		System.out.println("a");
		if (cellBlock[y][x-1] == 1) {
            x -= 1;
			cellBlock[y][x] = 2;
			buttons[y][x].setBackground(Color.YELLOW);
		}
		else if((x-1 == koniec) && (y == SIZE-1 )){
				endGame();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}

