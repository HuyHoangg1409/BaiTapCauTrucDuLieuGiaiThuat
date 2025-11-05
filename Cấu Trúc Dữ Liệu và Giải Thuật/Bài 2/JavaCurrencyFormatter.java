import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.
        NumberFormat us = NumberFormat.getNumberInstance(Locale.US);
        NumberFormat india = NumberFormat.getNumberInstance(new Locale("en", "IN"));
        NumberFormat china = NumberFormat.getNumberInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getNumberInstance(Locale.FRANCE);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
