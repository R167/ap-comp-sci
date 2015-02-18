package inheritance;

public class Dolphin extends Mammal{

    private double lengthOfDolphin;
    private double lengthOfFin;
    public static final int LIFE_EXPECTANCY = 20;
    
    public Dolphin() {
        super();
        this.setLifeExpectancy(LIFE_EXPECTANCY);
    }

    public double getLengthOfDolphin() {
        return lengthOfDolphin;
    }

    public void setLengthOfDolphin(double lengthOfDolphin) {
        this.lengthOfDolphin = lengthOfDolphin;
    }

    public double getLengthOfFin() {
        return lengthOfFin;
    }

    public void setLengthOfFin(double lengthOfFin) {
        this.lengthOfFin = lengthOfFin;
    }
}
