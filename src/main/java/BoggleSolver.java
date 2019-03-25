import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.TST;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class BoggleSolver {

    private static final Integer ZERO = new Integer(0);
    private static final Integer ONE = new Integer(1);
    private static final Integer TWO = new Integer(2);
    private static final Integer THREE = new Integer(3);
    private static final Integer FIVE = new Integer(5);
    private static final Integer ELEVEN = new Integer(11);
    
    private TST<Integer> dict = new TST<Integer>();
    
    Map<Integer, Map<Integer, Point>> points = new HashMap<Integer, Map<Integer, Point>>();
    
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary) {
        for (String str : dictionary) {
            int len = str.length();
            if (len <= 2)
                dict.put(str, ZERO);
            else if (len == 3 || len == 4)
                dict.put(str, ONE);
            else if (len == 5)
                dict.put(str, TWO);
            else if (len == 6)
                dict.put(str, THREE);
            else if (len == 7)
                dict.put(str, FIVE);
            else
                dict.put(str, ELEVEN);
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
        int rows = board.rows();
        int cols = board.cols();
        Map<Integer, List<Point>> cache = new HashMap<Integer, List<Point>>();
//        Stack<Point> stack = null;
        Map<String, Integer> output = new TreeMap<String, Integer>();  
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];
                
//                stack = new Stack<Point>();
                Point p = getPoint(i, j);
//                visited[i][j] = true;
//                stack.push(p);
                dfs(board, p, visited, getLetter(board, p), output, cache);
                
            }
        }
        
        return output.keySet();
    }

    
    private void dfs(BoggleBoard board, Point p, boolean[][] visited, String s, Map<String, Integer> output, 
            Map<Integer, List<Point>> cache) {
        if (s.length() >= 2) {
            if (dict.contains(s))
                output.put(s, dict.get(s));
            //TODO need to check prefixMatch
            else if (!dict.contains(""))
//            else if (!dict.prefixMatch(s).iterator().hasNext())
                return;
        }
        
        visited[p.x][p.y] = true;
//        if (dict.prefixMatch(s + getLetter(board, p)).iterator().hasNext()) {
            List<Point> edges = getEdges(p, board.rows(), board.cols(), cache);
            for (Point point : edges) {
                if (!visited[point.x][point.y]) { 
                    dfs(board, point, visited, s + getLetter(board, point), output, cache);
    //                visited[point.x][point.y]= false;
                }
            }
//        }
        visited[p.x][p.y] = false;
    }
    
    private String getLetter(BoggleBoard board, Point p) {
        char c = board.getLetter(p.x, p.y);
        if (c == 'Q')
            return "QU";
        return Character.toString(c);
    }
    
    private List<Point> getEdges(Point point, int rows, int cols, Map<Integer, List<Point>> cache) {
        int i = point.x;
        int j = point.y;
        
        List<Point> edges = cache.get(i * cols + j);
        
        if (null == edges) {
            edges = new ArrayList<Point>();
            
            if (i - 1 >= 0) {
                edges.add(getPoint(i - 1, j));
                if (j - 1 >= 0)
                    edges.add(getPoint(i - 1, j - 1));
                if (j + 1 < cols)
                    edges.add(getPoint(i - 1, j + 1));
            }
            
            if (i + 1 < rows) {
                edges.add(getPoint(i + 1, j));
                if (j - 1 >= 0)
                    edges.add(getPoint(i + 1, j - 1));
                if (j + 1 < cols)
                    edges.add(getPoint(i + 1, j + 1));
            }
            
            if (j - 1 >= 0)
                edges.add(getPoint(i, j - 1));
            
            if (j + 1 < cols)
                edges.add(getPoint(i, j + 1));
            
            cache.put(i * cols + j, edges);
        }
        return edges;
    }
    
    private Point getPoint(int i, int j) {
        Map<Integer, Point> pnts = null;
        if (points.size() > i)
            pnts = points.get(i);
        if (null == pnts) {
            pnts = new HashMap<Integer, Point>();
            points.put(Integer.valueOf(i), pnts);
        }
        Point p = null;
        if (pnts.size() > j)
            p = pnts.get(j);
        if (null == p) {
            p = new Point(i, j);
            pnts.put(j, p);
        }
        
        return p;
        
    }

    public static class Point {
        private int x, y;
        
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
        
        @Override
        public int hashCode() {
            return x * 31 + y;
        }
    }
    
    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word) {
        Integer val = dict.get(word);
        if (null != val)
            return val.intValue();
        return 0;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
//        In in = new In("boggle/dictionary-algs4.txt");
//        In in = new In("boggle/dictionary-yawl.txt");
        
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
//        BoggleBoard board = new BoggleBoard("boggle/board-points26539.txt");
        BoggleBoard board = new BoggleBoard(args[1]);
        
        int score = 0;
        for (String word : solver.getAllValidWords(board))
        {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);
    }

}
