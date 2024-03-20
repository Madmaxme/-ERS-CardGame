import java.util.Collections;
import java.util.LinkedList;

public class Dealer {
    private Deck m_deck;

    public Dealer() {
        this.m_deck = new Deck();
    }

    public void shuffle() {
        Collections.shuffle(m_deck.getCards());
    }

    public LinkedList<Card> deals(int n) {
        LinkedList<Card> dealtCards = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (m_deck.size() > 0) {
                dealtCards.add(m_deck.deal());
            } else {
                break; 
            }
        }
        return dealtCards;
    }


    public int size() {
        return m_deck.size();
    }

    @Override
    public String toString() {
        return m_deck.toString();
    }

    public Deck getDeck() {
        return m_deck;
    }    
}
