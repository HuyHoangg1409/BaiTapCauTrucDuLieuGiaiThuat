import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> his = new Stack<>();
        for (int i = 1; i <= t; i++) {
            String[] parts = bufferedReader.readLine().trim().split(" ");
            int type = Integer.parseInt(parts[0]);
            switch (type) {
                case 1:
                    his.push(stringBuilder.toString());
                    stringBuilder.append(parts[1]);
                    break;
                case 2:
                    his.push(stringBuilder.toString());
                    int k = Integer.parseInt(parts[1]);
                    stringBuilder.delete(stringBuilder.length() - k, stringBuilder.length());
                    break;
                case 3:
                    int pos = Integer.parseInt(parts[1]);
                    System.out.println(stringBuilder.charAt(pos - 1));
                    break;
                case 4:
                    if (!his.isEmpty()) {
                        stringBuilder = new StringBuilder(his.pop());
                    }
                    break;
            }
        }
        bufferedReader.close();
    }
}
