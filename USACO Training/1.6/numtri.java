
/*
ID: chris071
LANG: JAVA
TASK: numtri
*/
import java.io.*;
import java.util.*;

public class numtri {
    static ArrayList<ArrayList<Integer>> list;
    static ArrayList<ArrayList<Integer>> dp;
    static int R;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        //number of rows
        R = Integer.parseInt(f.readLine());

        //reading input
        list = new ArrayList<>();
        dp = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            list.add(new ArrayList<>());
            dp.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(f.readLine());
            for (int j = 0; j <= i; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
                //can't be zero because some values are zero
                dp.get(i).add(-1);
            }
        }

        out.println(getSum(0, 0));

        out.close();
    }
    public static int getSum(int r, int c){
        if(r == list.size()){
            return 0;
        }
        if(dp.get(r).get(c) != -1){
            return dp.get(r).get(c);
        }
        dp.get(r).set(c, list.get(r).get(c) + Math.max(getSum(r+1, c), getSum(r+1, c+1)));
        return dp.get(r).get(c);
        
        
        
    }
}
