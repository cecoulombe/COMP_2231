/* Author: Caitlin Coulombe, T00756521
 * Date: November 2, 2024
 * Course: COMP 2131
 * Assignment 4, Question 1: Complete the implementation of a DecisionTree, introduced 
 * in Chapter 19. This will require completing a number of methods from the source 
 * code for this chapter, particularly for LinkedBinaryTree. Your initial test should 
 * be the BackPainAnalyzer output from Listing 19.6 on page 746. Show test cases for 
 * at least two other correct traversals of this tree.
 * 
 * Develop and demonstrate another decision tre that is more complex than the BachPainAnalyzer 
 * tree. Provide at least two correct traversals of this tree as well.
 * 
 * ** This class is copied from and modified based on the original in Java Foundations version 4.0**
 */

import java.util.*;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T>
{
    // variables
    protected BinaryTreeNode<T> root;
    protected int modCount;

    //------------------------------------------------------------------------
    // Creates an empty binary tree
    //------------------------------------------------------------------------
    public LinkedBinaryTree()
    {
        root = null;
    }

    //------------------------------------------------------------------------
    // Creates a binary  tree with the specified element as its root
    //------------------------------------------------------------------------
    public LinkedBinaryTree(T element)
    {
        root = new BinaryTreeNode<T> (element);
    }

    //------------------------------------------------------------------------
    // Creates a binary tree with the specified element as its root and the 
    // given trees as its left child and right child
    //------------------------------------------------------------------------
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right)
    {
        root = new BinaryTreeNode<T> (element);
        root.setLeft(left.root);
        root.setRight(right.root);
    }

    //------------------------------------------------------------------------
    // Returns a reference to the root element
    //------------------------------------------------------------------------
    public T getRootElement() throws EmptyCollectionException
	{
        if (root == null)
        {
            throw new EmptyCollectionException("LinkedBinaryTree");
        }
            
        return (root.getElement());
	}

    //------------------------------------------------------------------------
    // Returns a reference to the root node
    //------------------------------------------------------------------------
    public BinaryTreeNode<T> getRootNode() throws EmptyCollectionException
	{
        if (root == null)
        {
            throw new EmptyCollectionException("LinkedBinaryTree");
        }
            
        return (root);
	}

    //------------------------------------------------------------------------
    // Returns the left subtree of the root of this tree
    //------------------------------------------------------------------------
    public LinkedBinaryTree<T> getLeft() throws EmptyCollectionException
	{
        if (root == null)
        {
            throw new EmptyCollectionException("Get left operation failed. The tree is empty");
        }
            
        LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
        result.root = root.getLeft();

        return result;
	}

    //------------------------------------------------------------------------
    // Returns the right subtree of the root of this tree
    //------------------------------------------------------------------------
    public LinkedBinaryTree<T> getRight() throws EmptyCollectionException
	{
        if (root == null)
        {
            throw new EmptyCollectionException("Get right operation failed. The tree is empty");        }
            
            LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
            result.root = root.getRight();
    
            return result;
	}

    //------------------------------------------------------------------------
    // Returns true if this binary tree is empty and false otherwise
    //------------------------------------------------------------------------
    public boolean isEmpty()
    {
        return root == null;
    }

    //------------------------------------------------------------------------
    // Returns the number of elements in this binary tree
    //------------------------------------------------------------------------
    public int size()
    {
        if(!isEmpty())
        {
            return root.numChildren() + 1;
        }
        return 0;
    }

    //------------------------------------------------------------------------
    // Returns true if the binary tree contains an element that matches the 
    // specified element and false otherwise
    //------------------------------------------------------------------------
    public boolean contains(T targetElement)
    {
        try {
            find(targetElement);
            return true;
        } catch (ElementNotFoundException e) {
            return false;
        }
    }

    //------------------------------------------------------------------------
    // Returns a reference to the specified element if it is found in this 
    // binary tree. Throws an exception if the specified element is not found
    //------------------------------------------------------------------------
    public T find(T targetElement) throws ElementNotFoundException
    {
        BinaryTreeNode<T> current = findNode(targetElement, root);
        if(current == null)
        {
            throw new ElementNotFoundException(String.valueOf(targetElement));
        }

        return (current.getElement());
    }

    //------------------------------------------------------------------------
    // Returns a reference to the specified target element if it is found in 
    // this binary tree
    //------------------------------------------------------------------------
    private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next)
    {
        if(next == null)
        {
            return null;
        }

        if(next.getElement().equals(targetElement))
        {
            return next;
        }

        BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());

        if(temp == null)
        {
            temp = findNode(targetElement, next.getRight());
        }

        return temp;
    }


    //------------------------------------------------------------------------
    // Returns a string representation of this binary tree showing the nodes 
    // in an inorder fashion
    //------------------------------------------------------------------------
    public String toString()
    {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inOrder(root, tempList);
        
        return tempList.toString();
    }

    //------------------------------------------------------------------------
    // Returns an iterator over the elements of this tree
    //------------------------------------------------------------------------
    public Iterator<T> iterator()
    {
        return iteratorInOrder();
    }

    //------------------------------------------------------------------------
    // Returns an iterator that represents an inorder traversal on this binary 
    // tree
    //------------------------------------------------------------------------
    public Iterator<T> iteratorInOrder()
    {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inOrder(root, tempList);

        return new TreeIterator(tempList.iterator());
    }

    //------------------------------------------------------------------------
    // Helper method which performs an inorder traversal
    //------------------------------------------------------------------------
    protected void inOrder(BinaryTreeNode<T> node, 
			ArrayUnorderedList<T> tempList) 
	{
		if (node != null)
		{
			inOrder(node.getLeft(), tempList);
			tempList.addToRear(node.getElement());
			inOrder(node.getRight(), tempList);
		}
	}

    //------------------------------------------------------------------------
    // Returns an iterator that represents a preorder traversal on this binary 
    // tree
    //------------------------------------------------------------------------
    public Iterator<T> iteratorPreOrder()
    {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        preOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    //------------------------------------------------------------------------
    // Helper method which performs a preorder traversal
    //------------------------------------------------------------------------
    protected void preOrder(BinaryTreeNode<T> node, 
			ArrayUnorderedList<T> tempList) 
	{
        if (node != null)
        {
            tempList.addToRear(node.getElement());
            preOrder(node.getLeft(), tempList);
            preOrder(node.getRight(), tempList);
        }
	}

    //------------------------------------------------------------------------
    // Returns an iterator that represents a postorder traversal on this binary 
    // tree
    //------------------------------------------------------------------------
    public Iterator<T> iteratorPostOrder()
    {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        postOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    //------------------------------------------------------------------------
    // Helper method which performs a postorder traversal
    //------------------------------------------------------------------------
    protected void postOrder(BinaryTreeNode<T> node, 
			ArrayUnorderedList<T> tempList) 
	{
        if (node != null)
        {
            postOrder(node.getLeft(), tempList);
            postOrder(node.getRight(), tempList);
            tempList.addToRear(node.getElement());
        }
	}

    //------------------------------------------------------------------------
    // Returns an iterator that represents a levelorder traversal on the binary 
    // tree
    //------------------------------------------------------------------------
    public Iterator<T> iteratorLevelOrder() 
	{
		ArrayUnorderedList<BinaryTreeNode<T>> nodes = 
				new ArrayUnorderedList<BinaryTreeNode<T>>();
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		BinaryTreeNode<T> current;

		nodes.addToRear(root);

		while (!nodes.isEmpty()) 
		{
			current = nodes.removeFirst();

			if (current != null)
			{
				tempList.addToRear(current.getElement());
				if (current.getLeft() != null)
					nodes.addToRear(current.getLeft());
				if (current.getRight() != null)
					nodes.addToRear(current.getRight());
			}
			else
				tempList.addToRear(null);
		}

		return new TreeIterator(tempList.iterator());
	}

    //------------------------------------------------------------------------
    // Inner class to represent an iterator over the elements of this tree
    //------------------------------------------------------------------------
    private class TreeIterator implements Iterator<T>
    {
        private int expectedModCount;
        private Iterator<T> iter;

        //------------------------------------------------------------------------
        // Sets up thi iterator using the specified iterator
        //------------------------------------------------------------------------
        public TreeIterator(Iterator<T> iter)
		{
			this.iter = iter;
			expectedModCount = modCount;
		}

        //------------------------------------------------------------------------
        // Returns true if this iterator has at least one more element to deliver 
        // in this iteration
        //------------------------------------------------------------------------
        public boolean hasNext() throws ConcurrentModificationException
		{
			if (!(modCount == expectedModCount))
				throw new ConcurrentModificationException();

			return (iter.hasNext());
		}

        //------------------------------------------------------------------------
        // Returns the next element in the iteration or throws a 
        // NoSuchElementException if there are no more elements in the iteration
        //------------------------------------------------------------------------
        public T next() throws NoSuchElementException
		{
			if (hasNext())
				return (iter.next());
			else 
				throw new NoSuchElementException();
		}
    }
}
