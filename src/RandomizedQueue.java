/**
 * Kallam
 * 7/14/2014
 * This class provides the randamized queue implementation.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] queue;
    private int size;
    
    /**
     * construct an empty randomized queue
     */
    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
    }
    
    /**
     * is the queue empty
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * return the number of items on the queue
     * @return
     */
    public int size() {
        return size;
    }
    
    /**
     * add the item
     * @param item
     */
    public void enqueue(Item item) {
        if (null == item) 
            throw new NullPointerException("Trying to add null");
        
        if (size == queue.length)
            resize(2*queue.length);
        queue[size++] = item;
    }
    
    /**
     * To change the queue size.
     * @param capacity
     */
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) 
            copy[i] = queue[i];
        queue = copy;
    }

    /**
     * delete and return a random item
     * @return
     */
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Trying to remove from empty RandomizedQueue");
        
        int random = StdRandom.uniform(size);
        swapItem(random);
        Item temp = queue[size-1];
        queue[--size] = null;
        if (size != 0 && size == queue.length/4)
            resize(queue.length/2);
        return temp;
    }
    
    /**
     * to swap the items.
     * @param random
     */
    private void swapItem(int random) {
        Item temp = queue[random];
        queue[random] = queue[size-1];
        queue[size-1] = temp;
    }

    /**
     * return a random item
     * @return
     */
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("Trying to access empty RandomizedQueue");
        
        int random = StdRandom.uniform(size);
        return queue[random];
    }
    
    /**
     * return an independent iterator over items in random order
     */
    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    /**
     * Iterator for the queue.
     * @author kallam
     *
     * @param <Item>
     */
    private class RandomizedQueueIterator implements Iterator<Item> {

        private Item[] itr = null;
        private int pointer;
        
        /**
         * clone the queue.
         */
        public RandomizedQueueIterator() {
            itr = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                itr[i] = queue[i];
            }
            StdRandom.shuffle(itr);
        }
        
        /**
         * has next item.
         */
        @Override
        public boolean hasNext() {
            return pointer < size;
        }

        /**
         * return the next item.
         */
        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("Reached the end of Dequeue");
            return itr[pointer++];
        }

        /**
         * remove method is not supported at this time.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove method is not supported at this time on Iterator");
        }
        
    }
    
    /**
     * To test the program.
     * @param args
     */
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        rq.enqueue("one");
//        rq.enqueue("two");
//        rq.enqueue("three");
//        rq.enqueue("four");
//        rq.enqueue("five");
        rq.dequeue();
        rq.enqueue("two");
//        rq.dequeue();
//        rq.dequeue();
//        rq.dequeue();
        

    }

}
