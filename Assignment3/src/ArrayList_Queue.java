/* Author: Caitlin Coulombe, T00756521
 * Date: October 14, 2024
 * Course: COMP 2231
 * 
 * Assignment 3: For the questions below, use the classes defined in java.util rather than the list 
 * classes developed inthe textbook. Make the container in your stack or queue class of the type 
 * indicated - do not use inheritance. You must implement the StackADT and QueueADT interfaces from 
 * the textbook. Code a separate driver for each question but use the same testing values. Make sure
 * that you demonstrate each of the methods for the respective interface.
 * 
 *  1. Implement a stack using java.util.LinkedList
 *  2. Implement a stack using java.util.ArrayList
 *  3. Implement a queue using java.util.LinkedList
 *  4. Implement a queue using java.util.ArrayList
 * 
 * Hint: many of the methods will require just a call to a corresponding method for the list being 
 * used; for example, push() would invoke a .add() method for the LinkedList or ArrayList
 * 
 */

 import java.util.ArrayList;

public class ArrayList_Queue<T> implements QueueADT<T>{
    // global variables
    private ArrayList<T> queue;

    //-----------------------------------------------------------------------------------------
    // Constructor for the class
    //-----------------------------------------------------------------------------------------
    public ArrayList_Queue()
    {
        queue = new ArrayList<>();
    }
    
    //-----------------------------------------------------------------------------------------
    // Adds one element to the rear of this queue.
    //-----------------------------------------------------------------------------------------
    public void enqueue(T element)
    {
        queue.add(element);
    }

    //-----------------------------------------------------------------------------------------
    // Removes and returns the element at the front of this queue.
    //-----------------------------------------------------------------------------------------
    public T dequeue()
    {
        if(isEmpty())
        {
            throw new RuntimeException("Stack is empty.");
        }
        return queue.removeFirst();
    }

    //-----------------------------------------------------------------------------------------
    // Returns without removing the element at the front of this queue.
    //-----------------------------------------------------------------------------------------
    public T first()
    {
        if(isEmpty())
        {
            throw new RuntimeException("Stack is empty.");
        }
        return queue.getFirst();
    }

    //-----------------------------------------------------------------------------------------
    // Returns true if this queue contains no elements.
    //-----------------------------------------------------------------------------------------
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    //-----------------------------------------------------------------------------------------
    // Returns the number of elements in this queue.
    //-----------------------------------------------------------------------------------------
    public int size()
    {
        return queue.size();
    }

    //-----------------------------------------------------------------------------------------
    // Returns a string representation of this queue.
    //-----------------------------------------------------------------------------------------
    public String toString()
    {
        return queue.toString();    
    }

}
