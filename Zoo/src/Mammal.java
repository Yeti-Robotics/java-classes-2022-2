public class Mammal {
    public final String sound;
    public final double[] soundFrequencyRange = new double[2];
    public final boolean laysEggs;
    public static final boolean isWarmBlooded = true;
    public int numberOfLegs;
    public boolean hasTail;

    public Mammal(String sound, boolean laysEggs) {
       this.sound = sound;
       this.laysEggs = laysEggs;
    }

    public void speak() {
        System.out.println(sound);
    }
}
