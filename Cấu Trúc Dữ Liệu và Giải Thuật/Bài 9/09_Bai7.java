import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static void merge(List<Integer> arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        List<Integer> L = new ArrayList<>();
        List<Integer> R = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            L.add(arr.get(l + i));
        }
        for (int i = 0; i < n2; i++) {
            R.add(arr.get(m + 1 + i));
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i) < R.get(j)) {
                arr.set(k, L.get(i));
                i++;
            } else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr.set(k++, L.get(i++));
        }
        while (j < n2) {
            arr.set(k++, R.get(j++));
        }
    }

    public static void sort(List<Integer> arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        sort(arr,0,arr.toArray().length-1);
        int mn = arr.get(1) - arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            mn = Math.min(mn, arr.get(i) - arr.get(i - 1));
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) == mn) {
                ans.add(arr.get(i));
                ans.add(arr.get(i + 1));
            }
        }
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
