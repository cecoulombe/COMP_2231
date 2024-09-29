/* Author: Caitlin Coulombe, T00756521
 * Date: September 28, 2024
 * Course: COMP 2231
 * 
 * Assignment 1, Question 1: The ArrayStack implementation in Chapter 12 uses the top variable to point to the 
 * next array position available in the stack (i.e. above the actual top of the stack). Modify the implementation 
 * such that stack[top] is the actual top of the stack. Do not introduce any other counter variables. Make sure 
 * your driver demonstates any method that you modify.
 * 
 * Hint: start with the ArrayStack code that you completed as part of Lab3. Consider starting top at a value other
 * than 0 and altering where top may be incremented or decremented.
 * 
 */


 
public class ArrayStackDriver {
    private static int STACK_SIZE = 5;
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) throws Exception {
        // variables
        System.out.println("New ArrayStack");
        ArrayStack stack = new ArrayStack(STACK_SIZE);
        
        System.out.println();
        System.out.println("New ModifiedArrayStack");
        ModifiedArrayStack mStack = new ModifiedArrayStack(STACK_SIZE);

        // process and print results for ArrayStack, then for ModifiedArrayStack
            // push elements and push beyond the current capacity of the array
        System.out.println("Filling ArrayStack");
        for(int i = 0; i <= STACK_SIZE; i++)
        {
            stack.push(i);
        }
        
        System.out.println();
        System.out.println("Filling ModifiedArrayStack");
        for(int i = 0; i <= STACK_SIZE; i++)
        {
            mStack.push(i);
        }
            // pop elements
        System.out.println();
        System.out.println("Pop from ArrayStack");
        stack.pop();

        System.out.println();
        System.out.println("Pop from ModifiedArrayStack");
        mStack.pop();
        
            // peek at an element
        System.out.println();
        System.out.println("Pop from ArrayStack");
        stack.peek();

        System.out.println();
        System.out.println("Pop from ModifiedArrayStack");
        mStack.peek();
        
            // check if the stack is empty
        System.out.println();
        System.out.println("Peek at ArrayStack");
        stack.isEmpty();
    
        System.out.println();
        System.out.println("Peek at ModifiedArrayStack");
        mStack.isEmpty();

            // check the size of the stack
        System.out.println();
        System.out.println("Size of ArrayStack");
        stack.size();

        System.out.println();
        System.out.println("Size of ModifiedArrayStack");
        mStack.size();

            // print the stack
        System.out.println();
        System.out.println("toString of ArrayStack");
        System.out.println(stack.toString());
        
        System.out.println();
        System.out.println("toString of ModifiedArrayStack");
        System.out.println(mStack.toString());
    }
}
