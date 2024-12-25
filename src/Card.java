enum Suit {
    HEARTS,
    DIAMONDS,
    SPADES,
    CLUBS
}

public class Card {
    Suit suit;
    int value;
    String face;
    boolean isAce;
    boolean faceUp = true;

    public Card(Suit s, String f) {
        suit = s;
        face = f;
        isAce = f.equals("A");
        if (f.equals("A")) {
            value = 1;
        } else if (f.matches("-?\\d+")) {
            value = Integer.parseInt(f);
        } else {
            value = 10;
        }
    }

    public String getSuitSymbol() {
        return switch (suit) {
            case SPADES -> "♠";
            case HEARTS -> "♥";
            case DIAMONDS -> "♦";
            case CLUBS -> "♣";
        };
    }
}
