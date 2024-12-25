import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {
    public Deck() {
        String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        // get cards by each suit
        for (String face : faces) {
            Card diamond = new Card(Suit.DIAMONDS, face);
            Card heart = new Card(Suit.HEARTS, face);
            Card spade = new Card(Suit.SPADES, face);
            Card club = new Card(Suit.CLUBS, face);
            this.add(diamond);
            this.add(heart);
            this.add(spade);
            this.add(club);
        }
    }

    public void shuffle() {
        Collections.shuffle(this);
    }
}
