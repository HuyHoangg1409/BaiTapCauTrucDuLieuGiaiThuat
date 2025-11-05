import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        LinkedList<Integer> list = new LinkedList<>();
        String[] parts = bufferedReader.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(parts[i]));
        }
        int tests = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 1; i <= tests; i++) {
            String type = bufferedReader.readLine();
            if (type.equals("Insert")) {
                String[] posAndData = bufferedReader.readLine().trim().split(" ");
                int pos = Integer.parseInt(posAndData[0]);
                int data = Integer.parseInt(posAndData[1]);
                list.add(pos, data);
            }
            if (type.equals("Delete")) {
                int pos = Integer.parseInt(bufferedReader.readLine().trim());
                list.remove(pos);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            ans.append(list.get(i)).append(" ");
        }
        System.out.println(ans.toString());
        bufferedReader.close();
    }
}
