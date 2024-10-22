public class LinkedDeque<T> implements DequeInterface<T> {
    //Add (addtofront from DQ interface. ^^ THis will always
    //have an error without it. >:/

    private DLNode firstNode;
    private DLNode lastNode;

    public LinkedDeque() {
        firstNode = null;
        lastNode = null;
    } //default constuctor

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

    }






} //end Pub class linkeddeque
