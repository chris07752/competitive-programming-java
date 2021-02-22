/*
ID: chris071
LANG: JAVA
TASK: prefix
*/

import java.io.*;
import java.util.*;


public class prefix {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));

        List<String> primitives = new ArrayList<String>();

        while (true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String s = st.nextToken();

            if (s.equals("."))
                break;

            primitives.add(s);

            while (st.hasMoreTokens()) {
                primitives.add(st.nextToken());
            }
        }

        StringBuilder s = new StringBuilder();
        String input;

        while ((input = f.readLine()) != null) {
            s.append(input);
        }
        String str = s.toString();

        boolean[] maximums = new boolean[str.length() + 1];
        maximums[0] = true;

        int length = 0;

        for (int i = 0; i <= str.length(); i++) {
            for (int j = 0; j < primitives.size(); j++) {
                int start = i - primitives.get(j).length();

                if (start >= 0 && maximums[start] && str.substring(start, start + primitives.get(j).length()).equals(primitives.get(j))) {
                    length = i;
                    maximums[i] = true;
                    break;
                }
            }
        }

        out.println(length);

        out.close();
    }
}
