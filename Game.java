import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Game {
    private LinkedList<Player> players;
    private LinkedList<Card> pile;
    private Dealer dealer;
    private Random random;

    public Game(int numberOfPlayers) {
        random = new Random();
        dealer = new Dealer();
        dealer.shuffle(); 
        players = new LinkedList<>();
        pile = new LinkedList<>();
        initializePlayers(numberOfPlayers);
    }

    private void initializePlayers(int numberOfPlayers) {
        LinkedList<Card> deck = dealer.getDeck().getCards();
        int cardsPerPlayer = deck.size() / numberOfPlayers;

        for (int i = 0; i < numberOfPlayers; i++) {
            LinkedList<Card> hand = new LinkedList<>(deck.subList(i * cardsPerPlayer, (i + 1) * cardsPerPlayer));
            String pattern = getRandomPattern();
            players.add(new Player(i + 1, hand, pattern));
        }
    }

    private String getRandomPattern() {
        String[] patterns = {"doubles", "top bottom", "sandwich"};
        return patterns[random.nextInt(patterns.length)];
    }

    public int play() {
        int currentPlayerIndex = 0;
        while (players.size() > 1) {  
            Player currentPlayer = players.get(currentPlayerIndex);
            Card playedCard = currentPlayer.playCard();
    
            if (playedCard == null) {
                System.out.println("Player " + currentPlayer.getPlayerNum() + " is out of cards and out of the game.");
                players.remove(currentPlayerIndex);
    
                if (currentPlayerIndex >= players.size()) {
                    currentPlayerIndex = 0;
                }
                continue; 
            }
    
            pile.addFirst(playedCard);
            System.out.println("Player " + currentPlayer.getPlayerNum() + " plays " + playedCard);
    
            if (isFaceCard(playedCard)) {
                currentPlayerIndex = handleFaceCard(currentPlayerIndex, playedCard);
            } else {
                if (currentPlayer.slaps(pile)) {
                    System.out.println("Player " + currentPlayer.getPlayerNum() + " slaps and wins the pile!");
                    currentPlayer.receiveCards(new LinkedList<>(pile));
                    pile.clear();
                }
    
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
            }
        }
    
        return players.getFirst().getPlayerNum();
    }
    
    private int handleFaceCard(int currentPlayerIndex, Card playedCard) {
       
        return (currentPlayerIndex + 1) % players.size();
    }
    

    private boolean isFaceCard(Card card) {
        return card.getRank() >= Card.Jack && card.getRank() <= Card.Ace;
    }

    public static boolean doubles(LinkedList<Card> pile) {
        if (pile.size() < 2) return false;
        return pile.get(0).getRank() == pile.get(1).getRank();
    }

    public static boolean topBottom(LinkedList<Card> pile) {
        if (pile.size() < 2) return false;
        return pile.getFirst().getRank() == pile.getLast().getRank();
    }

    public static boolean sandwich(LinkedList<Card> pile) {
        if (pile.size() < 3) return false;
        return pile.get(0).getRank() == pile.get(2).getRank();
    }
}
