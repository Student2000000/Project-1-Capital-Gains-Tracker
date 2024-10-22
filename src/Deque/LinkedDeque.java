import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<T> implements DequeInterface<T> {

    private DLNode firstNode;
    private DLNode lastNode;

    public LinkedDeque() {
        firstNode = null;
        lastNode = null;
    } //default constuctor

    public void addToFront(T newEntry) {
        DLNode newNode = new DLNode(newEntry, null);
        if(isEmpty()) {
            lastNode = newNode;
        } else {
            firstNode.setPreviousNode(newNode);
        }
        firstNode = newNode;
    }

    public void addToBack(T newEntry) {
        DLNode newNode = new DLNode(newEntry, null);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

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

    public boolean isEmpty()
    {
        return (firstNode == null) && (lastNode == null);

    } // end isEmpty

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

    public T getBack() throws EmptyQueException {
        if (isEmpty()) {
            throw new EmptyQueException();
        } else {
            return lastNode.getData();
        }
    }

    public void clear()
    {
        firstNode = null;
        lastNode = null;
    } // end clear



    private class DLNode {

        private T data; //Deque entry
        private DLNode next; //Link to next node
        private DLNode previous; //Link to previous node

        private DLNode(T dataPortion)
        {
            data = dataPortion;
            next = null;
        } // end constructor

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

    public Iterator<T> iterator()
    {
        return new IteratorForLinkedDequeList();
    } // end iterator

    public Iterator<T> getIterator()
    {
        return iterator();
    } // end getIterator

    private class IteratorForLinkedDequeList implements Iterator<T> {

        private DLNode nextNode;

        private IteratorForLinkedDequeList() {
            nextNode = firstNode;
        }

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

        public boolean hasNext()
        {
            return nextNode != null;
        }


    }


} //end Pub class linkeddeque
