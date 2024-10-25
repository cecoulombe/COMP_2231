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

public class LLQueue_Driver {
    public static void main(String[] args) {
        // variables
        LinkedList_Queue<Integer> queue = new LinkedList_Queue<>();

        System.out.println("\n *** Current Implementation: A queue using LinkedList ***\n");

        // isEmpty
        System.out.println("List is empty? " + queue.isEmpty() + "\n");

        // first at empty list
        try {
            System.out.println("The first element of the queue is (first): " + queue.first() + "\n");
        } catch (RuntimeException e) {
            System.out.println("Tried to look at the first element of an empty queue\n");
        }

        // dequeue from empty list
        try {
            System.out.println("The dequeue element of the queue is (dequeue): " + queue.dequeue() + "\n");
        } catch (RuntimeException e) {
            System.out.println("Tried to dequeue the top element of an empty queue\n");
        }

        // add 5 elements to the list
        System.out.println("Enqueue-ing elements 0, 1, 2, 3, 4 onto the queue.\n");
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }

        // isEmpty
        System.out.println("List is empty? " + queue.isEmpty() + "\n");

        // size
        System.out.println("The size of the list is: " + queue.size() + "\n");

        // toString
        System.out.println("Printing the queue\n" + queue + "\n");

        // first at list
        try {
            System.out.println("The first element of the queue is (first): " + queue.first() + "\n");
        } catch (RuntimeException e) {
            System.out.println("Tried to look at the first element of an empty queue\n");
        }

        // dequeue from list
        try {
            System.out.println("The dequeue element of the queue is (dequeue): " + queue.dequeue() + "\n");
        } catch (RuntimeException e) {
            System.out.println("Tried to dequeue the top element of an empty queue\n");
        }

        // isEmpty
        System.out.println("List is empty? " + queue.isEmpty() + "\n");

        // size
        System.out.println("The size of the list is: " + queue.size() + "\n");

        // toString
        System.out.println("Printing the queue\n" + queue);
    }
}
