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


public class ArrayList_Stack<T> implements StackADT<T>{
    // global variables
    private ArrayList<T> stack;

    //-----------------------------------------------------------------------------------------
    // Constructor for the class
    //-----------------------------------------------------------------------------------------
    public ArrayList_Stack()
    {
        stack = new ArrayList<>();
    }

    //-----------------------------------------------------------------------------------------
    // Adds the specified element to the top of this stack.
    //-----------------------------------------------------------------------------------------
    public void push(T element)
    {
        stack.add(element);
    }

    //-----------------------------------------------------------------------------------------
    // Removes and returns the top element from this stack.
    //-----------------------------------------------------------------------------------------
    public T pop()
    {
        if(isEmpty())
        {
            throw new RuntimeException("Stack is empty.");
        }
        return stack.removeLast();
    }

    //-----------------------------------------------------------------------------------------
    // Returns without removing the top element of this stack.
    //-----------------------------------------------------------------------------------------
    public T peek()
    {
        if(isEmpty())
        {
            throw new RuntimeException("Stack is empty.");
        }
        return stack.getLast();
    }

    //-----------------------------------------------------------------------------------------
    // Returns true if this stack contains no elements.
    //-----------------------------------------------------------------------------------------
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    //-----------------------------------------------------------------------------------------
    // Returns the number of elements in this stack.
    //-----------------------------------------------------------------------------------------
    public int size()
    {
        return stack.size();
    }

    //-----------------------------------------------------------------------------------------
    // Returns a string representation of this stack.
    //-----------------------------------------------------------------------------------------
    public String toString()
    {
        return stack.toString();
    }

}
