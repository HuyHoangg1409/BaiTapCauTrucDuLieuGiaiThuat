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

    public static int quickSort(int[] array, int left, int right, int k) {
        if (left == right) {
            return array[left];
        }
        int par = partition(array, left, right);
        if (par == k) {
            return array[k];
        } else if (par > k) {
            return quickSort(array, left, par - 1, k);
        } else {
            return quickSort(array, par + 1, right, k);
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
        System.out.println(quickSort(array, 0, n - 1, n / 2));
        bufferedReader.close();
    }
}
