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

 import java.util.Iterator;

/**
 * BinaryTreeADT defines the interface to a binary tree data structure.
 *
 * @author Java Foundations
 * @version 4.0
 */
public interface BinaryTreeADT<T> {
    /**
     * Returns a reference to the root element
     *
     * @return a reference to the root
     */
    public T getRootElement();

    /**
     * Returns true if this binary tree is empty and false otherwise.
     *
     * @return true if this binary tree is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this binary tree.
     *
     * @return the number of elements in the tree
     */
    public int size();

    /**
     * Returns true if the binary tree contains an element that matches
     * the specified element and false otherwise.
     *
     * @param targetElement the element being sought in the tree
     * @return true if the tree contains the target element
     */
    public boolean contains(T targetElement);

    /**
     * Returns a reference to the specified element if it is found in
     * this binary tree. Throws an exception if the specified element
     * is not found.
     *
     * @param targetElement the element being sought in the tree
     * @return a reference to the specified element
     */
    public T find(T targetElement);

    /**
     * Returns the string representation of this binary tree.
     *
     * @return a string representation of the binary tree
     */
    public String toString();

    /**
     * Returns an iterator over the elements of this tree.
     *
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iterator();

    /**
     * Returns an iterator that represents an inorder traversal on this binary tree.
     * *
     * 
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorInOrder();

    /**
     * Returns an iterator that represents a preorder traversal on this binary tree.
     * *
     * 
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorPreOrder();

    /**
     * Returns an iterator that represents a postorder traversal on this binary
     * tree. *
     * 
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorPostOrder();

    /**
     * Returns an iterator that represents a levelorder traversal on the binary
     * tree. *
     * 
     * @return an iterator over the elements of this binary tree
     */
    public Iterator<T> iteratorLevelOrder();
}
