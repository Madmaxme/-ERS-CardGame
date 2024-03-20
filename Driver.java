public class Driver {
    public static void main(String[] args) {
        int numberOfPlayers = 4;

        Game game = new Game(numberOfPlayers);
        System.out.println("Game started with " + numberOfPlayers + " players.");

        int winner = game.play();

        System.out.println("Player " + winner + " wins the game!");
    }
}
