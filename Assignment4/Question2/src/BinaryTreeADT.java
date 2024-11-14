/* Author: Caitlin Coulombe, T00756521
 * Date: November 4, 2024
 * Course: COMP 2131
 * Assignment 4, Question 2: Complete all missing methods in LinkedBinarySearchTree. Show 
 * test cases for all implemented methods being sure to include edge cases for methods 
 * where applicable.
 * Then, implement a balance tree method for this class using the brute force method 
 * described in Section 20.5 of your textbook.
 * Show test cases for two different degenerate trees, outputting the height of the tree
 * before and after balancing the tree. Then, demonstrate insertions into a balanced tree 
 * that result in degenerate trees and rebalance the tree again.
 * 
 *  * Hint: Copy the elements into an ArrayList using an in-order traversal. Recursively 
 *    build a balanced tree using a binary partitioning.
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
