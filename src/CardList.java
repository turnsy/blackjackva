import java.util.ArrayList;

public class CardList extends ArrayList<Card> {

    public int total() {
        return (int) stream().mapToDouble(card -> card.faceUp ? card.value : 0).sum();
    }
    public String toString() {
        String top = "┌─────┐ ".repeat(size());
        String bottom = "└─────┘ ".repeat(size());
        String upper, middle, lower, spacer;
        upper = middle = lower = "";
        for (Card card : this) {
            if (card.faceUp) {
                spacer = " ".repeat(5 - card.face.length());
                upper = upper.concat(String.format("│%s%s│ ", card.face, spacer));
                middle = middle.concat(String.format("│  %s  │ ", card.getSuitSymbol()));
                lower = lower.concat(String.format("│%s%s│ ", spacer, card.face));
            }
            else {
                upper = upper.concat("|     | ");
                middle = middle.concat("|     | ");
                lower = lower.concat("|     | ");
            }
        }

        return String.format("%s\n".repeat(5), top, upper, middle, lower, bottom);
    };
}
