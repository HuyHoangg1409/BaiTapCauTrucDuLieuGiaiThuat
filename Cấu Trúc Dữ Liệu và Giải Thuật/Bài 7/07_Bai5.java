import java.io.*;
import java.util.*;

public class Solution {
    public static int partition(int[] array, int left, int right) {
        int paviot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] < paviot) {
                i++;
                int tg = array[i];
                array[i] = array[j];
                array[j] = tg;
            }
        }
        int tg = array[i + 1];
        array[i + 1] = array[right];
        array[right] = tg;
        return i + 1;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int par = partition(array, left, right);
            for (int x : array) {
                System.out.print(x + " ");
            }
            System.out.println();
            quickSort(array, left, par - 1);
            quickSort(array, par + 1, right);
        }
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] pairs = bufferedReader.readLine().trim().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(pairs[i]);
        }
        quickSort(array, 0, n - 1);
        bufferedReader.close();
    }
}
