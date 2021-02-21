/*
ID: chris071
LANG: JAVA
TASK: holstein
*/


import java.io.*;
import java.util.*;

public class holstein {
    public static int[][] input;
    public static int V, E;
    public static int[] pull;
    public static boolean[] answer;

    public static int max, maxTotal;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));

        V = Integer.parseInt(f.readLine());

        StringTokenizer st = new StringTokenizer(f.readLine());

        pull = new int[V];

        for (int i = 0; i < V; i++) {
            pull[i] = Integer.parseInt(st.nextToken());
        }

        E = Integer.parseInt(f.readLine());
        input = new int[E][V];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < V; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = new boolean[E];
        for (int i = 0; i < E; i++) {
            answer[i] = true;
        }
        max = E;
        maxTotal = 999;

        solve(new int[V], new boolean[E], 0);

        out.print(max + " ");

        int temp = 0;
        for (int i = 0; i < E; i++) {
            if (answer[i]) {
                out.print(i + 1);
                temp++;
                if (temp < max) {
                    out.print(" ");
                }
            }
        }
        out.println();

        out.close();
    }

    public static void solve(int[] total, boolean[] allIndex, int index) {
        if (index >= E) {
            for (int i = 0; i < V; i++) {
                if (total[i] < pull[i]) {
                    return;
                }
            }
            int numInput = 0;
            int totalInput = 0;

            for (int i = 0; i < E; i++) {
                if (allIndex[i]) {
                    numInput++;
                    totalInput += i;
                }
            }

            if (numInput < max || numInput == max && totalInput <= maxTotal) {
                for (int i = 0; i < E; i++) {
                    answer[i] = allIndex[i];
                }
                max = numInput;
                maxTotal = totalInput;
            }
        } else {
            solve(total, allIndex, index + 1);

            for (int i = 0; i < V; i++) {
                total[i] += input[index][i];
            }
            allIndex[index] = true;
            solve(total, allIndex, index + 1);

            for (int i = 0; i < V; i++) {
                total[i] -= input[index][i];
            }
            allIndex[index] = false;
        }
    }
}
