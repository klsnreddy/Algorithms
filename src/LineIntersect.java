import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;



public class LineIntersect {

	public Map<Line, List<Line>> intersects(List<Line> lines) {
		Map<Line, List<Line>> result = new TreeMap<Line, List<Line>>();
		MinPQ<Line> minPq = new MinPQ<LineIntersect.Line>();
		RangeBST<Double, Line> bst = new RangeBST<Double, Line>(); 
		for(Line node : lines) {
			minPq.insert(node);
		}
		
		while (!minPq.isEmpty()) {
			Line line = minPq.delMin();
			if (line.hAlign) {
				if (line.hEnd) {
					bst.delete(line.p1.y());
				} else {
					line.hEnd = true;
					minPq.insert(line);
					bst.put(line.p1.y(), line);
				}
			} else {
				List<Line> intersect = bst.getRange(line.p1.y(), line.p2.y());
				if (null != intersect && !intersect.isEmpty()) {
					result.put(line, intersect);
				}
			}
		}
		
		return result;
	}


	public static class RangeBST<Key extends Comparable<Key>, Value> {
		
		public Node root;             // root of BST

	    public class Node {
	        public Key key;           // sorted by key
	        public Value val;         // associated data
	        public Node left, right;  // left and right subtrees
	        public int N;             // number of nodes in subtree

	        public Node(Key key, Value val, int N) {
	            this.key = key;
	            this.val = val;
	            this.N = N;
	        }
	    }
	    
	    /***********************************************************************
	     *  Insert key-value pair into BST
	     *  If key already exists, update with new value
	     ***********************************************************************/
	     public void put(Key key, Value val) {
	         root = put(root, key, val);
	     }

	     public Node put(Node x, Key key, Value val) {
	         if (x == null) return new Node(key, val, 1);
	         int cmp = key.compareTo(x.key);
	         if      (cmp < 0) x.left  = put(x.left,  key, val);
	         else if (cmp > 0) x.right = put(x.right, key, val);
	         else              x.val   = val;
	         x.N = 1 + size(x.left) + size(x.right);
	         return x;
	     }
	     
	     /***********************************************************************
	      *  Delete
	      ***********************************************************************/
	     public void deleteMin() {
	         root = deleteMin(root);
	     }

	     public Node deleteMin(Node x) {
	         if (x.left == null) return x.right;
	         x.left = deleteMin(x.left);
	         x.N = size(x.left) + size(x.right) + 1;
	         return x;
	     }

	     public void deleteMax() {
	         root = deleteMax(root);
	     }

	     public Node deleteMax(Node x) {
	         if (x.right == null) return x.left;
	         x.right = deleteMax(x.right);
	         x.N = size(x.left) + size(x.right) + 1;
	         return x;
	     }
	     
	     public void delete(Key key) {
	         root = delete(root, key);
	     }

	     public Node delete(Node x, Key key) {
	         if (x == null) return null;
	         int cmp = key.compareTo(x.key);
	         if      (cmp < 0) x.left  = delete(x.left,  key);
	         else if (cmp > 0) x.right = delete(x.right, key);
	         else { 
	             if (x.right == null) return x.left;
	             if (x.left  == null) return x.right;
	             Node t = x;
	             x = min(t.right);
	             x.right = deleteMin(t.right);
	             x.left = t.left;
	         } 
	         x.N = size(x.left) + size(x.right) + 1;
	         return x;
	     } 
		
	     public Key min() {
	         if (isEmpty()) return null;
	         return min(root).key;
	     } 

	     public Node min(Node x) { 
	         if (x.left == null) return x; 
	         else                return min(x.left); 
	     } 
	     
	  // is the symbol table empty?
	     public boolean isEmpty() {
	         return size() == 0;
	     }
	     
	     // return number of key-value pairs in BST
	     public int size() {
	         return size(root);
	     }

	     // return number of key-value pairs in BST rooted at x
	     public int size(Node x) {
	         if (x == null) return 0;
	         else return x.N;
	     }
	     
