/*************************************************
 * File: Lab3StudentPoints.java
 * 
 * Prints out the student points from a fictitious lab.
 * 
 * Author: Winston Durand
 * Modified: 2014-09-17
 **************************************************/

package Lab3Package;

public class Lab3StudentPoints {

	/**
	 * Prints out the student points from a fictitious lab.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String reverseSolidus = "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\";
		String solidus = "///////////////////";

		System.out.println(solidus + reverseSolidus);
		System.out.println("==          Student Points          ==");
		System.out.println(reverseSolidus + solidus);

		System.out.println(underline("Name\t\tLab\tBonus\tTotal"));

		System.out.println(new Student("Hugh Heffner", 56, 78).toString());
		System.out.println(new Student("Anonymous Joe", 47, 1).toString());
		System.out.println(new Student("Billy Joel", 23, 15).toString());
		System.out.println(new Student("Johnny Cash", 8, 0).toString());
		System.out.println(new Student("The Beatles", 89, 5).toString());
	}

	/**
	 * Given a string, will return the same string with alphanumeric characters
	 * underlined
	 * 
	 * @param str string to be evaluated and have alphanumerics replaced
	 */
	private static String underline(String str) {
		return str + "\n" + str.replaceAll("\\w", "-");
	}
}

class Student {
	private String name = "";
	private int lab = 0;
	private int bonus = 0;
	private int total = 0;

	/**
	 * Creates a new student with a name, lab, bonus and computes total. You can
	 * get the student values by calling <code>toSting()</code>.
	 * 
	 * @param studentName name of the student
	 * @param labPoints number of point student had for lab
	 * @param bonusPoints number of bonus points they received
	 */
	public Student(String studentName, int labPoints, int bonusPoints) {
		name = studentName;
		lab = labPoints;
		bonus = bonusPoints;
		total = lab + bonus;
	}

	/**
	 * Precondition: A student has been created
	 * <p>
	 * Postcondition: Returns a string representation of student with name, lab,
	 * bonus, and total
	 * 
	 * @param
	 * @return string of form
	 *         <code>name (tab tab) lab (tab) bonus (tab) total</code>
	 */
	public String toString() {
		return name + "\t" + lab + "\t" + bonus + "\t" + total;
	}
}
