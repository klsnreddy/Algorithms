import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.introcs.StdDraw;


public class KdTree {
    
    private Node root = null;
    private Point2D point = null;
    private double dist = Double.MAX_VALUE;
    
    // construct an empty set of points
   public KdTree() {
       
   }
   
   // is the set empty?
   public boolean isEmpty() {
       return size() == 0;
   }
   
   // number of points in the set
   public int size() {
       return size(root);
   }
   
   // return number of nodes rooted at x
   private int size(Node x) {
       if (x == null) return 0;
       else return x.N;
   }
   
   // add the point p to the set (if it is not already in the set)
   public void insert(Point2D p) {
       root = insert(root, p, true);
   }
   
   private Node insert(Node x, Point2D p, boolean regular) {
       if (null == x) 
           return new Node(p, 1);
       int comp = 0;
       if (regular) {
           comp = Point2D.X_ORDER.compare(p, x.p);
           if (comp == 0 && Point2D.Y_ORDER.compare(p, x.p) == 0)
        	   return x;
//              if (comp == 0)
//                  comp = Point2D.Y_ORDER.compare(p, x.p);
       } else {
           comp = Point2D.Y_ORDER.compare(p, x.p);
           if (comp == 0 && Point2D.X_ORDER.compare(p, x.p) == 0)
               return x;
//              if (comp == 0)
//                  comp = Point2D.X_ORDER.compare(p, x.p);
       }
       
       if (comp >= 0) 
           x.rt = insert(x.rt, p, !regular);
       else
           x.lb = insert(x.lb, p, !regular);
       
       x.N = 1 + size(x.lb) + size(x.rt);
       
       return x;
   }
   
   // does the set contain the point p?
   public boolean contains(Point2D p) {
       return contains(root, p, true);
   }
   
   private boolean contains(Node x, Point2D p, boolean regular) {
       if (x == null) return false;
       int comp = 0;
       if (regular) {
           comp = Point2D.X_ORDER.compare(p, x.p);
//              if (comp == 0)
//                  comp = Point2D.Y_ORDER.compare(p, x.p);
       } else { 
           comp = Point2D.Y_ORDER.compare(p, x.p);
//              if (comp == 0)
//                  comp = Point2D.X_ORDER.compare(p, x.p);
       }
       
       if (comp == 0 && p.compareTo(x.p) == 0)
           return true;
       if   (comp >= 0) return contains(x.rt, p, !regular);
       else return contains(x.lb, p, !regular);
       
   }
   
   // draw all of the points to standard draw
   public void draw() {
       StdDraw.setPenColor(StdDraw.BLACK);
       StdDraw.setPenRadius(.01);
       inorderDraw(root);
   }
   
   private void inorderDraw(Node x) {
        if (null == x) return;
        inorderDraw(x.lb);
        StdDraw.point(x.p.x(), x.p.y());
        inorderDraw(x.rt);
    }
   
   // all points in the set that are inside the rectangle
   public Iterable<Point2D> range(RectHV rect) {
       List<Point2D> list = new ArrayList<Point2D>();
       range(rect, root, list, true);
       return list;
   }
   
   private void range(RectHV rect, Node x, List<Point2D> list, boolean regular) {
       if (null == x) return;
       
       if (intersects(rect, x.p, regular)) { 
           if (rect.contains(x.p))
               list.add(x.p);
           range(rect, x.lb, list, !regular);
           range(rect, x.rt, list, !regular);
           return;
       }
           
       if (regular) {
           if (rect.xmax() < x.p.x())
               range(rect, x.lb, list, !regular);
           else 
               range(rect, x.rt, list, !regular);
       } else {
           if (rect.ymax() < x.p.y())
               range(rect, x.lb, list, !regular);
           else 
               range(rect, x.rt, list, !regular);
       }
   }
   
   private boolean intersects(RectHV rect, Point2D p, boolean regular) {
       if (regular) {
           if (rect.xmin() <= p.x() && rect.xmax() >= p.x())
               return true;
       } else { 
           if (rect.ymin() <= p.y() && rect.ymax() >= p.y())
               return true;
       }
       return false;
   }
   
   // a nearest neighbor in the set to p; null if set is empty
   public Point2D nearest(Point2D p) {
       this.point = null;
       this.dist = Double.MAX_VALUE;
       nearest(root, p, true);
       return this.point;
   }
   
   private void nearest(Node x, Point2D p, boolean regular) {
       if (null == x) return;
       double nDist = p.distanceSquaredTo(x.p);
       if (nDist < this.dist) {
           this.dist = nDist;
           this.point = x.p;
       }
       
       if (regular) {
           if (p.x() < x.p.x()) {
               nearest(x.lb, p, !regular);
               if (this.dist > Math.pow(x.p.x() - p.x(), 2.0)) {
                   nearest(x.rt, p, !regular);
               }
           } else {
               nearest(x.rt, p, !regular);
               if (this.dist > Math.pow(p.x() - x.p.x(), 2.0)) {
                   nearest(x.lb, p, !regular);
               }
           }
       } else {
           if (p.y() < x.p.y()) {
               nearest(x.lb, p, !regular);
               if (this.dist > Math.pow(x.p.y() - p.y(), 2.0)) {
                   nearest(x.rt, p, !regular);
               }
           } else {
               nearest(x.rt, p, !regular);
               if (this.dist > Math.pow(p.y() - x.p.y(), 2.0)) {
                   nearest(x.lb, p, !regular);
               }
           }
       }
       
       return;
   }
   
   //Node of the Kd-Tree
   private static class Node {
       private Point2D p;      // the point
//       private RectHV rect;    // the axis-aligned rectangle corresponding to this node
       private Node lb;        // the left/bottom subtree
       private Node rt;        // the right/top subtree
       private int N;             // number of nodes in subtree
       
       /*//constructor
       public Node(Point2D point) {
           this.p = point;
       }*/
       
     //constructor
       public Node(Point2D point, int N) {
           this.p = point;
           this.N = N;
       }
    }
   
}