	     ///Get the range
		public List<Value> getRange(Key lo, Key hi) {
			List<Value> lines = new ArrayList<Value>();
			range (lo, hi, root, lines);
			return lines;
		}
		
		public void range (Key lo, Key hi, Node x, List<Value> lines) {
			if (null == x) return;
			int compLo = lo.compareTo(x.key);
			int compHi = hi.compareTo(x.key);
			
			if (compLo == 0) {
				lines.add(x.val);
				range (lo, hi, x.right, lines);
				return;
			} else if (compHi == 0) {
				lines.add(x.val);
				range (lo, hi, x.left, lines);
				return;
			}
			
			if (compLo > 0) {
				range (lo, hi, x.right, lines);
				return;
			} else if (compHi < 0) {
				range (lo, hi, x.left, lines);
				return;
			}
			
			if (compLo < 0 && compHi > 0) {
				lines.add(x.val);
				range (lo, hi, x.left, lines);
				range (lo, hi, x.right, lines);
			}
		}
		
		// in order traversal
	    public Iterable<Node> inOrder() {
	        Queue<Node> queue = new Queue<Node>();
	        inOrder(root, queue);
	        return queue;
	    }
	    
	    private void inOrder(Node x, Queue<Node> queue) {
	    	if (null == x) return;
	    	inOrder(x.left, queue);
	    	queue.enqueue(x);
	    	inOrder(x.right, queue);
	    }
	}
	
	//Node of the Line intersect
   public static class Line implements Comparable<Line> {
       public Point2D p1;      // the point
       public Point2D p2;    // the point
       public boolean hAlign = false;
       public boolean hEnd = false;
       
       
     //constructor
       public Line(Point2D point1, Point2D point2) {
           this.p1 = point1;
           this.p2 = point2;
           if (this.p1.y() == this.p2.y())
        	   this.hAlign = true;
       }

		@Override
		public int compareTo(Line that) {
			Point2D p = this.p1;
			if (this.hEnd)
				p = this.p2;
			Point2D q = that.p1;
			if (that.hEnd)
				q = that.p2;
			
			if (p.x() < q.x()) return -1;
			if (p.x() > q.x()) return 1;
			return 0;
		}
		
		public String toString() {
			return this.p1.toString() + "  -  " + this.p2.toString();
		}
    }
	   
	   
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			
			LineIntersect lineIntersect = new LineIntersect();
			List<Line> lines = new ArrayList<Line>();
			Line line = null;
			Point2D p1 = null;
	        Point2D p2 = null;
			
			String filename = args[0];
	        In in = new In(filename);

	        StdDraw.show(0);
	        StdDraw.clear();
	        StdDraw.setPenRadius(.01);

	        // initialize the data structures with N points from standard input
	        while (!in.isEmpty()) {
	            double x1 = in.readDouble();
	            double y1 = in.readDouble();
	            double x2 = in.readDouble();
	            double y2 = in.readDouble();
	            p1 = new Point2D(x1, y1);
	            p2 = new Point2D(x2, y2);
	            if (y1 == y2) {
	            	if (x1 < x2)
	            		line = new Line(p1, p2);
	            	else 
	            		line = new Line(p1, p2);
	            } else {
	            	if (y1 < y2)
	            		line = new Line(p1, p2);
	            	else 
	            		line = new Line(p1, p2);
	            }
	            lines.add(line);
	            StdDraw.setPenRadius(.03);
	            StdDraw.setPenColor(StdDraw.RED);
	            StdDraw.point(p1.x(), p1.y());
	            StdDraw.point(p2.x(), p2.y());
	            StdDraw.setPenRadius(.01);
	            StdDraw.setPenColor(StdDraw.BLUE);
	            StdDraw.line(p1.x(), p1.y(), p2.x(), p2.y());
	        }

	        StdDraw.show(0);
			
			
			Map<Line, List<Line>> result = lineIntersect.intersects(lines);
			
			for (Entry<Line, List<Line>> intersect : result.entrySet()) {
				System.out.println(intersect.getKey() + " intersects with:");
				for (Line val : intersect.getValue()) {
					System.out.println(val);
				}
				System.out.println("======================================");
			}

		}

}
