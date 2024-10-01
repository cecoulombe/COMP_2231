/* Author: Caitlin Coulombe, T00756521
 * Date: September 28, 2024
 * Course: COMP 2231
 * 
 * Assignment 2, Question 3: A double-ended queue, or deque is introduced in section 14.8. 
 * With a deque you can add, remove, or view elements from both ends of the queue. Rather 
 * than use the Deque interface supplied by the Java API, design your own DequeADT 
 * interface, patterend after QueueADT. Then, implement a deque using links.
 * 
 * Hint: Start with the LinkedQueue code that you completed as a part of Lab 4. Also, each 
 * node will need both a next and a previous reference.
 * 
 * The driver should create a deque of moderate size (5 or 6). It should repetitively add 
 * elements to the front, and then the rear. For each addition, output the contents of the 
 * deque as well as the size, front element, and the last element. Then, repetitively 
 * remove elements from the deque. For each removal, output the contents of the deque as 
 * well as the size, front element, and last element.
 * 
 */


public class DequeDriver {
    public static void main(String[] args) throws Exception {
        // variables
        LinkedQueue<Integer> deque = new LinkedQueue<Integer>();

        System.out.println("Adding elements to the queue.\nFirst three to the front, then three to the back.\n");
        // add 5-6 elements to the list. Add 3 from the front and 3 from the back
            // add elements 1, 2, 3, 4, 5, 6 in numerical order. Should result in 321654
        deque.enqueueFront(1);
        System.out.println(outputs(deque));
        deque.enqueueFront(2);
        System.out.println(outputs(deque));
        deque.enqueueFront(3);
        System.out.println(outputs(deque));
        deque.enqueueBack(4);
        System.out.println(outputs(deque));
        deque.enqueueBack(5);
        System.out.println(outputs(deque));
        deque.enqueueBack(6);
        System.out.println(outputs(deque));

        System.out.println("Removing elements from the queue.\nFirst two from the front, then two from the back, then two from the front.\n");
        // remove elements from the list, two from front, two, from back, and the last two from the front.
        deque.dequeueFront();
        System.out.println(outputs(deque));
        deque.dequeueFront();
        System.out.println(outputs(deque));
        deque.dequeueBack();
        System.out.println(outputs(deque));
        deque.dequeueBack();
        System.out.println(outputs(deque));
        deque.dequeueFront();
        System.out.println(outputs(deque));
        deque.dequeueFront();
        System.out.println(outputs(deque));
    }

    //---------------------------------------------------------------------------------------------
    // outputs(): collects and formats a string message with all required outputs for the assignment
        // Outputs include: the contents of the string, size, front element, and last element
    //---------------------------------------------------------------------------------------------
    private static String outputs(LinkedQueue<Integer> deque) {
        String msg = "";

        try {
            msg += "The current queue is: \n" + deque.toString();
            msg += "Size = " + deque.size() + "\n";
            msg += "First element = " + deque.first() + "\n";
            msg += "Last element = " + deque.last() + "\n";
        } catch (Exception e) {
            msg = "The queue is empty!";
        }

        return msg;
    }
}
