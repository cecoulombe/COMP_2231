/* Author: Caitlin Coulombe, T00756521
 * Date: November 18, 2024
 * Course: COMP 2231
 * Assignment 5, Question 1: As described in section 21.5 of the textbook, it is possible to make a heap sort algorithm more efficient by 
 * writing a method that will build a heap in place using the array to be sorted. Implement such a method and then rewrite the heap sort 
 * algorithm to make use of it.
 * 
 * Show test cases for various inputs, including sorted and unsorted inputs.
 * 
 */

 import java.util.Random;

 // demonstrates the funcitonality of the BuiltHeapSort class using sorted, unsorted, and reverse sorted arrays
public class HeapSortDriver {
    public static void main(String[] args)
    {
        // create an instance of the heapsort
        BuiltHeapSort<Integer> sorter = new BuiltHeapSort<>();

        // create the data sets
        // for each, print the original array, then sort, then print the sort
        Integer[] sortedData = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("sortedData prior to sorting:");
        arrayPrint(sortedData);
        System.out.println("\nsortedData after sorting:");
        sorter.heapSort(sortedData);
        arrayPrint(sortedData);
        System.out.println("\n\n");
        

        Integer[] reverseSortedData = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("reverseSortedData prior to sorting:");
        arrayPrint(reverseSortedData);
        System.out.println("\nreverseSortedData after sorting:");
        sorter.heapSort(reverseSortedData);
        arrayPrint(reverseSortedData);
        System.out.println("\n\n");
        
        
        // populate the unsorted array with random numbers
        Integer[] unsortedData = new Integer[10];
        Random rand = new Random();
        for(int i = 0; i < 10; i++)
        {
            unsortedData[i] = rand.nextInt(19) + 1;
        }
        System.out.println("unsortedData prior to sorting:");
        arrayPrint(unsortedData);
        System.out.println("\nunsortedData after sorting:");
        sorter.heapSort(unsortedData);
        arrayPrint(unsortedData);
        System.out.println("\n\n");
        

        Integer[] emptyData = {};
        System.out.println("emptyData prior to sorting:");
        arrayPrint(emptyData);
        System.out.println("\nemptyData after sorting:");
        sorter.heapSort(emptyData);
        arrayPrint(emptyData);
        System.out.println("\n\n");
        
        Integer[] singleElemData = {1};
        System.out.println("singleElemData prior to sorting:");
        arrayPrint(singleElemData);
        System.out.println("\nsingleElemData after sorting:");
        sorter.heapSort(singleElemData);
        arrayPrint(singleElemData);
        System.out.println("\n\n");
    }

    private static void arrayPrint(Integer[] data)
    {
        for (Integer num : data) {
            System.out.print(num + " ");
        }
    }
}
