/**
 * Kallam
 * 7/18/2014
 * This class provides a method to find the collinear points.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;


public class Brute {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        Stopwatch watch = new Stopwatch();
        In in = new In(args[0]);      // input file
        int N = in.readInt();
        List<int[]> collinears = new ArrayList<int[]>();
        Point[] points = new Point[N];
        int c = 0;
        StdDraw.show(0);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        while (!in.isEmpty() && c < N) {
            points[c] = new Point(in.readInt(), in.readInt());
            points[c++].draw();
        }
        
        Arrays.sort(points);
        
        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                double slope = points[i].slopeTo(points[j]);
                for (int k = j + 1; k < N - 1; k++) {
                    if (slope == points[i].slopeTo(points[k]))
                        for (int l = k + 1; l < N; l++) {
                            if (slope == points[i].slopeTo(points[l])) {
                                collinears.add(new int[]{i, j, k, l});
                            }
                        }
                }
            }
        }
        
        StringBuffer sb = new StringBuffer();
        String s = " -> ";
        for (int[] triplet : collinears) {
            sb = new StringBuffer();
            sb.append(points[triplet[0]]).append(s)
            .append(points[triplet[1]]).append(s)
            .append(points[triplet[2]]).append(s)
            .append(points[triplet[3]]);
            System.out.println(sb.toString());
            
            points[triplet[0]].drawTo(points[triplet[3]]);
            
        }
        StdDraw.show(0);
//        System.out.println(watch.elapsedTime());
    }

}
