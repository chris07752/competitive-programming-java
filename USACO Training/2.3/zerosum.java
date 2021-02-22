
/*
ID: chris071
LANG: JAVA
TASK: zerosum
*/

import java.io.*;
import java.util.*;

public class zerosum {
    public static int N;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));

        N = Integer.parseInt(f.readLine());

        solve("1", 2);

        out.close();
    }

    public static void solve(String sequence, int digit) {
        if (digit > N) {
            checkZero(sequence);
        } else {
            solve(sequence + " " + digit, digit + 1);
            solve(sequence + "+" + digit, digit + 1);
            solve(sequence + "-" + digit, digit + 1);
        }
    }
    //checks if the formed sequance equals zero
    public static void checkZero(String s) {
        int sum = 0;
        int power = 1;
        int pair = 0;
        //runs backwards for knapsack, knapsack always runs backwards
        for (int i = s.length() - 2; i > 0; i -= 2) {

            
            if (s.charAt(i) == '+') {
                sum += Character.getNumericValue(s.charAt(i + 1)) * power + pair;
                //resets power in case was two digit number
                power = 1;
                //resets pair for next pair
                pair = 0;
            } else if (s.charAt(i) == '-') {
                sum -= Character.getNumericValue(s.charAt(i + 1)) * power + pair;
                //resets power in case was two digit number
                power = 1;
                //resets pair for next pair
                pair = 0;
            } 
            //when is a number, or is blank spot
            else {

                
                pair += Character.getNumericValue(s.charAt(i + 1)) * power;
                //multiplies by 10 so that number before blank is tens digit while next number (after blank) is ones digit
                power *= 10;


            }
        }
        //adds remaining digit
        if (pair != 0) {
            sum += power + pair;
        } else {
            sum += 1;
        }

        if (sum == 0) {
            out.println(s);
        }
    }
}
