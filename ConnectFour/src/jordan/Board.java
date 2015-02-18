package jordan;

public class Board {

    char[][] grid;
    int x;
    int y;

    public Board() {
        grid = new char[7][6];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                grid[i][j] = ' ';
            }
        }
        x = 0;
        y = 0;
        //initializes new 7x6 array of chars ' '
        //x and y used to store the last placed piece
        //so it can be used to determine a win
    }

    public void setCounters (int col, char val) {
        grid[col][getCounters(col)] = val;
        x = col;
        y = getCounters(col) - 1;
    }

    //sets the highest counter in a column to the val character

    public int getCounters (int col) {
        for (int i = 0; i < grid[col].length; i++) {
            if (grid[col][i] == ' ') {
                return i;
                //returns the first open space in a column
            }
        }
        return 6;
    }
    //gets the number of characters in a column

    public boolean getWin () {
        if (grid[x][y] == ' ') {
            return false;
        }
        int ldiag = 1;
        int rdiag = 1;
        int vert = 1;
        int horiz = 1;
        int tmpx = x;
        int tmpy = y;
        try {
            while (grid[tmpx][tmpy] == grid[x][y]) {
                tmpx++;
                tmpy++;
                rdiag++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        tmpx = x;
        tmpy = y;
        try {
            while (grid[tmpx][tmpy] == grid[x][y]) {
                tmpx--;
                tmpy--;
                rdiag++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        tmpx = x;
        tmpy = y;
        try {
            while (grid[tmpx][tmpy] == grid[x][y]) {
                tmpx++;
                tmpy--;
                ldiag++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        tmpx = x;
        tmpy = y;
        try {
            while (grid[tmpx][tmpy] == grid[x][y]) {
                tmpx--;
                tmpy++;
                ldiag++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        tmpx = x;
        tmpy = y;
        try {
            while (grid[tmpx][tmpy] == grid[x][y]) {

                tmpy++;
                vert++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        tmpx = x;
        tmpy = y;
        try {
            while (grid[tmpx][tmpy] == grid[x][y]) {

                tmpy--;
                vert++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        tmpx = x;
        tmpy = y;
        try {
            while (grid[tmpx][tmpy] == grid[x][y]) {
                tmpx++;

                horiz++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        tmpx = x;
        tmpy = y;
        try {
            while (grid[tmpx][tmpy] == grid[x][y]) {
                tmpx--;

                horiz++;
            }
        } catch (IndexOutOfBoundsException e) {

        }
        tmpx = x;
        tmpy = y;
        if (rdiag > 5) {
            return true;
        }
        if (ldiag > 5) {
            return true;
        }
        if (horiz > 5) {
            return true;
        }
        if (vert > 5) {
            return true;
        }
        return false;
        // this behemoth of a method checks for a win.
        //It checks radially until it hits a tile that is not the same or
        //runs into an out of bounds exception (that is what the try is for)
        // end thing here just checks whether to return a win
    }



    public void display() {
        // TODO Auto-generated method stub
        for (int i = 5; i >= 0; i--) {
            System.out.print("\n|");
            for (int j = 0; j < 7; j++) {
                System.out.print(grid[j][i] + "|");
            }

        }
        System.out.println();
        System.out.println("_______________");
        System.out.println(" 0 1 2 3 4 5 6");
        // prints the board!!
    }
}