//complete search
//should get all points
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int N = s.nextInt();
            int B = s.nextInt();
            Integer[] houses = new Integer[N];
            for (int j = 0; j < N; j++) {
                houses[j] = s.nextInt();
            }
            int index = 0;
            Arrays.sort(houses, (a,b) -> a - b );
            int cnt = 0;
            while(true)
            {
                if(index == houses.length) break;
                else if(B >= houses[index])
                {
                    B-=houses[index];
                    cnt++;
                    index++;
                }
                else break;

            }
            System.out.println("Case #" + (i+1) + ": " + cnt);
        }
    }
}
