
/*
ID: chris071
LANG: JAVA
TASK: frac1
*/


import java.io.*;
import java.util.*;

public class frac1 {
    public static void main(String[] args) throws Exception {

        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        int[] plist = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
                83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157 };
        int N = Integer.parseInt(f.readLine());
        List<List<Integer>> fractions = new ArrayList<List<Integer>>();

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                int top = j;
                int bottom = i;
                for (int prime : plist) {
                    while (top % prime == 0 && bottom % prime == 0 && bottom > 1) {
                        top /= prime;
                        bottom /= prime;
                    }
                }

                boolean clean = false;
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(top);
                temp.add(bottom);
                for (int k = 0; k < fractions.size(); k++) {
                    int a = fractions.get(k).get(0) * bottom;
                    int b = top * fractions.get(k).get(1);
                    if (a>b) {
                        fractions.add(k, temp);
                        clean=true;
                        break;
                    } else if (a==b) {
                        clean=true;
                        break;
                    }
                }
                if(!clean) {
                    fractions.add(temp);
                }
            }
        }
        for (List<Integer> answer : fractions) {
            out.println(answer.get(0) + "/" + answer.get(1));
        }

        out.close();

    }


    public static ArrayList<ArrayList<Integer>> sort(ArrayList<ArrayList<Integer>> answer) {
        boolean swap = true;
        while (swap) {
            swap = false;
            if (answer.size() > 1) {
                for (int i = 1; i < answer.size(); i++) {
                    if (answer.get(i - 1).get(0) * answer.get(i).get(1) > answer.get(i).get(0)
                            * answer.get(i - 1).get(1)) {
                        Collections.swap(answer, i - 1, i);
                        swap = true;
                    }
                }
            }
        }
        return answer;
    }
}
