import edu.princeton.cs.algs4.StdIn;

/**
 * Kallam
 * 7/15/2014
 * This class gives the subset of the given input items.
 */


public class Subset {

    /**
     * Prints the required number of input items.
     * @param args
     */
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        if (k > 0) {
            RandomizedQueue<String> rq = new RandomizedQueue<String>();
            String item = null;
            while (!StdIn.isEmpty()) {
                item = StdIn.readString();
                rq.enqueue(item);
            }
            for (int i = 0; i < k; i++) {
                System.out.println(rq.dequeue());
            }
        }

    }

}
