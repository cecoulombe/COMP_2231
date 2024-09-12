/* Author: Caitlin Coulombe, T00756521
 * Date: September 10, 2024
 * Course: COMP 2231
 * Assignment 1: See the drivers for more information about the specific questions.
 */

 import java.util.Arrays;

public class Sorting {
    //-----------------------------------------------------------------------------------------------------------------------
    // shellSort() implements the pseudocode algorithm given in the assignment to sort the list using a Shell sort.
    //-----------------------------------------------------------------------------------------------------------------------
    public static <T extends Comparable<T>> void shellSort(T[] data)
    {
        // pseudocode in the assignment
        // set up the method so that it prints the array any time a swap occurs to ensure its working as intended

        // gap = size / 2
        // do until gap <= 0
            // swapflag = true
            // do until swapflag is false
                // swapflag = false
                // for s = 0 to size - gap
                    // if num[s] > num[s + gap]
                        // swap num[s] with num[s + gap]
                        // swapflag = true
                    // end if
                // end for
            // end do
            // gap = gap / 2
        // end do

        // variables
        int size = data.length;
        int gap = size / 2;
        int diff;

        boolean swapflag;
        int swapCount = 0;

        // print the initial array
        System.out.println("Initial array: " + Arrays.toString(data));

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
                    if(data[s].compareTo(data[s + gap]) > 0)
                    {
                        swap(data, s, s + gap);
                        swapCount++;
                        System.out.println("Swap number " + swapCount + ": " + Arrays.toString(data));
                        swapflag = true;
                    }
                }
            } while(swapflag);

            gap = gap / 2;

        } while (gap > 0);
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
