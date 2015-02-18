package jordan;

import java.util.Scanner;

public class Game {

    int inc;
    Board myBoard;
    Scanner scan = new Scanner(System.in);
    public Game() {
        myBoard = new Board();

    }

    public void run() {
        int option = 0;
        while (true) {
            //I am sorry, but it wasn't worth making a bool
            inc = 0;
            myBoard.display();
            while (inc < 42  && myBoard.getWin() == false) {
                option = ask("Where would you like to place your next piece?");
                myBoard.setCounters(option, getColor());
                myBoard.display();
                inc++;
            }
            //this is the main body of the game
            //below here is just resetting it so you can play again
            inc++;
            //so it will display the correct winner
            System.out.println("\n\n\nGood Game! " + getColor() + " wins!");
            System.out.println("Would you like to quit? Type -1 to quit");
            option = scan.nextInt();
            myBoard.x = 0;
            myBoard.y = 0;
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 6; j++) {
                    myBoard.grid[i][j] = ' ';
                }
            }
            if(option == -1) {
                break;
            }
            //if the user decides to quit, they can break out of the outer while loop
            option = 0;
        }
    }

    public char getColor() {
        if (inc%2 == 0) {
            return 'X';

        }
        return 'O';
    }
    //determines whether to place an X or an O

    private int ask(String input) {

        System.out.println(input);
        int p = scan.nextInt();
        if (p < 0 || p > 6) {
            return ask("Where would you like to place your next piece?");
        }
        if (myBoard.getCounters(p) == 6) {
            System.out.println("That column is already filled.");
            return ask("Where would you like to place your next piece?");
            //yay recursion!
            //Also this method probably isn't necessary, but I like it.
        }
        return p;
    }
    //figured out later that this was not necessary, but kept it for
    //convenience
}
