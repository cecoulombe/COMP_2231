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
 * ListADT defines the interface to a general list collection. Specific
 * types of lists will extend this interface to complete the
 * set of necessary operations.
 *
 * * @author Java Foundations
 * 
 * @version 4.0
 */
public interface ListADT<T> extends Iterable<T> {
    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     */
    public T removeFirst();

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     */
    public T removeLast();

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     */
    public T remove(T element);

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     */
    public T first();

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     */
    public T last();

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    public boolean contains(T target);

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    public int size();

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    public Iterator<T> iterator();

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    public String toString();
}