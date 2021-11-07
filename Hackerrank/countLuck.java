
import java.util.*;

public class CountLuck {
    public static void main(String[] args) {
        List<String> matrix = new ArrayList<String>();
        matrix.add(".X.X......X");
        matrix.add(".X*.X.XXX.X");
        matrix.add(".XX.X.XM...");
        matrix.add("......XXXX.");
        int[][] pathing = new int[matrix.size()][matrix.get(0).length()];
        System.out.println(countLuck(matrix, 3, pathing));
    }

    static char[][] ar;
    static int turns;
    static boolean[][] visited;

    public static String countLuck(List<String> m, int k, int[][] pathing) {
        ar = new char[m.size()][m.get(0).length()];
        visited = new boolean[ar.length][ar[0].length];
        for (int i = 0; i < m.size(); i++) {
            ar[i] = m.get(i).toCharArray();
        }
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                if (ar[i][j] == 'M') {
                    visited[i][j] = true;
                    solve(i, j, 0, pathing);
                    break;
                }
            }
        }
        // System.out.println("turns: " + turns);
        // System.out.println("Visited:");
        // for (boolean[] bs : visited) {
        //     for (boolean b : bs) {
        //         if(b) System.out.print(1 + " ");
        //         else System.out.print(0 + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("---------------");
        if (k == turns)
            return "Impressed";
        return "Oops!";
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static boolean solve(int x, int y, int cnt, int[][] pathing) {
        
        if (ar[x][y] == '*') {
            // for (int[] bs : pathing) {
            //     System.out.println(Arrays.toString(bs));
            // }
            turns = cnt;
            return true;
        }

        int valid = 0;
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            
            if (xx >= 0 && yy >= 0 && xx < ar.length && yy < ar[0].length && !visited[xx][yy] && ar[xx][yy] != 'X') {
                // System.out.println("+1 at " + x + "," + y + ":");
                // System.out.println("\t" + visited[xx][yy] + " at ("  + xx + ", " + yy + ")");
                valid++;
            }
        }
        pathing[x][y] = 1;
        //System.out.println("valid: " + valid);
        if (valid >= 2)
        {
            pathing[x][y] = 2;
            cnt += 1;
        }
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];

            if (xx < 0 || yy < 0 || xx >= ar.length || yy >= ar[0].length || ar[xx][yy] == 'X' || visited[xx][yy])
                continue;

            visited[xx][yy] = true;
            if (solve(xx, yy, cnt, pathing))
                return true;
            visited[xx][yy] = false;

        }
        return false;
    }
}
