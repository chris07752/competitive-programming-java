/*
ID: chris071
LANG: JAVA
TASK: preface
*/
import java.io.*;
import java.util.*;

public class preface {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("preface.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));

        int N = Integer.parseInt(f.readLine());

        int[][] dp = new int[N + 1][7];

        for (int i = 1; i <= Math.min(N, 10); i++) {
            if (i == 4) {
                dp[i][0] = 1;
                dp[i][1] = 1;
            } else if (i == 10) {
                dp[i][2] = 1;
            } else if (i == 9) {
                dp[i][0] = 1;
                dp[i][2] = 1;
            } else if (i >= 5) {
                dp[i][0] = i - 5;
                dp[i][1] = 1;
            } else {
                dp[i][0] = i;
            }
        }


        for (int i = 11; i <= N; i++) {
            solve(i, dp);
        }

        int[] answer = new int[7];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 7; j++) {
                answer[j] += dp[i][j];
            }
        }

        if (answer[0] != 0)
            out.println("I " + answer[0]);
        if (answer[1] != 0)
            out.println("V " + answer[1]);
        if (answer[2] != 0)
            out.println("X " + answer[2]);
        if (answer[3] != 0)
            out.println("L " + answer[3]);
        if (answer[4] != 0)
            out.println("C " + answer[4]);
        if (answer[5] != 0)
            out.println("D " + answer[5]);
        if (answer[6] != 0)
            out.println("M " + answer[6]);

        out.close();
    }

    public static void solve(int n, int[][] dp) {
        int l = Integer.toString(n).length();

        int first = n / (int) Math.pow(10, l - 1);
        int temp = n % (int) Math.pow(10, l - 1);

        for (int i = 0; i < 7; i++) {
            dp[n][i] = dp[temp][i];
        }

        if (first == 4) {
            dp[n][(l - 1) * 2] += 1;
            dp[n][-1 + l * 2] += 1;
        } else if (first == 9) {
            dp[n][(l - 1) * 2] += 1;
            dp[n][l * 2] += 1;
        } else if (first >= 5) {
            dp[n][(l - 1) * 2] += first - 5;
            dp[n][-1 + l * 2] += 1;
        } else {
            dp[n][(l - 1) * 2] += first;
        }

    }
}
