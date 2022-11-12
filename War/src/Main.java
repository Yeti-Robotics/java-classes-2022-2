import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is Player One's name: ");
        String playerOneName = scanner.next();

        System.out.println("What is Player Two's name: ");
        String playerTwoName = scanner.next();

        Player playerOne = new Player(playerOneName, deck.dealPlayer1Hand());
        Player playerTwo = new Player(playerTwoName, deck.dealPlayer2Hand());

        for (int i = 0; i < playerOne.hand.length; i++) {
            Card playerOneCard = playerOne.hand[i];
            Card playerTwoCard = playerTwo.hand[i];

            System.out.printf("%s: %s vs. %s: %s\n",
                playerOne.name, playerOneCard, playerTwo.name, playerTwoCard);

            if (playerOneCard.value > playerTwoCard.value) {
                System.out.println(playerOne.name + " wins");
                playerOne.score++;
            } else if (playerOneCard.value == playerTwoCard.value) {
                System.out.println("It's a tie!");
            } else {
                System.out.println(playerTwo.name + " wins");
                playerTwo.score++;
            }
        }

        System.out.println(playerOne);
        System.out.println(playerTwo);

        if (playerOne.score > playerTwo.score) {
            System.out.println(playerOne.name + " WINS!!!");
        } else if (playerOne.score == playerTwo.score) {
            System.out.println("IT'S A DRAW!");
        } else {
            System.out.println(playerTwo.name + " WINS!!!");
        }
    }
}