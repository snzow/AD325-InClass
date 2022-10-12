package Week3.Queues.TwoPartCircularLinkedQueue;


import Week3.Queues.EmptyQueueException;

//public class TwoPartCircularLinkedQueue<T> implements QueueInterface<T> {
public class TwoPartCircularLinkedQueue<T> {
    private Node queueNode; // References first node in queue
    private Node freeNode;  // References node after back of queue

    public TwoPartCircularLinkedQueue()
    {
        freeNode = new Node(null, null);
        freeNode.setNextNode(freeNode);
        queueNode = freeNode;
    } // end default constructor

    public void enqueue(T newEntry)
    {
        freeNode.setData(newEntry);

        if (isNewNodeNeeded())
        {
            // Allocate a new node and insert it after the node that
            // freeNode references
            Node newNode = new Node(null, freeNode.getNextNode());
            freeNode.setNextNode(newNode);
        } // end if

        freeNode = freeNode.getNextNode();
    } // end enqueue

    public T getFront() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return queueNode.getData();
    } // end getFront

    public T dequeue() throws EmptyQueueException {
        T front = getFront();  // Might throw EmptyQueueException
        // Assertion: Queue is not empty
        queueNode.setData(null);
        queueNode = queueNode.getNextNode();

        return front;
    } // end dequeue

    public boolean isEmpty()
    {
        return queueNode == freeNode;
    } // end isEmpty

    public void clear() throws EmptyQueueException {
        while (!isEmpty())
            dequeue();
    } // end clear

    private boolean isNewNodeNeeded()
    {
        return queueNode == freeNode.getNextNode();
    } // end isNewNodeNeeded

    private class Node
    {
        private T    data;  // Queue entry
        private Node next;  // Link to next node

        private Node(T dataPortion)
        {
            data = dataPortion;
            next = null;
        } // end constructor

        private Node(T dataPortion, Node linkPortion)
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

        private Node getNextNode()
        {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } // end setNextNode
    } // end Node
}
