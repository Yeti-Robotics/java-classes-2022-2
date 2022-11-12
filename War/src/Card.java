public class Card {
    public int value;
    public String suit;
    public String name;

    public Card(int value, String suit, String name) {
        this.value = value;
        this.suit = suit;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " of " + suit;
    }
}
