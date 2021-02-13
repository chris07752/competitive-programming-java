/*
ID: chris071
LANG: JAVA
PROG: sort3
*/

import java.io.*;
import java.util.*;

public class sort3 {
    public static void main(String[] args) throws Exception {

        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        int N = Integer.parseInt(f.readLine());
        List<Integer> input = new ArrayList<Integer>();
        int[] cnt = new int[3];
        for (int i = 0; i < N; i++) {
            input.add(Integer.parseInt(f.readLine()));
            cnt[input.get(i) - 1]++;
        }
        int[] swapped = new int[6];
        for (int i = 0; i < N; i++) {
            if (i < cnt[0]) {
                if (input.get(i) == 2) {
                    swapped[0]++;
                } else if (input.get(i) == 3) {
                    swapped[1]++;
                }
            } else if (i < cnt[0] + cnt[1]) {
                if (input.get(i) == 1) {
                    swapped[2]++;
                } else if (input.get(i) == 3) {
                    swapped[3]++;
                }
            } else {
                if (input.get(i) == 1) {
                    swapped[4]++;
                } else if (input.get(i) == 2) {
                    swapped[5]++;
                }
            }
        }
        for (int i = 0; i < swapped.length; i++) {
            System.out.print(swapped[i]+" ");
        }
        System.out.println();
        System.out.println(input);
        input.sort(Comparator.naturalOrder());
        System.out.println(input);
        int swaps=0;
        if(swapped[0]>0) {
            if (swapped[0]<=swapped[2]) {
                swaps+=swapped[0];
                swapped[2]-=swapped[0];
                swapped[0]=0;
            } else {
                swaps+=swapped[2];
                swapped[0]-=swapped[2];
                swapped[2]=0;
            }
            System.out.println(swaps);
            if (swapped[0]>0) {
                swaps+=2*swapped[0];
                swapped[4]-=swapped[0];
                swapped[3]-=swapped[0];
                swapped[0]=0;
            }
        }
        for (int i = 0; i < swapped.length; i++) {
            System.out.print(swapped[i]+" ");
        }
        System.out.println();
        System.out.println(swaps);
        if(swapped[1]>0) {
            if (swapped[1]<=swapped[4]) {
                swaps+=swapped[1];
                swapped[4]-=swapped[1];
                swapped[1]=0;
            } else {
                swaps+=swapped[4];
                swapped[1]-=swapped[4];
                swapped[4]=0;
            }
            System.out.println(swaps);
            if (swapped[1]>0) {
                swaps+=2*swapped[1];
                swapped[2]-=swapped[1];
                swapped[1]=0;
            }
        }for (int i = 0; i < swapped.length; i++) {
            System.out.print(swapped[i]+" ");
        }
        System.out.println();
        System.out.println(swaps);
        if (swapped[3]>0) {
            swaps+=swapped[3];
        }for (int i = 0; i < swapped.length; i++) {
            System.out.print(swapped[i]+" ");
        }
        System.out.println();
        System.out.println(swaps);
        out.println(swaps);

        out.close();

    }
}
