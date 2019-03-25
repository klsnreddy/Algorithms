package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 *
 */
public class LCSubsequence {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(lcs(s1, s2, m, n));
        }
    }

    private static int lcs (String s1, String s2, int m, int n) {
        //create cache
        int[][] che = new int[m+1][n+1];
        //Iterate over the two strings and check if the chars
        // are equal then 1 + diagnal otherwise max of left or top spot
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    che[i][j] = 1 + che[i - 1][j - 1];
                } else {
                    che[i][j] = Math.max(che[i-1][j], che[i][j-1]);
                }
            }
        }
        return che[m][n];
    }
}
