import java.io.*;
import java.util.*;

public class Solution {

    public static void shiftStacks(Stack<Integer> st1, Stack<Integer> st2) {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        for (int i = 1; i <= t; i++) {
            String[] parts = bufferedReader.readLine().trim().split(" ");
            int type = Integer.parseInt(parts[0]);
            switch (type) {
                case 1:
                    int x = Integer.parseInt(parts[1]);
                    st1.push(x);
                    break;
                case 2:
                    shiftStacks(st1, st2);
                    st2.pop();
                    break;
                case 3:
                    shiftStacks(st1, st2);
                    System.out.println(st2.peek());
                    break;
            }
        }
        bufferedReader.close();
    }
}
