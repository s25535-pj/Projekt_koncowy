public class Main {
    public static void main(String[] args) throws InterruptedException {
        FillTheBoard plansza = new FillTheBoard();
        plansza.createBoard();
        plansza.limitBoard();
        plansza.fillTheBoard();
        Game game = new Game();
    }
}



//        JButton[] sterowanie = new JButton[4];
//        JFrame frame2 = new JFrame("Sterowanie");
//        frame2.setSize(100, 100);
//        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame2.setVisible(true);
//
//        JButton w = new JButton("W");
//        sterowanie[0] = w;
//        sterowanie[0].addActionListener(e -> {
//            JButton w1 = (JButton) e.getSource();
//            w1.setBackground(Color.RED);
//
//        });
//        frame2.add(w);


//        Action upAction;
//
//        upAction = new UpAction();
//		downAction = new DownAction();
//		leftAction = new LeftAction();
//		rightAction = new RightAction();
//
//		panel.getInputMap().put(KeyStroke.getKeyStroke('w'), "upAction");
//		panel.getActionMap().put("upAction", upAction);
//		panel.getInputMap().put(KeyStroke.getKeyStroke('s'), "downAction");
//		panel.getActionMap().put("downAction", downAction);
//		panel.getInputMap().put(KeyStroke.getKeyStroke('a'), "leftAction");
//		panel.getActionMap().put("leftAction", leftAction);
//		panel.getInputMap().put(KeyStroke.getKeyStroke('d'), "rightAction");
//		panel.getActionMap().put("rightAction", rightAction);
//
//        Pozycja p = new Pozycja(start, 0);
//        goDown(p, cellBlock, buttons);
//
//        /*panel.getInputMap().get(KeyStroke.getKeyStroke('w'));*/
//
//
//    }
//
//    public static void goUp(Pozycja p, int[][] cellBlock, JButton[][] buttons) {
//        if (cellBlock[p.y][p.x] == 1) {
//            p.y -= 1;
//            buttons[p.y][p.x].setBackground(Color.yellow);
//            cellBlock[p.y][p.x] = 2;
//        }
//    }
//
//    public static void goDown(Pozycja p, int[][] cellBlock, JButton[][] buttons) {
//        if (cellBlock[p.y + 1][p.x] == 1) {
//            p.y += 1;
//            buttons[p.y][p.x].setBackground(Color.yellow);
//            cellBlock[p.y][p.x] = 2;
//        }
//    }
//
//    public static void goLeft(Pozycja p, int[][] cellBlock, JButton[][] buttons) {
//        if (cellBlock[p.y + 1][p.x] == 1) {
//            p.x -= 1;
//            buttons[p.y][p.x].setBackground(Color.yellow);
//            cellBlock[p.y][p.x] = 2;
//        }
//    }
//
//    public static void goRight(Pozycja p, int[][] cellBlock, JButton[][] buttons) {
//        if (cellBlock[p.y + 1][p.x] == 1) {
//            p.x += 1;
//            buttons[p.y][p.x].setBackground(Color.yellow);
//            cellBlock[p.y][p.x] = 2;
//        }
//    }
//}
//
//    public class UpAction extends AbstractAction{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//
//		}
//	}
//	public class DownAction extends AbstractAction {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//
//		}
//	}
//	public class LeftAction extends AbstractAction{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//
//		}
//	}
//	public class RightAction extends AbstractAction{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//
//		}
//	}




