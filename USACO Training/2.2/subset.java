
/*
ID: chris071
LANG: JAVA
TASK: subset
*/
import java.io.*;
import java.util.*;
public class subset {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));

        int N = Integer.parseInt(f.readLine());


        if (N * (N + 1) / 2 % 2 != 0) {
            out.println(0);
            out.close();
            return;
        }

        long[][] ar = new long[N + 1][N * (N + 1) / 4 + 1];

        for (int i = 0; i <= N; i++) {
            ar[i][0] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N * (N + 1) / 4; j++) {
                ar[i][j] += ar[i - 1][j];
                if (j - i >= 0) {
                    ar[i][j] += ar[i - 1][j - i];
                }
            }
        }

        out.println(ar[N][N * (N + 1) / 4] / 2);

        out.close();
    }
}
