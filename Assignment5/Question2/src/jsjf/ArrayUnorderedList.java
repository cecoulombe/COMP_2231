/* Author: Caitlin Coulombe, T00756521
 * Date: November 19, 2024
 * Course: COMP 2131
 * 
 * Used as part of assignment 5
 */

 package jsjf;

import jsjf.exceptions.*;

/**
 * ArrayUnorderedList represents an unordered list using an array.
 * This class extends the ArrayList class to inherit its basic list behaviors.
 *
 * @param <T> the type of elements stored in this list
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayUnorderedList() {
        super();
    }

    /**
     * Creates an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial size of the array list
     */
    public ArrayUnorderedList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Adds the specified element to the rear of this list, expanding
     * the list capacity if necessary.
     *
     * @param element the element to be added to the rear of this list
     */
    public void addToRear(T element) {
        if (rear == list.length) {
            expandCapacity();
        }
        list[rear] = element;
        rear++;
        modCount++;
    }

    @Override
    public void addToFront(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToFront'");
    }

    @Override
    public void addAfter(T element, T target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAfter'");
    }
}