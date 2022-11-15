package Week8_Incomplete.TreePackage;


import Week8_Incomplete.StackAndQueueInterface.LinkedQueue;
import Week8_Incomplete.StackAndQueueInterface.LinkedStack;
import Week8_Incomplete.StackAndQueueInterface.QueueInterface;
import Week8_Incomplete.StackAndQueueInterface.StackInterface;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 A class that implements the ADT binary tree.

 @author Frank M. Carrano
 @author Timothy M. Henry
 @version 5.1
 */
public class BinaryTree<T> implements BinaryTreeInterface<T>
{
    private BinaryNode<T> root;

    public BinaryTree()
    {
        root = null;
    } // end default constructor

    public BinaryTree(T rootData)
    {
        root = new BinaryNode<>(rootData);
    } // end constructor

    public BinaryTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
    {
        initializeTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
    } // end constructor


    // setTree is converting the interfaces passed in to Binary Tree type/
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                        BinaryTreeInterface<T> rightTree)
    {
        initializeTree(rootData, (BinaryTree<T>)leftTree,
                (BinaryTree<T>)rightTree);
    } // end setTree

    private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
    {
        root = new BinaryNode<>(rootData);

        if ((leftTree != null) && !leftTree.isEmpty())
            root.setLeftChild(leftTree.root);

        if ((rightTree != null) && !rightTree.isEmpty())
        {
            if (rightTree != leftTree)
                root.setRightChild(rightTree.root);
            else
                root.setRightChild(rightTree.root.copy());
        } // end if

        if ((leftTree != null) && (leftTree != this))
            leftTree.clear();

        if ((rightTree != null) && (rightTree != this))
            rightTree.clear();
    } // end initializeTree

    public void setRootData(T rootData)
    {
        root.setData(rootData);
    } // end setRootData

    public T getRootData()
    {
        if (isEmpty())
            throw new EmptyTreeException();
        else
            return root.getData();
    } // end getRootData

    public boolean isEmpty()
    {
        return root == null;
    } // end isEmpty

    public void clear()
    {
        root = null;
    } // end clear

    public int getHeight()
    {
        int height = 0;
        if (root != null)
            height = root.getHeight();
        return height;
    } // end getHeight


    //Runtime estimate: O(N)
    public int countLeaves(){
        BinaryNode node = root;
        int leaves = 0;
        Stack<BinaryNode> stack = new Stack<>();
        if(node != null){
            stack.push(node);
        }
        BinaryNode nextNode;
        while (!stack.isEmpty()){
            nextNode = stack.pop();

            BinaryNode rightChild = nextNode.getRightChild();
            BinaryNode leftChild = nextNode.getLeftChild();

            if (rightChild != null){
                stack.push(rightChild);
            }
            if (leftChild != null){
                stack.push(leftChild);
            }
            if(nextNode.isLeaf()){
                leaves++;
            }
        }
        return leaves;


    }

    //Runtime estimate: O(N)
    public int countLefts(){
        BinaryNode node = root;
        int lefts = 0;
        Stack<BinaryNode> stack = new Stack<>();
        if(node != null){
            stack.push(node);
        }
        BinaryNode nextNode;
        while (!stack.isEmpty()){
            nextNode = stack.pop();

            BinaryNode rightChild = nextNode.getRightChild();
            BinaryNode leftChild = nextNode.getLeftChild();

            if (rightChild != null){
                stack.push(rightChild);
            }
            if (leftChild != null){
                lefts++;
                stack.push(leftChild);
            }
        }
        return lefts;


    }

    public boolean isFull(){
        BinaryNode node = root;
        Stack<BinaryNode> stack = new Stack<>();
        if(node != null){
            stack.push(node);
        }
        BinaryNode nextNode;
        while (!stack.isEmpty()){
            nextNode = stack.pop();

            BinaryNode rightChild = nextNode.getRightChild();
            BinaryNode leftChild = nextNode.getLeftChild();

            if (rightChild != null){
                stack.push(rightChild);
            }
            if (leftChild != null){
                stack.push(leftChild);
            }
            if (!nextNode.isLeaf() && (rightChild == null || leftChild == null)){
                return false;
            }
        }
        return true;


    }

    public BinaryNode removeLeaves(BinaryNode node){
        if (!(node!= null && !node.isLeaf())){
            return null;
        }
        else{
            if (node.getLeftChild() != null){
                if (node.getLeftChild().isLeaf()){
                    node.setLeftChild(null);
                }
                else{
                    removeLeaves(node.getLeftChild());
                }
            }
            if (node.getRightChild() != null){
                if (node.getRightChild().isLeaf()){
                    node.setRightChild(null);
                }
                else{
                    removeLeaves(node.getRightChild());
                }
            }

        }
        return node;


    }

    private void removeLeavesRecur(BinaryNode node){

    }
    public int getNumberOfNodes()
    {
        int numberOfNodes = 0;
        if (root != null)
            numberOfNodes = root.getNumberOfNodes();
        return numberOfNodes;
    } // end getNumberOfNodes

    protected void setRootNode(BinaryNode<T> rootNode)
    {
        root = rootNode;
    } // end setRootNode

    protected BinaryNode<T> getRootNode()
    {
        return root;
    } // end getRootNode

    public Iterator<T> getPreorderIterator()
    {
        return new PreorderIterator();
    } // end getPreorderIterator

    public Iterator<T> getPostorderIterator()
    {
        return new PostorderIterator();
    } // end getPostorderIterator

    public Iterator<T> getInorderIterator()
    {
        return new InorderIterator();
    } // end getInorderIterator

    public Iterator<T> getLevelOrderIterator()
    {
        return new LevelOrderIterator();
    } // end getLevelOrderIterator

    public void iterativePreorderTraverse()
    {
        StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
        if (root != null)
            nodeStack.push(root);
        BinaryNode<T> nextNode;
        while (!nodeStack.isEmpty())
        {
            nextNode = nodeStack.pop();
            BinaryNode<T> leftChild = nextNode.getLeftChild();
            BinaryNode<T> rightChild = nextNode.getRightChild();

            // Push into stack in reverse order of recursive calls
            if (rightChild != null)
                nodeStack.push(rightChild);

            if (leftChild != null)
                nodeStack.push(leftChild);

            System.out.print(nextNode.getData() + " ");
        } // end while
    } // end iterativePreorderTraverse

    public void iterativeInorderTraverse()
    {
        StackInterface<BinaryNode<T>> nodeStack = new LinkedStack<>();
        BinaryNode<T> currentNode = root;

        while (!nodeStack.isEmpty() || (currentNode != null))
        {
            // Find leftmost node with no left child
            while (currentNode != null)
            {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            } // end while

            // Visit leftmost node, then traverse its right subtree
            if (!nodeStack.isEmpty())
            {
                BinaryNode<T> nextNode = nodeStack.pop();
                // Assertion: nextNode != null, since nodeStack was not empty
                // before the pop
                System.out.print(nextNode.getData() + " ");
                currentNode = nextNode.getRightChild();
            } // end if
        } // end while
    } // end iterativeInorderTraverse

    private class PreorderIterator implements Iterator<T>
    {
        private StackInterface<BinaryNode<T>> nodeStack;

        public PreorderIterator()
        {
            nodeStack = new LinkedStack<>();
            if (root != null)
                nodeStack.push(root);
        } // end default constructor

        public boolean hasNext()
        {
            return !nodeStack.isEmpty();
        } // end hasNext

        public T next()
        {
            BinaryNode<T> nextNode;

            if (hasNext())
            {
                nextNode = nodeStack.pop();
                BinaryNode<T> leftChild = nextNode.getLeftChild();
                BinaryNode<T> rightChild = nextNode.getRightChild();

                // Push into stack in reverse order of recursive calls
                if (rightChild != null)
                    nodeStack.push(rightChild);

                if (leftChild != null)
                    nodeStack.push(leftChild);
            }
            else
            {
                throw new NoSuchElementException();
            }

            return nextNode.getData();
        } // end next

        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    } // end PreorderIterator

    private class PostorderIterator implements Iterator<T>
    {
        private StackInterface<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;

        public PostorderIterator()
        {
            nodeStack = new LinkedStack<>();
            currentNode = root;
        } // end default constructor

        public boolean hasNext()
        {
            return !nodeStack.isEmpty() || (currentNode != null);
        } // end hasNext

        public T next()
        {
            BinaryNode<T> leftChild, rightChild, nextNode = null;

            // Find leftmost leaf
            while (currentNode != null)
            {
                nodeStack.push(currentNode);
                leftChild = currentNode.getLeftChild();
                if (leftChild == null)
                    currentNode = currentNode.getRightChild();
                else
                    currentNode = leftChild;
            } // end while

            // Stack is not empty either because we just pushed a node, or
            // it wasn't empty initially since hasNext() is true.
            // But Iterator specifies an exception for next() in case
            // hasNext() is false.

            if (!nodeStack.isEmpty())
            {
                nextNode = nodeStack.pop();
                // nextNode != null since stack was not empty before pop

                BinaryNode<T> parent = null;
                if (!nodeStack.isEmpty())
                {
                    parent = nodeStack.peek();
                    if (nextNode == parent.getLeftChild())
                        currentNode = parent.getRightChild();
                    else
                        currentNode = null;
                }
                else
                    currentNode = null;
            }
            else
            {
                throw new NoSuchElementException();
            } // end if

            return nextNode.getData();
        } // end next

        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    } // end PostorderIterator

    private class InorderIterator implements Iterator<T>
    {
        private StackInterface<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;

        public InorderIterator()
        {
            nodeStack = new LinkedStack<>();
            currentNode = root;
        } // end default constructor

        public boolean hasNext()
        {
            return !nodeStack.isEmpty() || (currentNode != null);
        } // end hasNext

        public T next()
        {
            BinaryNode<T> nextNode = null;

            // Find leftmost node with no left child
            while (currentNode != null)
            {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            } // end while

            // Get leftmost node, then move to its right subtree
            if (!nodeStack.isEmpty())
            {
                nextNode = nodeStack.pop();
                // Assertion: nextNode != null, since nodeStack was not empty
                // before the pop
                currentNode = nextNode.getRightChild();
            }
            else
                throw new NoSuchElementException();

            return nextNode.getData();
        } // end next

        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    } // end InorderIterator

    private class LevelOrderIterator implements Iterator<T>
    {
        private QueueInterface<BinaryNode<T>> nodeQueue;

        public LevelOrderIterator()
        {
            nodeQueue = new LinkedQueue<>();
            if (root != null)
                nodeQueue.enqueue(root);
        } // end default constructor

        public boolean hasNext()
        {
            return !nodeQueue.isEmpty();
        } // end hasNext

        public T next()
        {
            BinaryNode<T> nextNode;

            if (hasNext())
            {
                nextNode = nodeQueue.dequeue();
                BinaryNode<T> leftChild = nextNode.getLeftChild();
                BinaryNode<T> rightChild = nextNode.getRightChild();

                // Add to queue in order of recursive calls
                if (leftChild != null)
                    nodeQueue.enqueue(leftChild);

                if (rightChild != null)
                    nodeQueue.enqueue(rightChild);
            }
            else
            {
                throw new NoSuchElementException();
            }

            return nextNode.getData();
        } // end next

        public void remove()
        {
            throw new UnsupportedOperationException();
        } // end remove
    } // end LevelOrderIterator
} // end BinaryTree

