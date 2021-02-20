/*
Given an Iterator class interface with methods: next() and hasNext(),
design and implement a PeekingIterator that support the peek() operation --
it essentially peek() at the element that will be returned by the next call to next().

Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
You call next() the final time and it returns 3, the last element.
Calling hasNext() after that should return false.
 */
package others;

import java.util.Arrays;
import java.util.Iterator;

public class PeekingIteratorClient {
    public static void main(String[] args) {
        int[] num = new int[] {1,2,3,4,5};
        Iterator<Integer> numIter = Arrays.stream(num).iterator();
        PeekingIterator pi = new PeekingIterator(numIter);
        System.out.println(pi.peek());
        System.out.println(pi.next());
        System.out.println(pi.next());
        System.out.println(pi.hasNext());
        System.out.println(pi.peek());
    }
}

class PeekingIterator implements Iterator<Integer> {
    private boolean hasPeeked = false;
    private Integer peekedElement;
    private final Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            peekedElement = iterator.next();
            hasPeeked = true;
        }
        return peekedElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasPeeked) {
            return iterator.next();
        }
        Integer element = peekedElement;
        hasPeeked = false;
        peekedElement = null;
        return element;

    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }
}