import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Double-ended que
 * Class allows for adding and removing elements
 * @param <T>
 */
public class LinkedDeque<T> implements DequeInterface<T> {

    private DLNode firstNode;
    private DLNode lastNode;

    /**
     * Creates an empty deque.
     */

    public LinkedDeque() {
        firstNode = null;
        lastNode = null;
    } //default constuctor

    /**
     * Adds a new entry to the front of the deque.
     * @param newEntry the element that will be added
     */

    public void addToFront(T newEntry) {
        DLNode newNode = new DLNode(newEntry, null);
        if(isEmpty()) {
            lastNode = newNode;
        } else {
            firstNode.setPreviousNode(newNode);
        }
        firstNode = newNode;
    }

    /**
     * Does the opposite of addToFront and adds a new entry to the back of the deque.
     * @param newEntry the element that will be added
     */

    public void addToBack(T newEntry) {
        DLNode newNode = new DLNode(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

    /**
     * Removes and returns the front entry of the deque,
     * @return the element at the front
     * @throws EmptyQueException if the deque is empty
     */

    public T removeFront() {
        T front = null;
        try {
            front = getFront(); //Might throw emptyQueException
            // Assertion: firstNode != null
        } catch (EmptyQueException e) {
            System.out.println(e.getMessage());
        }

        firstNode = firstNode.getNextNode();

        if (firstNode == null) {
            lastNode = null;
        } else {
            firstNode.setPreviousNode(null);
        }
        return front;
    }

    /**
     * Removes and returns the back entry of the deque.
     * @return the element at the back
     * @throws EmptyQueException if the deque is empty
     */

    public T removeBack() {
        T back = null;
        try {
            back = getBack(); //Might throw EmptyQueException;
            //Assertion: lastNode != null
        } catch (EmptyQueException e) {
            System.out.println(e.getMessage());

        }

        lastNode = lastNode.getPreviousNode();

        if (lastNode == null) {
            firstNode = null;
        } else {
            lastNode.setNextNode(null);
        }
        return back;
    }

    /**
     * Sees if the deque is empty.
     * @return true if the deque is empty; false elsewise
     */

    public boolean isEmpty()
    {
        return (firstNode == null) && (lastNode == null);

    } // end isEmpty

    /**
     * Gets the front entry of the deque but doesn't remove it.
     * @return the element at the front of the deque
     * @throws EmptyQueException if the deque is empty
     */

    public T getFront() throws EmptyQueException {
        if (isEmpty()) {
            throw new EmptyQueException();
        } else {
            return firstNode.getData();
        }
    }

    /*
    when calling get Front:
    To handle the exception:
    Pubic void example() {
        T front = null;
        try {
            front = queue,getFront();
            //use the front value
        } catch (EmptyQueException e) {
            System.out.println(e.getMessage());
        }
    }
     */

    /**
     * Gets the back entry of the deque but doesn't remove it.
     * @return the element at the back of the deque
     * @throws EmptyQueException if the deque is empty
     */

    public T getBack() throws EmptyQueException {
        if (isEmpty()) {
            throw new EmptyQueException();
        } else {
            return lastNode.getData();
        }
    }

    /**
     * Clears the deque.
     */

    public void clear()
    {
        firstNode = null;
        lastNode = null;
    } // end clear

    /**
     * Private inner class representing one node.
     */

    private class DLNode {

        private T data; //Deque entry
        private DLNode next; //Link to next node
        private DLNode previous; //Link to previous node

        /**
         * Initializes a node with the specified data.
         * @param dataPortion the data stored in the node
         */

        private DLNode(T dataPortion)
        {
            data = dataPortion;
            next = null;
        } // end constructor

        /**
         * Initializes a node with the specified data and the next node in the link
         * @param dataPortion the data that will be stored
         * @param linkPortion the next node in the deque
         */

        private DLNode(T dataPortion, DLNode linkPortion)
        {
            data = dataPortion;
            next = linkPortion;
        } // end constructor

        private T getData()
        {
            return data;
        } // end getData

        private void setData(T newData)
        {
            data = newData;
        } // end setData

        private DLNode getNextNode()
        {
            return next;
        } // end getNextNode

        private void setNextNode(DLNode nextNode)
        {
            next = nextNode;
        } // end setNextNode

        private DLNode getPreviousNode() {
            return previous;
        } // end getPreviousNode

        private void setPreviousNode(DLNode previousNode) {
            previous = previousNode;
        } // end setPreviousNode

    } // end DLNode

    /**
     * Returns an iterator for the deque.
     * @return an iterator for the deque
     */

    public Iterator<T> iterator()
    {
        return new IteratorForLinkedDequeList();
    } // end iterator

    /**
     * Returns an iterator for the deque.
     * @return an iterator for the deque
     */

    public Iterator<T> getIterator()
    {
        return iterator();
    } // end getIterator

    /**
     * A private inner class implementing an iterator for the deque.
     */

    private class IteratorForLinkedDequeList implements Iterator<T> {

        private DLNode nextNode;

        private IteratorForLinkedDequeList() {
            nextNode = firstNode;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element
         * @throws NoSuchElementException if the iteration has no more elements
        */

        public T next() {
            T result;
            if (hasNext()) {
                result = nextNode.getData();
                nextNode = nextNode.getNextNode();
            } else {
                throw new NoSuchElementException("Illegal call. Iterator is after end of list.");
            }
            return result;
        }

        /**
         * Sees if there is a next element.
         * @return true is there's an next element; false if not
         */

        public boolean hasNext()
        {
            return nextNode != null;
        }


    }


} //end Pub class linkeddeque
