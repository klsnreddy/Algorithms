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

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;


public class Fast {

/**
 * @param args
 */
public static void main(String[] args) {
//        Stopwatch watch = new Stopwatch();
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
        }
        
        List<Point> triplets = null;
        List<List<Point>> collinears = new ArrayList<List<Point>>();
        Arrays.sort(points);
        
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
        
        StringBuffer sb = new StringBuffer();
        String s = " -> ";
        for (List<Point> triplet : collinears) {
        	Collections.sort(triplet);
        	
            sb = new StringBuffer();
            Iterator<Point> itr = triplet.iterator();
            while (itr.hasNext()) {
                sb.append(itr.next());
                if(itr.hasNext())
                    sb.append(s);
            }
            System.out.println(sb.toString());
            
            triplet.get(0).drawTo(triplet.get(triplet.size() - 1));
            
            
        }
        
        StdDraw.show(0);
//        System.out.println(watch.elapsedTime());
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
