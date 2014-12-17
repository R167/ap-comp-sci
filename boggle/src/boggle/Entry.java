/****************************
 * File: Board.java
 *
 * Author: Winston Durand
 * Modified: Dec 14, 2014
 ***************************/
package boggle;

/**
 * @author Winston Durand
 *
 */

public final class Entry {
    private String word = null;
    private int points = 0;

    public Entry(String w, char[] letters) {
        word = Words.sanatize(w);
        // calculates the point value
        if (isValid(letters)) {
            // point values as according to boggle rules
            switch (word.length()) {
            case 3: case 4:
                points = 1;
                break;
            case 5:
                points = 2;
                break;
            case 6:
                points = 3;
                break;
            case 7:
                points = 5;
                break;
            case 8:
                points = 11;
                break;
            default:
                break;
            }
        } else if (word.length() < 3 || word.length() > 8) {
            // invalid word handle case
            points = 0;
        } else {
            points = -2;
        }
    }

    /**
     * checks if the word is valid according to letters
     * @param letters array of valid chars
     * @return whether word is from letters in the array
     */
    private boolean isValid(char[] letters) {
        // creates a copy to preserve the original array
        char[] copy = new char[letters.length];
        for (int i = 0; i < letters.length; i++) copy[i] = letters[i];
        // checks that inclusion of letters in the char array
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean found = false;
            for (i = 0; i < letters.length; i++) {
                if (copy[i] == c) {
                    // "deletes" letter from the array
                    copy[i] = 0;
                    found = true;
                    break;
                }
            }
            // returns false as soon as there is a non matching letter
            if (!found) return false;
        }

        // checks if the letter is in the word list
        return Words.hasWord(word) >= 0;
    }

    public int getEarned() {
        return points > 0 ? points : 0;
    }

    public int getLost() {
        return points < 0 ? points : 0;
    }

    public int getPoints() {
        return points;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + points;
        result = prime * result + ((word == null) ? 0 : word.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entry other = (Entry) obj;
        if (points != other.points)
            return false;
        if (word == null) {
            if (other.word != null)
                return false;
        } else if (!word.equals(other.word))
            return false;
        return true;
    }
}
