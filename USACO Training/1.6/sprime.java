
/*
ID: chris071
LANG: JAVA
TASK: sprime
*/
import java.util.*;
import java.io.*;
public class sprime {
    public static void main(String[] args) throws Exception {

        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        int n = Integer.parseInt(f.readLine())+1;

        LinkedHashSet<Integer> answer = new LinkedHashSet<Integer>();
        answer=search(0, n, answer, 0);
        for (int print : answer) {
            out.println(print);
        }

        out.close();

    }

    public static boolean checkPrime(int num) {
        int sq = (int) Math.sqrt(num) + 1;
        for (int i = 2; i < sq; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static LinkedHashSet<Integer> search(int b, int N, LinkedHashSet<Integer> answer, int l) {
        l++;
        if (b == 0) {
            answer.addAll(search(2, N, answer, l));
            answer.addAll(search(3, N, answer, l));
            answer.addAll(search(5, N, answer, l));
            answer.addAll(search(7, N, answer, l));
        } else if (checkPrime(b)) {
            if (l<N) {
                b *= 10;
                answer.addAll(search(b+1, N, answer, l));
                answer.addAll(search(b+3, N, answer, l));
                answer.addAll(search(b+5, N, answer, l));
                answer.addAll(search(b+7, N, answer, l));
                answer.addAll(search(b+9, N, answer, l));
            } else {
                answer.add(b);
            }
        }
        return answer;
    }
}
