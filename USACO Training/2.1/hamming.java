/*
ID: chris071
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.*;

public class hamming {
    public static int[] num;
    public static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        num = new int[N];
        num[0] = 0;
        int index = 1;

        for (int i = 1; i < Math.pow(2, B) && index < N; i++) {
            if (solve(i, index)) {
                num[index++] = i;
            }
        }

        for (int i = 0; i < N; i++) {
            out.print(num[i]);

            if (i % 10 == 9 || i == N - 1) {
                out.println();
            } else {
                out.print(" ");
            }
        }

        out.close();
    }

    public static boolean solve(int nums, int index) {
        for (int i = 0; i < index; i++) {
            if (cntD(Integer.toString(num[i] ^ nums, 2)) < D) {
                return false;
            }
        }
        return true;
    }

    public static int cntD(String nums) {
        int count = 0;

        for (int i = 0; i < nums.length(); i++) {
            if (nums.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
