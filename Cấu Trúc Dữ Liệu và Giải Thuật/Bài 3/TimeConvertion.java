import java.io.;
import java.math.;
import java.security.;
import java.text.;
import java.util.;
import java.util.concurrent.;
import java.util.regex.;

class Result {

    
      Complete the 'timeConversion' function below.
     
      The function is expected to return a STRING.
      The function accepts STRING s as parameter.
     

    public static String timeConversion(String s) {
         Write your code here
        String hour = s.substring(0, 2);
        String bool = s.substring(8);
        int cvtHour = Integer.parseInt(String.valueOf(hour));
        if (cvtHour = 12 && bool.equals(AM)) {
            cvtHour %= 12;
        }
        if (cvtHour  12 && bool.equals(PM)) {
            cvtHour += 12;
        }
        cvtHour %= 24;
        String hourAfter = Integer.toString(cvtHour);
        if (hourAfter.length() == 1) {
            hourAfter = 0 + hourAfter;
        }
        return hourAfter + s.substring(2, 8);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);
        System.out.println(result);

        bufferedReader.close();
    }
}
