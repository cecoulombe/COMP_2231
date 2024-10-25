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



public class ALStack_Driver {
    public static void main(String[] args) {
        // variables
        ArrayList_Stack<Integer> stack = new ArrayList_Stack<>();

        System.out.println("\n *** Current Implementation: A stack using ArrayList ***\n");

       // isEmpty
       System.out.println("List is empty? " + stack.isEmpty() + "\n");

       // peek at empty list
       try {
           System.out.println("The top element of the stack is (peek): " + stack.peek() + "\n");
       } catch (RuntimeException e) {
           System.out.println("Tried to peek at the top element of an empty stack\n");
       }

       // pop from empty list
       try {
           System.out.println("The popped element of the stack is (pop): " + stack.pop() + "\n");
       } catch (RuntimeException e) {
           System.out.println("Tried to pop the top element of an empty stack\n");
       }

       // add 5 elements to the list
       System.out.println("Pushing elements 0, 1, 2, 3, 4 onto the stack.\n");
       for(int i = 0; i < 5; i++)
       {
           stack.push(i);
       }

       // isEmpty
       System.out.println("List is empty? " + stack.isEmpty() + "\n");

       // size
       System.out.println("The size of the list is: " + stack.size() + "\n");

       // toString
       System.out.println("Printing the stack\n" + stack + "\n");
       
       // peek at list
       try {
           System.out.println("The top element of the stack is (peek): " + stack.peek() + "\n");
       } catch (RuntimeException e) {
           System.out.println("Tried to peek at the top element of an empty stack\n");
       }

       // pop from list
       try {
           System.out.println("The popped element of the stack is (pop): " + stack.pop() + "\n");
       } catch (RuntimeException e) {
           System.out.println("Tried to pop the top element of an empty stack\n");
       }

    
       // isEmpty
       System.out.println("List is empty? " + stack.isEmpty() + "\n");

       // size
       System.out.println("The size of the list is: " + stack.size() + "\n");

       // toString
       System.out.println("Printing the stack\n" + stack);
    }
}