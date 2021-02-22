/*
ID: chris071
LANG: JAVA
TASK: runround
*/
import java.io.*;
import java.util.*;

public class runround {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));

        long M = Integer.parseInt(f.readLine());

        boolean newD = false;

        long n = M + 1;
        while (!newD) {
            if (isSolution(n)) {
                out.println(n);
                newD = true;
            }
            n++;
        }

        out.close();
    }

    public static boolean isSolution(long n) {
        boolean[] dig = new boolean[10];

        long replace = n;
        while (replace > 0) {
            if (dig[(int) (replace % 10)] || replace % 10 == 0) {
                return false;
            }
            dig[(int) (replace % 10)] = true;
            replace /= 10;
        }

        String s = Long.toString(n);
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            int tempindex = Character.getNumericValue(s.charAt(index));
            if (!dig[tempindex]) {
                return false;
            } else {
                dig[tempindex] = false;
                index = (index + tempindex) % s.length();
            }
        }

        if (index == 0) {
            return true;
        } else {
            return false;
        }
    }
}
