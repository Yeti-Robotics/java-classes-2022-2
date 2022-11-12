public class Player {
    public String name;
    public Card[] hand;
    public int score = 0;

    public Player(String name, Card[] hand) {
        this.name = name;
        this.hand = hand;
    }

    @Override
    public String toString() {
        return name + "'s score is " + score ;
    }
}
