/* Author: Caitlin Coulombe, T00756521
 * Date: September 28, 2024
 * Course: COMP 2231
 * 
 * Lab 3: Complete the implementation of the ArrayStack class presented in Chapter 12. Specifically, complete 
 * the implementations of isEmpty, size, and toString methods.
 *  * Verify implementation against the solution in Moodle.
 * 
 * Assignment 2, Question 1: Modify the implementation so that the top variable points to the actual top element 
 * in the array. See the driver for more details
 * 
 * *** this version is modified to change top to point to the top-most element.
 */

 import java.util.Arrays;

 // Modified version of Java Foundations, v4.0 class ArrayStack. 

public class ModifiedArrayStack<T> implements StackADT<T>{
    private final static int DEFAULT_CAPACITY = 100;
    private int top;
    private T[] stack;

    //---------------------------------------------------------------------------------------------
    // ArrayStack() constructor which creates a stack with the default capacity
    //---------------------------------------------------------------------------------------------
    public ModifiedArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    //---------------------------------------------------------------------------------------------
    // ArrayStack(int initialCapacity) creates an empty stack using the specified capacitry.
    // modifications: sets top = -1 rather than top = 0. Allows the first element added to be at index 0
    //---------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    public ModifiedArrayStack(int initialCapacity)
    {
        top = -1;
        stack = (T[]) (new Object[initialCapacity]);
        System.out.println("Created a stack with an initial capacity of " + initialCapacity + ". Top is: " + top);
    }
    
    //---------------------------------------------------------------------------------------------
    // push(T element) adds the specified element to the top of the stack, expanding the capacity of the array if necessary
    // modifications: increments top before adding the new element
    //---------------------------------------------------------------------------------------------
    public void push(T element)
    {
        System.out.println("Attempting to add a new element.");
        if(size() == stack.length)
        {
            expandCapacity();
        }
        top++;
        stack[top] = element;
        System.out.println("Added " + element + " to the stack. The variable top is " + top);
    }

    //---------------------------------------------------------------------------------------------
    // expandCapacity() creates a new array to store the conents of this stack with twice the capacity of the old one
    //---------------------------------------------------------------------------------------------
    public void expandCapacity()
    {
        stack = Arrays.copyOf(stack, stack.length * 2);
        System.out.println("Expanded the capacity of the array.");
    }

    //---------------------------------------------------------------------------------------------
    // pop() renmoves the element at the top of this stack and returns a reference to it
    // modifications: decrements top after getting the result and setting it to null
    //---------------------------------------------------------------------------------------------
    public T pop() throws EmptyCollectionException
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException("stack");
        }

        T result = stack[top];
        stack[top] = null;
        top--;
        System.out.println("Popped the top element of the array: " + result + ". The variable top is " + top);
        return result;
    }

    //---------------------------------------------------------------------------------------------
    // peek() returns a reference to the element at the top of this stack. The element is not removed from the stack
    // modifications: peeks at the value in stack[top] rather than stack[top - 1]
    //---------------------------------------------------------------------------------------------
    public T peek() throws EmptyCollectionException
    {
        if(isEmpty())
        {
            throw new EmptyCollectionException("stack");
        }

        T result = stack[top];
        System.out.println("Peeking at the value in position top = " + top + ": " + result + ".");
        return result;
    }

    //---------------------------------------------------------------------------------------------
    // isEmpty() returns true is the stack is empty
    // modifications: checks if top = -1 instead of 0
    //---------------------------------------------------------------------------------------------
    public boolean isEmpty()
    {
        System.out.println("Comparing top = " + top + " to -1 to determine if the array is empty.");
        if(top == -1)
        {
            return true;
        }
        return false;
    }

    //---------------------------------------------------------------------------------------------
    // size() returns the number of elements in the stack
    // modifications: returning top + 1 instead of top
    //---------------------------------------------------------------------------------------------
    public int size()
    {
        System.out.println("Returning the number of elements in the array = top + 1 = " + (top+1) + ".");
        return top+1;
    }

    //---------------------------------------------------------------------------------------------
    // toString() returns a string representation of the stack
    // modifications: scan <= top rather than scan < top
    //---------------------------------------------------------------------------------------------
    public String toString()
    {
        String message = "";
        
        for(int scan = 0; scan <= top; scan++)
        {
            message += stack[scan] + "\n";
        }

        System.out.println("toString for the array: \nTop = " + top);
        return message;
    }
}
