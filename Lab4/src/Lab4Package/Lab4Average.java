/**********************************
 * File: Lab4Average.java
 * 
 * Author: Winston Durand
 * Modified: Sep 21, 2014
 **********************************/
package Lab4Package;

import java.util.Scanner;

/**
 * @author Winston Durand
 */
public class Lab4Average {

	/**
	 * Asks the user to enter the score of a student for three different
	 * tests and an exam. Also asks for the total points each test and
	 * exam is out of. Prints the name, score, total, and exam percentage
	 * as well as average score of the student.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Exam[] exams = new Exam[4];
		
		// Make sure that the scanner closes even if something goes wrong
		try {
			exams[0] = new Exam("Test1", scanner);
			exams[1] = new Exam("Test2", scanner);
			exams[2] = new Exam("Test3", scanner);
			exams[3] = new Exam("Exam", scanner);
		} finally {
			scanner.close();
		}
		
		for (Exam exam : exams) {
			exam.printFormatted();
		}
		// Compute the averages from the exams array
		Exam.average(exams).printFormatted();

	}

}

/**
 * An exam object which represents an exam with a score
 * and a total number of points.
 * 
 * @author Winston Durand
 */
class Exam {
	private int score;
	private int total;
	private String name;
	
	/**
	 * Takes the name of an exam and a scanner and then prompts the user for the
	 * scores of a student on said exam and the number of points exam was out of.
	 * 
	 * @param examName the name of the exam
	 * @param scanner a <code>Scanner</code> instance
	 */
	public Exam(String examName, Scanner scanner) {
		System.out.print("Enter the student's score on " + examName + ": ");
		score = scanner.nextInt();
		
		System.out.print("Enter the total possible number of points on " + examName + ": ");
		total = scanner.nextInt();
		
		name = examName;
	}
	
	/**
	 * Creates an exam with the given name, score, and total possible points
	 * 
	 * @param examName name of the exam
	 * @param exams an array of exams
	 */
	private Exam(String examName, int examScore, int examTotal) {
		score = examScore;
		total = examTotal;
		name = examName;
	}
	
	/**
	 * Computes the "average" exam from an array of exams
	 * 
	 * @param exams array of exams
	 * @return the "average" exam with name "Average"
	 */
	public static Exam average(Exam[] exams) {
		int scoreSum = 0, totalSum = 0;
		// For each exam, add up the sum of the score and total
		for (Exam exam : exams) {
			scoreSum += exam.getScore();
			totalSum += exam.getTotal();
		}
		
		return new Exam("Average", scoreSum, totalSum);
	}
	
	/**
	 * Prints out the formatted form of the exam.
	 */
	public void printFormatted() {
		System.out.format("%7s    %4d/%4d    %5.2f%%\n", name, score, total, this.getPercentage());
	}
	
	/**
	 * @return the exam name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the student's score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	
	/**
	 * @return the percentage
	 */
	public float getPercentage() {
		return (float) score / total * 100;
	}

}

