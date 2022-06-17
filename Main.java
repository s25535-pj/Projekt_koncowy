public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game plansza = new Game();
        plansza.createBoard();
        plansza.limitBoard();
        plansza.fillTheBoard();
        plansza.startGame();
    }
}


