public class Card {
    public static final int Hearts = 0;
    public static final int Spades = 1;
    public static final int Clubs = 2;
    public static final int Diamonds = 3;

    public static final int Jack = 11;
    public static final int Queen = 12;
    public static final int King = 13;
    public static final int Ace = 14;

    private int m_rank;
    private int m_suit;

    public Card() {
        this.m_rank = Ace;
        this.m_suit = Spades;
    }

    public Card(int rank, int suit) {
        this.m_rank = rank;
        this.m_suit = suit;
    }

    public Card(Card c) {
        this.m_rank = c.m_rank;
        this.m_suit = c.m_suit;
    }

    private String rankToString(int rank) {
        switch (rank) {
            case Jack: return "Jack";
            case Queen: return "Queen";
            case King: return "King";
            case Ace: return "Ace";
            default: return String.valueOf(rank);
        }
    }

    private String suitToString(int suit) {
        switch (suit) {
            case Hearts: return "Hearts";
            case Spades: return "Spades";
            case Clubs: return "Clubs";
            case Diamonds: return "Diamonds";
            default: return "Unknown Suit";
        }
    }

    public String toString() {
        return rankToString(this.m_rank) + " of " + suitToString(this.m_suit);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }
        Card card = (Card) o;
        return this.m_rank == card.m_rank;
    }

    public int getRank() {
        return m_rank;
    }

    public void setRank(int rank) {
        this.m_rank = rank;
    }

    public int getSuit() {
        return m_suit;
    } 

    public void setSuit(int suit) {
        this.m_suit = suit; 
    }
}
