/* Author: Caitlin Coulombe, T00756521
 * Date: September 28, 2024
 * Course: COMP 2231
 * 
 * Assignment 1, Question 2: There is a data structure called a drop-out stack that behaves like a stack in every aspect except that the size is fixed. If the stack size 
 * is n, the bottom element is lost when the n+1 element is pushed onto the top. Implement a drop-out stack using links by modifying the LinkedStack code that you 
 * completed as part of lab 3.
 * The driver should create a stack of moderate size (i.e. 5) and push on that many String elements consisting of people's names (includng yor own). Output the contents 
 * of the stack and the results of size() and peek() operations. Push two more elements onto the stack, outputting the contents and the result of the size() and peek() 
 * operations for each.
 * 
 */

public class DropOutStackDriver {
    private static int STACK_SIZE = 5;

    public static void main(String[] args) throws Exception {
        // create the stack objects
        LinkedStack<String> stack = new LinkedStack<String>(STACK_SIZE);

        // fill the stack
        stack.push("Greg");
        stack.push("Ang");
        stack.push("Caitlin");
        stack.push("Emily");
        stack.push("Jessica");

        // output the contents of the stack
        System.out.print(stack.toString());

        // output the results of size and peek
        // size
        System.out.println("The size of the stack is: " + stack.size());

        // peek
        System.out.println("The element on the top of the stack is: " + stack.peek());
        System.out.println();

        // add two more elements
        stack.push("Matt");
        stack.push("Oguzhan");

        // output the contents of the updated stack
        System.out.print(stack.toString());

        // output the updated results of size and peek
        // size
        System.out.println("The size of the stack is: " + stack.size());

        // peek
        System.out.println("The element on the top of the stack is: " + stack.peek());

    }
}
