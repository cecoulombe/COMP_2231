/* Author: Caitlin Coulombe, T00756521
 * Date: September 10, 2024
 * Course: COMP 2231
 * 
 * Assignment 1, Question 1: The Shell sort is a variation of the bubble/exchange sort. Instead of comparing adjacent values, 
 * the Shell sort adapts the partitioning concept from the binary search to determine a "gap" across 
 * which values are compared before any swap takes place. In the first pass, the gap is half the 
 * size of the array. For each subsequent pass, the gap size is cut in half. For the final pass(es), 
 * the gap size is 1m so it would be the same as a bubble sort. The passes continue until no swaps 
 * occur.
 * 
 * Assignment: modify Sorting.java to include a shellSort method that implements the above algorithm. 
 * Include an output of the array any time a swap occurs to demonstrate that your code works correctly. 
 * For the driver, create an integer array using an initializer list to reprocude the above example 
 * and two additional random sets of 10 and 20 integers
 * 
 */

 import java.util.Random;

public class ShellSortDriver {
    public static void main(String[] args) throws Exception {
        // create three data sets
            // the one from the textbook bubble sort
            // random set of 10
            // random set of 20

    // Objects
    Integer[] data1 = {9, 6, 8, 12, 3, 1, 7};
    Integer[] data2 = new Integer[10];
    Integer[] data3 = new Integer[20];

    Random rand = new Random();

    // fill the two other arrays with random integers

    for(int i = 0; i < 10; i++)
    {
        data2[i] = rand.nextInt(1000);
    }

    for(int i = 0; i < 20; i++)
    {
        data3[i] = rand.nextInt(1000);
    }


    Sorting.shellSort(data1);
    System.out.println("\n\n");
    Sorting.shellSort(data2);
    System.out.println("\n\n");
    Sorting.shellSort(data3);
    }
}
