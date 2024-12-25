import java.util.Scanner;

enum GameResult {
    WIN,
    LOSS,
    PUSH,
}

public class Hand {
    Deck deck;
    CardList playerCards = new CardList();
    CardList dealerCards = new CardList();
    int bet;

    public Hand(Deck d) {
        deck = d;
        initialDeal();
    }

    public void play() {
        Scanner inputScanner = new Scanner(System.in);
        String input = "";
        do {
            printState();
            System.out.println("Would you like to hit? (y/n)");
            input = inputScanner.nextLine().strip().toLowerCase();
            if (input.equals("y")) {
                hit();
            }
        } while (!input.equals("n") && result() != GameResult.LOSS);

        inputScanner.close();

        if (playerCards.total() > 21) {
            printState();
            System.out.println("BUST! Try again next time!");
            return;
        }
        dealerTurn();
        printState();
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        switch (result()) {
            case WIN -> System.out.println("You win! No actual money.");
            case LOSS -> System.out.println("Dealer wins! Try again next time!");
            case PUSH -> System.out.println("Push! That's so lame.");
        }

    }

    public void clearScreen() {
        System.out.println("\n".repeat(50));
    }

    private void hit() {
        playerCards.add(deck.removeLast());
    }

    private GameResult result() {
        if (playerCards.total() > 21) {
            return GameResult.LOSS;
        }

        if (dealerCards.total() > 21) {
            return GameResult.WIN;
        }

        if (dealerCards.total() > playerCards.total()) {
            return GameResult.LOSS;
        } else if (dealerCards.total() < playerCards.total()) {
            return GameResult.WIN;
        } else {
            return GameResult.PUSH;
        }
    }

    private void dealerTurn() {
        dealerCards.getLast().faceUp = true;
        while (dealerCards.total() < 17) {
            printState();
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dealerCards.add(deck.removeLast());
        }
    }

    private void initialDeal() {
        playerCards.add(deck.removeLast());
        dealerCards.add(deck.removeLast());
        playerCards.add(deck.removeLast());
        dealerCards.add(deck.removeLast());
        dealerCards.getLast().faceUp = false;
    }

    public void printState() {
        clearScreen();
        System.out.printf("Dealer has %s:%n", dealerCards.total());
        System.out.println(dealerCards);
        System.out.printf("Player has %s:%n", playerCards.total());
        System.out.println(playerCards);
    }
}
