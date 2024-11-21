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

public class BuiltHeapSort<T extends Comparable<T>> {
    // basically mimicking the function of a heap but using only array indices and the principles of an array
    // working through each of the non-leaf elements (starting at the last non-leaf), use the heapify method to ensure that the parent is larger than the children or swap as needed
    // work all the way through until to more changes are made, in which case the array is basically a heap
    // now swap the elements within the array so that it is arranged numerically (i.e. the root will be the largest, so make it the last element) (prob similar to the original heapsort)


    //------------------------------------------------------------------------------------------
    // heapSort() sorts the data within the array according to max-heap rules
    //------------------------------------------------------------------------------------------
    public void heapSort(T[] data)
    {
        // variables
        int n = data.length;

        //  build the "heap"
        buildHeap(data);

        // reorder the elements so that it is sorted smallest to largest
        for(int i = n - 1; i > 0; i--)
        {
            // swap the largest number (the root) with the last element 
            T temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            // heapify to reorder the smaller tree
            heapify(data, i , 0);

        }
        
    }

    //------------------------------------------------------------------------------------------
    // buildHeap() starting from the last non-leaf node, heapify the array in reverse order
    //------------------------------------------------------------------------------------------
    private void buildHeap(T[] data)
    {
        // variables
        int n = data.length;

        // start from the last non-leaf node (n / 2 - 1) and heapify all nodes
        for(int i = n / 2 - 1; i >= 0 ; i--)
        {
            heapify(data, n, i);
        }
        
    }

    //------------------------------------------------------------------------------------------
    // heapify() ensures that a given subtree conforms to the principles of a maxiheap
    //------------------------------------------------------------------------------------------
    private void heapify(T[] data, int len, int i)
    {
        // set the largest, left child, and right child
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // compare largest and left child, swap if needed
        if(left < len && data[left].compareTo(data[largest]) > 0)
        {
            largest = left;
        }

        // compare largest and right child, swap if needed
        if(right < len && data[right].compareTo(data[largest]) > 0)
        {
            largest = right;
        }

        // if largest changed (!= i), then the heap changed and you need to reflect this in the array
        if(largest != i)
        {
            T temp = data[i];
            data[i] = data[largest];
            data[largest] = temp;

            // recursively heapify the affected subtree
            heapify(data, len, largest);
        }

    }
}
