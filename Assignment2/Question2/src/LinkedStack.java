/* Author: Caitlin Coulombe, T00756521
 * Date: September 28, 2024
 * Course: COMP 2231
 * 
 * Lab 3: Complete the implementation of LinkedStack<T> class by providing the definitions for the peek, size, isEmpty, and toString methods.
 *  * Verify implementation against the solution in Moodle.
 * 
 * Assignment 2, Question 2: Modify the implementation so that it acts as a drop out stack.
 * 
 * ***This version of the array is modified to include isEmpty, size, and toString as well as println to compare better to the modified array.***
 * 
 */

 // Modified version of Java Foundations, v4.0 class ArrayStack. 

public class LinkedStack<T> implements StackADT<T> {
    
    private int count;
    private LinearNode<T> top;
    private int maxCapacity;

    //---------------------------------------------------------------------------------------------
    // LinkedStack() creates an empty stack of a specific size
    // modifications: added a specific size for the stack
    //---------------------------------------------------------------------------------------------
    public LinkedStack(int capacity)
    {
        count = 0;
        top = null;
        this.maxCapacity = capacity;
    }

    //---------------------------------------------------------------------------------------------
    // push(element) adds the specified element to the top of the stack
    //---------------------------------------------------------------------------------------------
    public void push(T element)
    {
        if(count >= maxCapacity)
        {
            // remove the bottom element first
            LinearNode<T> current = top;

            while(current.getNext().getNext() != null)
            {
                current = current.getNext();
            }
            current.setNext(null);
            count--;
        }
        LinearNode<T> temp = new LinearNode<T>(element);

        temp.setNext(top);
        top = temp;
        count++;
    }

    //---------------------------------------------------------------------------------------------
    // pop() removes the element at the top of this stack and returns a reference to it
    //---------------------------------------------------------------------------------------------
    public T pop() throws EmptyCollectionException
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException("stack");
        }

        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }
    
    //---------------------------------------------------------------------------------------------
    // peek() retruns a referenec to the element at the top of the stack
    //---------------------------------------------------------------------------------------------
    public T peek() throws EmptyCollectionException
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException("stack");
        }

        T result = top.getElement();
        return result;
    }

    //---------------------------------------------------------------------------------------------
    // isEmpty() returns true is the stack is empty
    //---------------------------------------------------------------------------------------------
    public boolean isEmpty()
    {
        return (count == 0);
    }

    //---------------------------------------------------------------------------------------------
    // size() returns the number of elements in the stack
    //---------------------------------------------------------------------------------------------
    public int size()
    {
        return count;
    }

    //---------------------------------------------------------------------------------------------
    // toString() prints the linked list
    //---------------------------------------------------------------------------------------------
    public String toString()
    {
        String result = "";
        LinearNode<T> current = top;

        while(current != null)
        {
            result = result + current.getElement() + "\n";
            current = current.getNext();
        }

        return result;
    }
}
