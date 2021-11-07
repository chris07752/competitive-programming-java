//complete search
import java.util.*;
import java.io.*;

public class CWC2015 {
    private static BufferedReader f;
    private static int[] players;
    public static void main(String[] args) throws Exception{
        f = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(f.readLine());
        for(int j = 0; j < T; j++)
        {
            int N = Integer.parseInt(f.readLine());
            players = new int[N];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for (int i = 0; i < N; i++) {
                players[i] = Integer.parseInt(st.nextToken());
            }
            if(solve(0,0,0))
                System.out.println("Case " + (j+1) + ": Yes");
            else
                System.out.println("Case " + (j+1) + ": No");
        }
        
    }
    public static boolean solve(int i, int right, int left)
    {
        if(i == players.length)
        {
            if(right == left) return true;
            return false;
        }
        return solve(i+1, right + players[i], left) || solve(i+1, right, left + players[i]);
    }
}
