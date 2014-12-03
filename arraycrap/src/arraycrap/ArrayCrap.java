package arraycrap;

import java.util.ArrayList;
import java.util.Random;

public class ArrayCrap {
    public static void main(String[] args) {
        char[] letters = new char[26];
        for (char i = 'A'; i <= 'Z'; i++) {
            letters[i - 'A'] = i;
        }

        scramble(letters);
        printArr(letters);

        System.out.println(find(letters, 'G'));
        System.out.println(count(letters, 'G'));
        printArr(findAll(letters, 'G'));
    }

    public static int find(char[] arr, char find) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == find) return i;
        }
        return -1;
    }

    public static int[] findAll(char[] arr, char find) {
        ArrayList<Integer> indeces = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == find) indeces.add(i);
        }
        int[] ret = new int[indeces.size()];
        int cur = 0;
        for (int i : indeces) {
            ret[cur] = i;
            cur ++;
        }
        return ret;
    }

    public static int count(char[] arr, char find) {
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == find) c++;
        }
        return c;
    }

    public static void scramble(char[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rand.nextInt(arr.length);
            char tmp = arr[i];
            arr[i] = arr[r];
            arr[r] = tmp;
        }
    }

    public static void printArr(char[] letters) {
        for (char c : letters) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void printArr(int[] ints) {
        for (int c : ints) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
