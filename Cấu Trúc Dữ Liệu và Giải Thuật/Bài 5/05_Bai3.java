import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(bufferedReader.readLine().trim());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int t = 1; t <= tests; t++) {
            String[] pairs = bufferedReader.readLine().trim().split(" ");
            int n = Integer.parseInt(pairs[0]);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                arrayList.add(Integer.parseInt(pairs[i]));
            }
            list.add(arrayList);
        }
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        for (int i = 1; i <= q; i++) {
            String[] query = bufferedReader.readLine().trim().split(" ");
            int x = Integer.parseInt(query[0]);
            int y = Integer.parseInt(query[1]);
            try {
                System.out.println(list.get(x - 1).get(y - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }
    }
}
