package inheritance;

import java.util.Calendar;

public class Mammal {

    private int lifeExpectancy = 70;
    private int birthYear;
    private double avgNumOffspring;
    
    public static final int HUMAN_LIFE_EXPECTANCY = 70;

    public int getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public double getAvgNumOffspring() {
        return avgNumOffspring;
    }

    public void setAvgNumOffspring(double avgNumOffspring) {
        this.avgNumOffspring = avgNumOffspring;
    }

    public int currentAge() {
        return currentYear() - birthYear;
    }

    public int yearsLeft() {
        return lifeExpectancy - currentAge();
    }
    
    public int currentHumanAge() {
        return (currentYear() - birthYear) * HUMAN_LIFE_EXPECTANCY / getLifeExpectancy();
    }
    
    public int humanYearsLeft() {
        return HUMAN_LIFE_EXPECTANCY - currentAge();
    }

    public int currentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

}
