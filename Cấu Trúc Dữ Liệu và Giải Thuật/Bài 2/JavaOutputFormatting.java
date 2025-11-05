import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            //Complete this line
            System.out.print(s1);
            int n = 15 - s1.length();
            for (int e = 1; e <= n; e++) {
                System.out.print(" ");
            }
            if (x >= 100) {
                System.out.println(x);
            } else if (x >= 10) {
                System.out.println("0" + x);
            } else {
                System.out.println("00" + x);
            }
        }
        System.out.println("================================");

    }
}



