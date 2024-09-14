/* Author: Caitlin Coulombe, T00756521
 * Date: September 13, 2024
 * Course: COMP 2231
 * 
 * Assignment 1, Question 3: Modify the shellSort, bubbleSort, and bubbleSort2 methods from Sorting.java by adding code between each to tally the total number of comparisons made between the elements being sorted (i.e. just the compareTo() calls; ignore relational operatoes between indexes). Also tally and report the number of swaps that occur. Determine and report the total execution time of each algorithm. Comment out the outputs of each swap or pass for this final step. Execute each of these sort algorithms against the same list, recording information for the total number of comparisons and total execution time. The driver should construct lists of size 10, 100, and 1000 - both in random and already in sorted order. Use the integer wrapper class for the array type.
 * 
 * Use a spreadsheet to present the test cases you have prepared, along with the comparisons, swaps, and execution time. Describe how the data obtained relates to the theoretical discussion of algorithm efficiency presented in the chapter.
 * 
 * Hint: use Arrays.copyOf() to test each sort method on the exact same data content in separate arrays
 * 
 * 
 */

import java.util.Random;
 import java.util.Arrays;

public class ComparisonDriver {
    public static void main(String[] args) throws Exception {
        // create three data sets
            // random sets of 10, 100, 1000
            // ordered sets of 10, 100, 1000

        // Objects
        Integer[] random1 = new Integer[10];
        Integer[] random2 = new Integer[100];
        Integer[] random3 = new Integer[1000];

        Integer[] ordered1 = new Integer[10];
        Integer[] ordered2 = new Integer[100];
        Integer[] ordered3 = new Integer[1000];

        Random rand = new Random();

        // fill the two other arrays with random integers

        // initialze ordered arrays
        for(int i = 0; i < 10; i++)
        {
            ordered1[i] = i;
        }
        for(int i = 0; i < 100; i++)
        {
            ordered2[i] = i;
        }
        for(int i = 0; i < 1000; i++)
        {
            ordered3[i] = i;
        }

        // initialize random arrays
        for(int i = 0; i < 10; i++)
        {
            random1[i] = rand.nextInt(100);;
        }
        for(int i = 0; i < 100; i++)
        {
            random2[i] = rand.nextInt(100);;
        }
        for(int i = 0; i < 1000; i++)
        {
            random3[i] = rand.nextInt(100);;
        }


        // shell sort
            // ordered
        System.out.println("\nShell sort, ordered 10\n");
        SortingMod.shellSort(Arrays.copyOf(ordered1, ordered1.length));
        System.out.println("\nShell sort, ordered 100\n");
        SortingMod.shellSort(Arrays.copyOf(ordered2, ordered2.length));
        System.out.println("\nShell sort, ordered 1000\n");
        SortingMod.shellSort(Arrays.copyOf(ordered3, ordered3.length));
            // random
        System.out.println("\nShell sort, random 10\n");
        SortingMod.shellSort(Arrays.copyOf(random1, random1.length));
        System.out.println("\nShell sort, random 100\n");
        SortingMod.shellSort(Arrays.copyOf(random2, random2.length));
        System.out.println("\nShell sort, random 1000\n");
        SortingMod.shellSort(Arrays.copyOf(random3, random3.length));

        // bubbleSort
            // ordered
        System.out.println("\nBubble sort, ordered 10\n");
        SortingMod.bubbleSort(Arrays.copyOf(ordered1, ordered1.length));
        System.out.println("\nBubble sort, ordered 100\n");
        SortingMod.bubbleSort(Arrays.copyOf(ordered2, ordered2.length));
        System.out.println("\nBubble sort, ordered 1000\n");
        SortingMod.bubbleSort(Arrays.copyOf(ordered3, ordered3.length));
            // random
        System.out.println("\nBubble sort, random 10\n");
        SortingMod.bubbleSort(Arrays.copyOf(random1, random1.length));
        System.out.println("\nBubble sort, random 100\n");
        SortingMod.bubbleSort(Arrays.copyOf(random2, random2.length));
        System.out.println("\nBubble sort, random 1000\n");
        SortingMod.bubbleSort(Arrays.copyOf(random3, random3.length));
        
        // bubbleSort2
            // ordered
        System.out.println("\nBubble sort 2, ordered 10\n");
        SortingMod.bubbleSort2(Arrays.copyOf(ordered1, ordered1.length));
        System.out.println("\nBubble sort 2, ordered 100\n");
        SortingMod.bubbleSort2(Arrays.copyOf(ordered2, ordered2.length));
        System.out.println("\nBubble sort 2, ordered 1000\n");
        SortingMod.bubbleSort2(Arrays.copyOf(ordered3, ordered3.length));
            // random
        System.out.println("\nBubble sort 2, random 10\n");
        SortingMod.bubbleSort2(Arrays.copyOf(random1, random1.length));
        System.out.println("\nBubble sort 2, random 100\n");
        SortingMod.bubbleSort2(Arrays.copyOf(random2, random2.length));
        System.out.println("\nBubble sort 2, random 1000\n");
        SortingMod.bubbleSort2(Arrays.copyOf(random3, random3.length));



    }
}

