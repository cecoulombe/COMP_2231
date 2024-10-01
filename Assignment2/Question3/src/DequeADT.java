/* Author: Caitlin Coulombe, T00756521
 * Date: September 28, 2024
 * Course: COMP 2231
 * 
 * Assignment 2, Question 3: See the DequeDriver for assignment details.
 * 
 * Rather than use the Deque interface supplied by the Java API, design 
 * your own DequeADT interface, patterend after QueueADT.
 * 
 * Based on Java Foundations' StackADT class.
 * 
 */

public interface DequeADT<T> {

    //---------------------------------------------------------------------------------------------
    // enqueueFront(element): Adds the specified element to the front of the queue
    //---------------------------------------------------------------------------------------------
    public void enqueueFront(T element);

    //---------------------------------------------------------------------------------------------
    // enqueueBack(element): Adds the specified element to the back of the queue
    //---------------------------------------------------------------------------------------------
    public void enqueueBack(T element);

    //---------------------------------------------------------------------------------------------
    // dequeueFront(): Removes and returns the element at the front of the queue
    //---------------------------------------------------------------------------------------------
    public T dequeueFront();

    //---------------------------------------------------------------------------------------------
    // dequeueBack(): Removes and returns the element at the back of the queue
    //---------------------------------------------------------------------------------------------
    public T dequeueBack();


    //---------------------------------------------------------------------------------------------
    // first(): Returns the element at the front of the queue without looking at it
    //---------------------------------------------------------------------------------------------
    public T first();

    //---------------------------------------------------------------------------------------------
    // last(): Returns the element at the back of the queue without looking at it
    //---------------------------------------------------------------------------------------------
    public T last();

    //---------------------------------------------------------------------------------------------
    // toEmpty(): Returns true if the queue is empty
    //---------------------------------------------------------------------------------------------
    public boolean isEmpty();
    
    //---------------------------------------------------------------------------------------------
    // size(): Returns the number of elements in the queue
    //---------------------------------------------------------------------------------------------
    public int size();

    //---------------------------------------------------------------------------------------------
    // toString(): Returns elements of the queue in a string
    //---------------------------------------------------------------------------------------------
    public String toString();
}
