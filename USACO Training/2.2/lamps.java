
/*
ID: chris071
LANG: JAVA
TASK: lamps
*/
import java.io.*;
import java.util.*;

public class lamps {

    static int[] lamps;
    static List<Integer> on, off;
    static Set<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));

        int N = Integer.parseInt(f.readLine());
        int C = Integer.parseInt(f.readLine());
        lamps = new int[N + 1];

        answer = new TreeSet<String>();

        for (int i = 1; i <= N; i++) {
            lamps[i] = 1;
        }

        on = new ArrayList<Integer>();
        off = new ArrayList<Integer>();

        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        while (n != -1) {
            on.add(n);
            n = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        while (n != -1) {
            off.add(n);
            n = Integer.parseInt(st.nextToken());
        }

        solve(Math.min(4, C));

        for (String s : answer) {
            out.println(s);
        }

        if (answer.size() == 0) {
            out.println("IMPOSSIBLE");
        }

        out.close();
    }

    public static void solve(int cnt) {
        if (cnt <= 0) {
            for (int i = 0; i < on.size(); i++) {
                if (lamps[on.get(i)] != 1) {
                    return;
                }
            }
            for (int i = 0; i < off.size(); i++) {
                if (lamps[off.get(i)] != 0) {
                    return;
                }
            }
            StringBuilder s = new StringBuilder();
            for (int i = 1; i < lamps.length; i++) {
                s.append(lamps[i]);
            }
            answer.add(s.toString());
        } else {
            for (int i = 1; i < lamps.length; i++) {
                if (lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }
            solve(cnt - 1);
            for (int i = 1; i < lamps.length; i++) {
                if (lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }

            for (int i = 1; i < lamps.length; i += 2) {
                if (lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }
            solve(cnt - 1);
            for (int i = 1; i < lamps.length; i += 2) {
                if (lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }

            for (int i = 2; i < lamps.length; i += 2) {
                if (lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }
            solve(cnt - 1);
            for (int i = 2; i < lamps.length; i += 2) {
                if (lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }

            for (int i = 1; i < lamps.length; i += 3) {
                if (lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }
            solve(cnt - 1);
            for (int i = 1; i < lamps.length; i += 3) {
                if (lamps[i] == 1) {
                    lamps[i] = 0;
                } else {
                    lamps[i] = 1;
                }
            }
        }
    }
}
