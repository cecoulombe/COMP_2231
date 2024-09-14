/* Author: Caitlin Coulombe, T00756521
 * Date: September 13, 2024
 * Course: COMP 2231
 * 
 * Assignment 1, Question 2: THe bubble sort algorithm shown in Chapter 18 is less efficient than it 
 * could be. If a pass is made through the list without exchanging any elementts, the list is sorted 
 * and there is no reason to continue. Creaty a copy of the bubbleSort method called bubbleSort2 that 
 * implements this algorithm so that it will stop as soon as it recognizes that the list is sorted. 
 * Do not use a break statement! Include outputs of the array for both sorts for each pass through 
 * the array so that you can demonstrate that the code is working correctly. The driver should test 
 * both methods with a random set of 10 integers and an already sorted set of 10 integers.
 * 
 * Hint: you have to introduce a swapflag that is set true if a swap occurs on a given pass. Replace 
 * the outer for loop with a while loop that tests the swap flag and takes care of the index counting 
 * within the loop
 * 
 * HintL remember that arrays are passed by reference in Java. Use Arrays.copyOf() or a similar method 
 * to test each sort method on the exact same data conent in separate arrays
 * 
 * 
 */

 import java.util.Random;
 import java.util.Arrays;

public class BubbleSortDriver {
    public static void main(String[] args) throws Exception {
        // create three data sets
            // ordered set of 10
            // random set of 10

        // Objects
        Integer[] data1 = new Integer[10];
        Integer[] data2 = new Integer[10];

        Random rand = new Random();

        // fill the two other arrays with random integers

        for(int i = 0; i < 10; i++)
        {
            data1[i] = i;
        }

        for(int i = 0; i < 10; i++)
        {
            data2[i] = rand.nextInt(100);
        }

        // use each of the sorts for each of the data
        System.out.println("Bubble sort on the pre-sorted array\n");
        Sorting.bubbleSort(Arrays.copyOf(data1,  data1.length));
        System.out.println("Bubble sort on the random array\n");
        Sorting.bubbleSort(Arrays.copyOf(data2,  data1.length));
        System.out.println("\n\nBubble sort 2 on the pre-sorted array\n");
        Sorting.bubbleSort2(Arrays.copyOf(data1,  data1.length));
        System.out.println("\n\nBubble sort 2 on the random array\n");
        Sorting.bubbleSort2(Arrays.copyOf(data2,  data1.length));

    }
}
