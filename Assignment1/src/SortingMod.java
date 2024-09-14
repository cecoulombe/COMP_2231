/* Author: Caitlin Coulombe, T00756521
 * Date: September 10, 2024
 * Course: COMP 2231
 * Assignment 1, Question 3: Modified the sorting class so that it returns the timing, number of compareTo, and number of swaps
 */

 import java.util.Arrays;

public class SortingMod {
    //-----------------------------------------------------------------------------------------------------------------------
    // shellSort() implements the pseudocode algorithm given in the assignment to sort the list using a Shell sort.
    //-----------------------------------------------------------------------------------------------------------------------
    public static <T extends Comparable<T>> void shellSort(T[] data)
    {
        // set up timing
        long startTime = System.nanoTime();

        // variables
        int size = data.length;
        int gap = size / 2;
        int diff;

        boolean swapflag;
        int swapCount = 0;
        int compareToCount = 0;

        // print the initial array
        // System.out.println("Initial array: " + Arrays.toString(data));

        // iterate through the array comparing and swapping values
        do
        {
            swapflag = true;
            do
            {
                swapflag = false;
                diff = size - gap;
                for(int s = 0; s < diff; s++)
                {
                    compareToCount++;
                    if(data[s].compareTo(data[s + gap]) > 0)
                    {
                        swap(data, s, s + gap);
                        swapCount++;
                        // System.out.println("Swap number " + swapCount + ": " + Arrays.toString(data));
                        swapflag = true;
                    }
                }
            } while(swapflag);

            gap = gap / 2;

        } while (gap > 0);

        long endTime = System.nanoTime();

        double duration = (endTime - startTime)/1000000.0;

        System.out.println("compareTo count: " + compareToCount + "\nSwap count: " + swapCount + "\nMethod duration: " + duration + "ms\n");    
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // bubbleSort() copied directly from chapter 18 of the textbook (page 667 and 668))
    // modifications include: adding the variable compareToCount, swapCount, and the println after the swap
    //-----------------------------------------------------------------------------------------------------------------------
    public static <T extends Comparable<T>> void bubbleSort(T[] data)
    {
        // set up timing
        long startTime = System.nanoTime();

        int position, scan, swapCount = 0;
        T temp;
        int compareToCount = 0;

        for(position = data.length - 1; position >= 0; position--)
        {
            for(scan = 0; scan <= position - 1; scan++)
            {
                compareToCount++;
                if(data[scan].compareTo(data[scan+1]) > 0)
                {
                    swap(data, scan, scan + 1);
                    swapCount++;
                    // System.out.println("Swap number " + swapCount + ": " + Arrays.toString(data));
                }
            }
        }

        long endTime = System.nanoTime();
        double duration = (endTime - startTime)/1000000.0;

        System.out.println("compareTo count: " + compareToCount + "\nSwap count: " + swapCount + "\nMethod duration: " + duration + "ms\n");    
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // bubbleSort2() modified bubble sort so that it recognizes when the list is already sorted
    //-----------------------------------------------------------------------------------------------------------------------
    public static <T extends Comparable<T>> void bubbleSort2(T[] data)
    {   
        // set up timing
        long startTime = System.nanoTime();

        int scan, swapCount = 0;
        boolean swapFlag = true;
        int compareToCount = 0;

        while(swapFlag)
        {
            swapFlag = false;
            for(scan = 0; scan <= data.length - 2; scan++)
            {
                compareToCount++;
                if(data[scan].compareTo(data[scan+1]) > 0)
                {
                    swapFlag = true;
                    swap(data, scan, scan + 1);
                    swapCount++;
                    // System.out.println("Swap number " + swapCount + ": " + Arrays.toString(data));
                }
            }
        }
        long endTime = System.nanoTime();

        double duration = (endTime - startTime)/1000000.0;

        System.out.println("compareTo count: " + compareToCount + "\nSwap count: " + swapCount + "\nMethod duration: " + duration + "ms\n");    
    }


    //-----------------------------------------------------------------------------------------------------------------------
    // based on the swap method from Chapter 18 in the textbook (page 664)
    // swap() will swap the elements in an array.
    //-----------------------------------------------------------------------------------------------------------------------
    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2)
    {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
