package Week8_Incomplete.TreePackage.AVLTree;


import Week8_Incomplete.StackAndQueueInterface.LinkedQueue;
import Week8_Incomplete.StackAndQueueInterface.QueueInterface;
import Week8_Incomplete.TreePackage.BinaryNode;
import Week8_Incomplete.TreePackage.BinarySearchTree.BinarySearchTree;

import java.util.NoSuchElementException;

public class AVLTree<T extends Comparable<? super T>>
        extends BinarySearchTree<T>
//           implements SearchTreeInterface<T>  // Optional since BinarySearchTree implements this interface
{
    public AVLTree()
    {
        super();
    } // end default constructor

    public AVLTree(T rootEntry)
    {
        super(rootEntry);
    } // end constructor

    public T add(T newEntry)
    {
        T result = null;

        if (isEmpty())
            setRootNode(new BinaryNode<>(newEntry));
        else
        {
            BinaryNode<T> rootNode = getRootNode();
            result = addEntry(rootNode, newEntry);
            setRootNode(rebalance(rootNode));
        } // end if

        return result;
    } // end add

    private T addEntry(BinaryNode<T> rootNode, T newEntry)
    {
        // Assertion: rootNode != null
        T result = null;
        int comparison = newEntry.compareTo(rootNode.getData());

        if (comparison == 0)
        {
            result = rootNode.getData();
            rootNode.setData(newEntry);
        }
        else if (comparison < 0)
        {
            if (rootNode.hasLeftChild())
            {
                result = addEntry(rootNode.getLeftChild(), newEntry);
                rootNode.setLeftChild(rebalance(rootNode.getLeftChild()));
            }
            else
                rootNode.setLeftChild(new BinaryNode<>(newEntry));
        }
        else
        {
            // Assertion: comparison > 0

            if (rootNode.hasRightChild())
            {
                result = addEntry(rootNode.getRightChild(), newEntry);
                rootNode.setRightChild(rebalance(rootNode.getRightChild()));
            }
            else
                rootNode.setRightChild(new BinaryNode<>(newEntry));
        } // end if

        return result;
    } // end addEntry

    public T remove(T entry)
    {
        throw new UnsupportedOperationException();
    } // end remove

    private BinaryNode<T> rebalance(BinaryNode<T> nodeN)
    {

    } // end rebalance

    private BinaryNode<T> rotateRight(BinaryNode<T> nodeN)
    {

    } // end rotateRight

    // Corrects an imbalance at the node closest to a structural
    // change in the right subtree of the node's right child.
    // nodeN is a node, closest to the newly added leaf, at which
    // an imbalance occurs and that has a right child.
    private BinaryNode<T> rotateLeft(BinaryNode<T> nodeN)
    {

    } // end rotateLeft

    // Corrects an imbalance at the node closest to a structural
    // change in the left subtree of the node's right child.
    // nodeN is a node, closest to the newly added leaf, at which
    // an imbalance occurs and that has a right child.
    private BinaryNode<T> rotateRightLeft(BinaryNode<T> nodeN)
    {

    } // end rotateRightLeft

    // Corrects an imbalance at the node closest to a structural
    // change in the right subtree of the node's left child.
    // nodeN is a node, closest to the newly added leaf, at which
    // an imbalance occurs and that has a left child.
    private BinaryNode<T> rotateLeftRight(BinaryNode<T> nodeN)
    {

    } // end rotateLeftRight

    // Returns the difference in heights of the given node's
    // left and right subtrees.
    private int getHeightDifference(BinaryNode<T> node)
    {
        BinaryNode<T> left = node.getLeftChild();
        BinaryNode<T> right = node.getRightChild();

        int leftHeight, rightHeight;

        if (left == null)
            leftHeight = 0;
        else
            leftHeight = left.getHeight();

        if (right == null)
            rightHeight = 0;
        else
            rightHeight = right.getHeight();

        return leftHeight - rightHeight;
    } // end getHeightDifference

	// For testing: displays node data in level order
	public void display()
	{
		QueueInterface<BinaryNode<T>> nodeQueue = new LinkedQueue<BinaryNode<T>>();
		BinaryNode<T> root = getRootNode();

		if (root != null)
			nodeQueue.enqueue(root);

		int nodesPerLevel = 1;
		while (!nodeQueue.isEmpty())
			nodesPerLevel = displayNextLevel(nodesPerLevel, nodeQueue);
	} // end display

	private int displayNextLevel(int nodesPerLevel, QueueInterface<BinaryNode<T>> nodeQueue)
	{
		int nextLevelCount = 0;
		for (int count = 0; count < nodesPerLevel; count++)
		{
			if (!nodeQueue.isEmpty())
			{
				BinaryNode<T> nextNode = nodeQueue.dequeue();
				BinaryNode<T> leftChild = nextNode.getLeftChild();
				BinaryNode<T> rightChild = nextNode.getRightChild();

				// add to queue in order of recursive calls
				if (leftChild != null)
				{	nodeQueue.enqueue(leftChild);
					nextLevelCount++;
				} // end if

				if (rightChild != null)
				{	nodeQueue.enqueue(rightChild);
					nextLevelCount++;
				} // end if

				System.out.print(nextNode.getData() + " ");
			}
			else
				throw new NoSuchElementException();
		} // end for
		System.out.println();

		return nextLevelCount;
	} // end displayNextLevel
} // end AVLTree
