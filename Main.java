public class Main {

    public static void main(String[] args) throws InterruptedException {

        FillTheBoard plansza = new FillTheBoard();
        plansza.createBoard();
        plansza.limitBoard();
        plansza.fillTheBoard();
        plansza.startGame();
    }
}


