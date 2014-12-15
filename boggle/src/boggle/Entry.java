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
        word = sanatize(w);
        if (isValid(letters)) {
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
            points = 0;
        } else {
            points = -2;
        }
    }

    private boolean isValid(char[] letters) {
        char[] copy = new char[letters.length];
        for (int i = 0; i < letters.length; i++) copy[i] = letters[i];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean found = false;
            for (i = 0; i < letters.length; i++) {
                if (copy[i] == c) {
                    copy[i] = 0;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }

        return Words.hasWord(word) >= 0;
    }

    private String sanatize(String str) {
        return str.trim().toLowerCase();
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
