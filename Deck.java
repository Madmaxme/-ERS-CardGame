import java.util.LinkedList;
import java.util.Collections;

public class Deck {
    private LinkedList<Card> m_cards;

    public Deck() {
        m_cards = new LinkedList<>();
        initializeDeck();
    }

    public Deck(Deck otherDeck) {
        m_cards = new LinkedList<>();
        for (Card card : otherDeck.m_cards) {
            m_cards.add(new Card(card));
        }
    }

    private void initializeDeck() {
        for (int suit = Card.Hearts; suit <= Card.Diamonds; suit++) {
            for (int rank = 2; rank <= Card.Ace; rank++) {
                m_cards.add(new Card(rank, suit));
            }
        }
    }

    @Override
    public String toString() {
        String deckString = "";
        for (Card card : m_cards) {
            deckString += card.toString() + "\n";
        }
        return deckString;
    }

    public int size() {
        return m_cards.size();
    }

    public Card deal() {
        if (m_cards.isEmpty()) {
            return null; 
        }
        int randomIndex = (int) (Math.random() * m_cards.size());
        return m_cards.remove(randomIndex);
    }

    public LinkedList<Card> getCards() {
        return new LinkedList<>(m_cards); 
    }

    
    
}