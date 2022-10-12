package Week3.Queues.LinkedQueue;


import Week3.Queues.EmptyQueueException;
import Week3.Queues.QueueInterface;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode; // References node at front of queue
    private Node lastNode;  // References node at back of queue

    public LinkedQueue()
    {
        firstNode = null;
        lastNode = null;
    } // end default constructor

    public void enqueue(T newEntry) // O(1)
    {
        Node newNode = new Node(newEntry, null);

        if (isEmpty())
            firstNode = newNode;
        else
            lastNode.setNextNode(newNode);

        lastNode = newNode;
    } // end enqueue

    public T getFront() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return firstNode.getData();
    } // end getFront



    public T dequeue() throws EmptyQueueException { // O(1)
        T front = getFront();  // Might throw EmptyQueueException
        // Assertion: firstNode != null
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null)
            lastNode = null;

        return front;
    } // end dequeue

    public boolean isEmpty()
    {
        return (firstNode == null) && (lastNode == null);
    } // end isEmpty

    public void clear()
    {
        firstNode = null;
        lastNode = null;
    } // end clear

    private class Node
    {
        private T    data; // Entry in queue
        private Node next; // Link to next node

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

    public void display() {
        Node temp = firstNode;
        while (firstNode != null) {
            System.out.print(firstNode.getData() + " ");
            firstNode = firstNode.next;
        }
        firstNode = temp;
    }

    public Iterator<T> iterator()
    {
        return new IteratorForLinkedList();
    } // end iterator

    public Iterator<T> getIterator()
    {
        return iterator();
    } // end getIterator

    private class IteratorForLinkedList implements Iterator<T>
    {
        private Node nextNode;

        private IteratorForLinkedList()
        {
            nextNode = firstNode;
        } // end default constructor

        public T next()
        {
            T result;
            if (hasNext())
            {
                result = nextNode.getData();
                nextNode = nextNode.getNextNode(); // Advance iterator
            }
            else
                throw new NoSuchElementException("Illegal call to next(); " +
                        "iterator is after end of list.");
            return result; // Return next entry in iteration
        } // end next

        public boolean hasNext()
        {
            return nextNode != null;
        } // end hasNext

        public void remove()
        {
            throw new UnsupportedOperationException("remove() is not supported " +
                    "by this iterator");
        } // end remove
    } // end IteratorForLinkedList

    public int size() {
        Node temp = firstNode;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}
