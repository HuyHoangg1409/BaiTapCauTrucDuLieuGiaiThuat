import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    static class Node implements Comparable<Node> {
        double value;
        int index;

        Node(double value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node other) {
            if (this.value != other.value) {
                return Double.compare(this.value, other.value);
            }
            return Integer.compare(this.index, other.index);
        }
    }
    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> result = new ArrayList<>();
        TreeSet<Node> left = new TreeSet<>();
        TreeSet<Node> right = new TreeSet<>();
        for (int i = 0; i < a.size(); i++) {
            Node newNode = new Node(a.get(i), i);
            if (left.isEmpty() || newNode.compareTo(left.last()) <= 0) {
                left.add(newNode);
            } else {
                right.add(newNode);
            }
            if (left.size() > right.size() + 1) {
                Node move = left.last();
                left.remove(move);
                right.add(move);
            } else if (left.size() < right.size()) {
                Node move = right.first();
                right.remove(move);
                left.add(move);
            }
            double med;
            if ((left.size() + right.size()) % 2 == 1) {
                med = (double) left.last().value;
            } else {
                double l = (double) left.last().value;
                double r = (double) right.first().value;
                med = (l + r) / 2.0;
            }
            result.add(med);
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        List<Double> result = Result.runningMedian(a);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
