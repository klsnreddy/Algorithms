import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

public class PointSET {
    
    private Set<Point2D> set = null;
    
    // construct an empty set of points
   public PointSET() {
       set = new TreeSet<Point2D>();
   }
   
   // is the set empty?
   public boolean isEmpty() {
       return set.isEmpty();
   }
   
   // number of points in the set
   public int size() {
       return set.size();
   }
   
   // add the point p to the set (if it is not already in the set)
   public void insert(Point2D p) {
       set.add(p);
   }
   
   // does the set contain the point p?
   public boolean contains(Point2D p) {
       return set.contains(p);
   }
   
   // draw all of the points to standard draw
   public void draw() {
       StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius(.01);
           for (Point2D p : set) {
               StdDraw.point(p.x(), p.y());
           }
   }
   
   // all points in the set that are inside the rectangle
   public Iterable<Point2D> range(RectHV rect) {
       List<Point2D> list = new ArrayList<Point2D>();
       double ymin = rect.ymin();
       double ymax = rect.ymax();
       for (Point2D point : set) {
           if (point.y() > ymax)
               break;
           if (point.y() < ymin)
               continue;
           if (point.x() >= rect.xmin() && point.x() <= rect.xmax())
               list.add(point);
       }
       return list;
   }
   
   // a nearest neighbor in the set to p; null if set is empty
   public Point2D nearest(Point2D p) {
       Point2D nearestPoint = null;
       double dis = Double.MAX_VALUE;
       for (Point2D point : set) {
           double dist = p.distanceSquaredTo(point);
           if (dist < dis) {
               dis = dist;
               nearestPoint = point;
           }
       }
       return nearestPoint;
   }
}