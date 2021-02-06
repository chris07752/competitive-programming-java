
/*
ID: chris071
LANG: JAVA
TASK: pprime
*/
import java.io.*;
import java.util.*;

public class pprime {
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    

        List<Integer> prime = helper((int) Math.sqrt(b) + 1);
        List<Integer> pal = palindrome(0, 0, 3, prime);
        HashSet<Integer> p = new HashSet<Integer>();
        p.addAll(pal);
        pal = new ArrayList<Integer>();
        pal.addAll(p);
        pal.sort(Comparator.naturalOrder());
        for (int i = 0; i < pal.size(); i++) {
            if (pal.get(i)>=a && pal.get(i)<=b) {
                out.println(pal.get(i));
            }
        }

        out.close();
    }
    public static List<Integer> palindrome(int d, int n, int max, List<Integer> prime) {
        List<Integer> pal = new ArrayList<Integer>();
        String temp1 = String.valueOf(d);
        StringBuilder temp2 = new StringBuilder(temp1);
        temp1+=temp2.reverse();
        if (isPrime(Integer.parseInt(temp1), prime)) {
            pal.add(Integer.parseInt(temp1));
        }
        if (n>1) {
            int temp3 = d/10;
            temp1 = String.valueOf(d);
            temp2 = new StringBuilder(String.valueOf(temp3));
            temp1+=temp2.reverse();
            if (isPrime(Integer.parseInt(temp1), prime)) {
                pal.add(Integer.parseInt(temp1));
            }
        } else if (isPrime(d, prime)) {
            pal.add(d);
        }    
        if (n==0) {
            for (int i = 1; i <= 9; i+=2) {
                pal.addAll(palindrome(i, n+1, max, prime));
            }
        } else if (n<=max) {
            for (int i = 0; i <= 9; i++) {
                int temp = d*10;
                temp+=i; 
                pal.addAll(palindrome(temp, n+1, max, prime));
            }
        }
        return pal;
    }
    public static List<Integer> helper(int n) {
        List<Integer> primeNumbers = new LinkedList<>();
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
    public static boolean isPrime(int number, List<Integer> prime) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 0; i < prime.size(); i++) {
            if (number % prime.get(i) == 0 && prime.get(i)>1 && prime.get(i) < sqrt) {
                return false;
            }
        }
        return true;
    }
}
