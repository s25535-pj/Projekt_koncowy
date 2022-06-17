import java.awt.*;
import javax.swing.*;


public class Game extends FillTheBoard {

//	Action upAction;
//	Action downAction;
//	Action leftAction;
//	Action rightAction;

	Game() {
		x = start;
		y = 0;
		while (true) {
			char keypressed = KeyStroke.getKeyStroke('w').getKeyChar();
			switch (keypressed) {
				case 'w' -> System.out.println("w");
				case 's' -> System.out.println("s");
				case 'd' -> System.out.println("d");
				case 'a' -> System.out.println("a");
			}
		}
	}

	public void moveUp(){
		if(cellBlock[y][x] == 1){
			System.out.println("w");
			cellBlock[y][x] = 2;
			buttons[y][x].setBackground(Color.YELLOW);
			y -= 1;
		}
	}
	public void moveDown(){
		if(cellBlock[y][x] == 1){
			System.out.println("s");
			cellBlock[y][x] = 2;
			buttons[y][x].setBackground(Color.YELLOW);
			y += 1;
		}
	}
	public void moveRight(){
		if(cellBlock[y][x] == 1){
			System.out.println("d");
			cellBlock[y][x] = 2;
			buttons[y][x].setBackground(Color.YELLOW);
			x += 1;
		}
	}
	public void moveLeft(){
		if(cellBlock[y][x] == 1){
			System.out.println("a");
			cellBlock[y][x] = 2;
			buttons[y][x].setBackground(Color.YELLOW);
			x -= 1;
		}
	}

//	public class UpAction extends AbstractAction{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("W");
//			moveUp();
//		}
//	}
//	public class DownAction extends AbstractAction{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("S");
//			moveDown();
//		}
//	}
//	public class LeftAction extends AbstractAction{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("A");
//			moveLeft();
//		}
//	}
//	public class RightAction extends AbstractAction{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("D");
//			moveRight();
//		}
//	}
}
