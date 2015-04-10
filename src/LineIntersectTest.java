import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;



import junit.framework.TestCase;


public class LineIntersectTest extends TestCase {

	public LineIntersectTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		System.out.println("Set Up called");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("Tear Down called");
	}

	public void testIntersects() {
		LineIntersect lineIntersect = new LineIntersect();
		List<LineIntersect.Line> lines = new ArrayList<LineIntersect.Line>();
		LineIntersect.Line line = null;
		Point2D p1 = null;
        Point2D p2 = null;
		
		String filename = "Lines10.txt";
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
            		line = new LineIntersect.Line(p1, p2);
            	else 
            		line = new LineIntersect.Line(p1, p2);
            } else {
            	if (y1 < y2)
            		line = new LineIntersect.Line(p1, p2);
            	else 
            		line = new LineIntersect.Line(p1, p2);
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

        StdDraw.show();
		
		MinPQ<LineIntersect.Line> minPq = new MinPQ<LineIntersect.Line>();
		for(LineIntersect.Line node : lines) {
			minPq.insert(node);
		}
		LineIntersect.RangeBST<Double, LineIntersect.Line> bst = new LineIntersect.RangeBST<Double, LineIntersect.Line>(); 
		while (!minPq.isEmpty()) {
			LineIntersect.Line l = minPq.delMin();
			System.out.println(l);
			/*if (l.hAlign) {
				if (l.hEnd) {
					bst.delete(l.p1.y());
				} else {
					l.hEnd = true;
					minPq.insert(l);
					bst.put(l.p1.y(), l);
				}
			} 
			Iterable<LineIntersect.RangeBST<Double, LineIntersect.Line>.Node> queue = bst.inOrder();
			for (LineIntersect.RangeBST<Double, LineIntersect.Line>.Node n : queue) {
				System.out.println(n.key);
				System.out.println(n.val);
			}*/
			System.out.println("-----------------**");
		}
		
		/*Map<LineIntersect.Line, List<LineIntersect.Line>> result = lineIntersect.intersects(lines);
		
		for (Entry<LineIntersect.Line, List<LineIntersect.Line>> intersect : result.entrySet()) {
			System.out.println(intersect.getKey() + " intersects with:");
			for (LineIntersect.Line val : intersect.getValue()) {
				System.out.println(val);
			}
			System.out.println("======================================");
		}*/
	}

	public void testMain() {
		/*LineIntersect lineIntersect = new LineIntersect();
		List<LineIntersect.Line> lines = new ArrayList<LineIntersect.Line>();
		LineIntersect.Line line = null;
		Point2D p1 = null;
        Point2D p2 = null;
		
		String filename = "circle10.txt";
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
            		line = new LineIntersect.Line(p1, p2);
            	else 
            		line = new LineIntersect.Line(p1, p2);
            } else {
            	if (y1 < y2)
            		line = new LineIntersect.Line(p1, p2);
            	else 
            		line = new LineIntersect.Line(p1, p2);
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
		
		
		Map<LineIntersect.Line, List<LineIntersect.Line>> result = lineIntersect.intersects(lines);
		
		for (Entry<LineIntersect.Line, List<LineIntersect.Line>> intersect : result.entrySet()) {
			System.out.println(intersect.getKey() + " intersects with:");
			for (LineIntersect.Line val : intersect.getValue()) {
				System.out.println(val);
			}
			System.out.println("======================================");
		}*/
	}
	
	public void testIntersectsOne() {
		
	}

}
