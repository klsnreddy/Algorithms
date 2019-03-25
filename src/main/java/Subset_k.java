/**
 * Kallam
 * 7/15/2014
 * This class gives the subset of the given input items.
 */
import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;


public class Subset_k {

    /**
     * Prints the required number of input items.
     * @param args
     */
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        if (k > 0) {
            RandomizedQueue<String> rq = new RandomizedQueue<String>();
            int i = 1;
            String item = null;
            while (!StdIn.isEmpty()) {
                item = StdIn.readString();
                if (i++ > k) {
                    rq.dequeue();
                } 
                rq.enqueue(item);
            }
            Iterator<String> itr = rq.iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
        }

    }

}
