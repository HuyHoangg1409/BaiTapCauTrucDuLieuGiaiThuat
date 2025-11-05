import java.io.*;
import java.util.*;

public class Solution {

    public static int dequy(int a, int b) {
        if (a > b) {
            int tg = a;
            a = b;
            b = tg;
        }
        if (b % a == 0) {
            return a;
        }
        if (a == 1 || b == 1) {
            return a * b;
        }
        if (a == b) {
            return a;
        }
        return dequy(a, b % a);
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] pairs = bufferedReader.readLine().trim().split(" ");
        int a = Integer.parseInt(pairs[0]);
        int b = Integer.parseInt(pairs[1]);
        System.out.println(dequy(a, b));
    }
}
