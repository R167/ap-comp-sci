package inheritance;

public class MammalDriver {

    public static void main(String[] args) {
        Mammal myMammal = new Mammal();

        myMammal.setAvgNumOffspring(2.3);
        myMammal.setBirthYear(2003);
        myMammal.setLifeExpectancy(24);


        System.out.println (myMammal.getAvgNumOffspring());
        Dolphin myDolphin = new Dolphin();

        myDolphin.setAvgNumOffspring(1.1);
        myDolphin.setBirthYear(2012);
        myDolphin.setLengthOfDolphin(10.0);
        myDolphin.setLengthOfFin(1.0);
        myDolphin.setLifeExpectancy(20);

        /*System.out.println(myDolphin.currentAge());
			System.out.println(myDolphin.yearsLeft());*/

        System.out.println(myDolphin.currentHumanAge());

    }

}
