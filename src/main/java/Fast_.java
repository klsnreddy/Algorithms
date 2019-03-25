/**
 * Kallam
 * 7/18/2014
 * This class provides better method to find the collinear points.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;


public class Fast_ {

/**
 * @param args
 */
public static void main(String[] args) {
        Stopwatch watch = new Stopwatch();
        In in = new In(args[0]);      // input file
        int N = in.readInt();
        Point[] points = new Point[N];
        int c = 0;
        StdDraw.show(0);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        while (!in.isEmpty() && c < N) {
            points[c] = new Point(in.readInt(), in.readInt());
            points[c++].draw();
            StdDraw.show(0);
        }
        
        List<Point> triplets = null;
        List<List<Point>> collinears = new ArrayList<List<Point>>();
        Arrays.sort(points);
//        Point[] cPoints = null;
        
        for (int i = 0; i < N; i++) {
            Arrays.sort(points, i + 1, N, points[i].SLOPE_ORDER);
            double slope = Double.NEGATIVE_INFINITY;
            double cSlope;
            int count = 0;
            triplets = new ArrayList<Point>();
            for (int j = i + 1; j < N; j++) {
                cSlope = points[i].slopeTo(points[j]);
                if(cSlope == slope) {
                    count++;
                } else {
                    if(count >= 3) {
                        addTriplet(collinears, triplets);
                    }
                    count = 1;
                    triplets = new ArrayList<Point>();
                    slope = cSlope;
                    triplets.add(points[i]);
                }
                triplets.add(points[j]);
            }
            if(count >= 3) {
                addTriplet(collinears, triplets);
            }
        }
        
        /*for (int i = 0; i < N; i++) {
            cPoints = Arrays.copyOf(points, N);
            cPoints[0] = points[i];
            cPoints[i] = points[0];
            
            Arrays.sort(cPoints, 1, N, cPoints[0].SLOPE_ORDER);
            double slope = Double.NEGATIVE_INFINITY;
            double cSlope;
            int count = 0;
            triplets = new ArrayList<Point>();
            for (int j = 1; j < N; j++) {
                cSlope = cPoints[0].slopeTo(cPoints[j]);
                if(cSlope == slope) {
                    count++;
                } else {
                    if(count >= 3) {
                        collinears.add(triplets);
                    }
                    count = 1;
                    triplets = new ArrayList<Point>();
                    slope = cSlope;
                    triplets.add(cPoints[0]);
                }
                triplets.add(cPoints[j]);
            }
            if(count >= 3) {
                collinears.add(triplets);
            }
        }*/
        
        
        StringBuffer sb = new StringBuffer();
        String s = " -> ";
        for (List<Point> triplet : collinears) {
            sb = new StringBuffer();
            Iterator<Point> itr = triplet.iterator();
            while (itr.hasNext()) {
                sb.append(itr.next());
                if(itr.hasNext())
                    sb.append(s);
            }
            System.out.println(sb.toString());
            
            Collections.sort(triplet);
            triplet.get(0).drawTo(triplet.get(triplet.size() - 1));
            
            
        }
        
        StdDraw.show(0);
        System.out.println(watch.elapsedTime());
    }

    /**
     * Method to determine the triplet is eligible to consider or not.
     * @param collinears
     * @param triplets
     */
    private static void addTriplet(List<List<Point>> collinears,
            List<Point> triplets) {
        boolean add = true;
        for (List<Point> triplet : collinears) {
            if(triplet.containsAll(triplets)) {
                add = false;
                break;
            }
        }
        if(add) {
            collinears.add(triplets);
        }
        
    }

}
