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

/**
 * BinarySearchTreeADT defines the interface to a binary search tree.
 *
 * @author Java Foundations
 * @version 4.0
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {
    /**
     * Adds the specified element to the proper location in this tree.
     *
     * @param element the element to be added to this tree
     */
    public void addElement(T element);

    /**
     * Removes and returns the specified element from this tree.
     *
     * @param targetElement the element to be removed from the tree
     * @return the element to be removed from the tree
     */
    public T removeElement(T targetElement);

    /**
     * Removes all occurences of the specified element from this tree.
     *
     * @param targetElement the element to be removed from the tree
     */
    public void removeAllOccurrences(T targetElement);

    /**
     * Removes and returns the smallest element from this tree.
     *
     * @return the smallest element from the tree.
     */
    public T removeMin();

    /**
     * Removes and returns the largest element from this tree.
     *
     * @return the largest element from the tree
     */
    public T removeMax();

    /**
     * Returns the smallest element in this tree without removing it.
     *
     * * @return the smallest element in the tree
     */
    public T findMin();

    /**
     * Returns the largest element in this tree without removing it.
     *
     * @return the largest element in the tree
     */
    public T findMax();
}