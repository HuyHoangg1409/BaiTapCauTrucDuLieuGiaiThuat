import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int last = a;
            for (int j = 0; j < n; j++) {
                System.out.print((int) (last + Math.pow(2, j) * b) + " ");
                last = (int) (last + Math.pow(2, j) * b);
            }
            System.out.print('\n');
        }
        in.close();
    }
}
