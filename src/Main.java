import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        String input = "y";
        Scanner scanner = new Scanner(System.in);
        while (input.equals("y")) {
            Hand currentHand = new Hand(deck);
            try {
                currentHand.play();
            } catch (NoSuchElementException e) {
                System.out.println("Ran out of cards! Reshuffling...");
                deck = new Deck();
                deck.shuffle();
            }
            System.out.println("\nAnother hand?");
            input = scanner.nextLine().strip().toLowerCase();
        }

        scanner.close();
    }
}
