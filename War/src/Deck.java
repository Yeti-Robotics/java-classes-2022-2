import java.util.Arrays;
import java.util.Random;

public class Deck {
    private final Card[] deck;

    public Deck() {
        deck = new Card[52];
        String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};
        String[] names = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        int position = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < names.length; j++) {
                deck[position] = new Card(j, suits[i], names[j]);
                position++;
            }
        }
    }

    public void shuffle() {
        Random random = new Random();

        for (int i = 0; i < deck.length; i++) {
            int newPosition = random.nextInt(deck.length);
            Card tempCard = deck[newPosition];
            deck[newPosition] = deck[i];
            deck[i] = tempCard;
        }
    }

    public Card[] dealPlayer1Hand() {
        return Arrays.copyOfRange(deck, 0, deck.length/2);
    }

    public Card[] dealPlayer2Hand() {
        return Arrays.copyOfRange(deck, deck.length/2, deck.length);
    }

    @Override
    public String toString() {
        return "Deck{" +
            "deck=" + Arrays.toString(deck) +
            '}';
    }
}
