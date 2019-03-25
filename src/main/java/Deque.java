/**
 * Kallam
 * 7/14/2014
 * This class provides the stack and queue implementation.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;
    
    /**
     * construct an empty deque
     */
    public Deque() {
        first = new Node();
        last = new Node();
        first.next = last;
        last.previous = first;
    }
    
    /**
     * is the deque empty
     * @return
     */
    public boolean isEmpty() {
        return size == 0; //first.next == last;// && last.previous == first;
    }
    
    /**
     * return the number of items on the deque
     * @return
     */
    public int size() {
        return size;
    }
    
    /**
     * insert the item at the front
     * @param item
     */
    public void addFirst(Item item) {
        if (null == item) 
            throw new NullPointerException("Trying to add null");
        
        Node temp = new Node();
        temp.item = item;
        first.next.previous = temp;
        temp.next = first.next;
        temp.previous = first;
        first.next = temp;
        size++;
    }
    
    /**
     * insert the item at the end
     * @param item
     */
    public void addLast(Item item) {
        if (null == item) 
            throw new NullPointerException("Trying to add null");
        
        Node temp = new Node();
        temp.item = item;
        last.previous.next = temp;
        temp.previous = last.previous;
        temp.next = last;
        last.previous = temp;
        size++;
    }
    
    /**
     * delete and return the item at the front
     * @return
     */
    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Trying to remove from empty Deque");
        
        Node temp = first.next;
        temp.next.previous = first;
        first.next = temp.next;
        size--;
        return temp.item;
    }
    
    /**
     * delete and return the item at the end
     * @return
     */
    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException("Trying to remove from empty Deque");
        
        Node temp = last.previous;
        temp.previous.next = last;
        last.previous = temp.previous;
        size--;
        return temp.item;
    }
    
    /**
     * return an iterator over items in order from front to end
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * Node to hold the Item and the connections.
     * @author c0kalla
     *
     */
    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }
    
    /**
     * Iterator for the deque.
     * @author kallam
     *
     */
    private class ListIterator implements Iterator<Item> {

        private Node current = first.next;
        
        /**
         * has next item.
         */
        @Override
        public boolean hasNext() {
            return current != last;
        }

        /**
         * return the next item.
         */
        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("Reached the end of Dequeue");
            Item item = current.item;
            current = current.next;
            return item;
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
        Deque<String> dq = new Deque<String>();
        dq.addFirst("one");
        dq.removeFirst();

    }

}
