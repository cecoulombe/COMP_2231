/* Author: Caitlin Coulombe, T00756521
 * Date: September 28, 2024
 * Course: COMP 2231
 * 
 * Assignment 2, Question 3: See the DequeDriver for assignment details.
 * 
 * From lab4: Complete the implementation of the LinkedQueue class presented in Chapter 14. Specifically, complete
 * the implementations of the first, isEmpty, size, and toString methods.
 * 
 */


public class LinkedQueue<T> implements DequeADT<T> {
    // class variables
    private int count;
    private LinearNode<T> head, tail;
   
    //---------------------------------------------------------------------------------------------
    // Creates an empty queue
    //---------------------------------------------------------------------------------------------
    public LinkedQueue(){
        count = 0;
        head = tail = null;
    }

    //---------------------------------------------------------------------------------------------
    // enqueueFront(element): Adds the specified element to the front of the queue
    //---------------------------------------------------------------------------------------------
    public void enqueueFront(T element){
        LinearNode<T> node = new LinearNode<T>(element);

        if(isEmpty())
        {
            tail = node;
        }
        else
        {
            head.setPrev(node);
        }
        head = node;
        count++;
    }

    //---------------------------------------------------------------------------------------------
    // enqueueBack(element): Adds the specified element to the back of the queue
    //---------------------------------------------------------------------------------------------
    public void enqueueBack(T element){
        LinearNode<T> node = new LinearNode<T>(element);

        if(isEmpty())
        {
            head = node;
        }
        else
        {
            tail.setNext(node);
        }
        tail = node;
        count++;
    }

    //---------------------------------------------------------------------------------------------
    // dequeueFront(): Removes and returns the element at the front of the queue
    //---------------------------------------------------------------------------------------------
    public T dequeueFront(){
        if(isEmpty())
        {
            throw new EmptyCollectionException("queue");
        }

        T result = head.getElement();
        if(head == tail)    // handle the case of a single element
        {
            head = tail = null;
        }
        else
        {
            head = head.getNext();
            head.setPrev(null);
        }
        count--;
        // head = head.getNext();
        // count--;


        // if(isEmpty())
        // {
        //     tail = null;
        // }

        return result;
    }

    //---------------------------------------------------------------------------------------------
    // dequeueBack(): Removes and returns the element at the back of the queue
    //---------------------------------------------------------------------------------------------
    public T dequeueBack(){
        if(isEmpty())
        {
            throw new EmptyCollectionException("queue");
        }

        T result = tail.getElement();
        if(head == tail)    // handle the case of a single element
        {
            head = tail = null;
        }
        else
        {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        count--;
        // T result = tail.getElement();
        // tail = tail.getPrev();
        // count--;

        // if(isEmpty())
        // {
        //     head = null;
        // }

        return result;
    }


    //---------------------------------------------------------------------------------------------
    // first(): Returns the element at the front of the queue without looking at it
    //---------------------------------------------------------------------------------------------
    public T first(){
        if(isEmpty())
        {
            throw new EmptyCollectionException("queue");
        }

        return head.getElement();
    }

    //---------------------------------------------------------------------------------------------
    // last(): Returns the element at the back of the queue without looking at it
    //---------------------------------------------------------------------------------------------
    public T last(){
        if(isEmpty())
        {
            throw new EmptyCollectionException("queue");
        }

        return tail.getElement();
    }

    //---------------------------------------------------------------------------------------------
    // toEmpty(): Returns true if the queue is empty
    //---------------------------------------------------------------------------------------------
    public boolean isEmpty(){
        return (count == 0);
    }
    
    //---------------------------------------------------------------------------------------------
    // size(): Returns the number of elements in the queue
    //---------------------------------------------------------------------------------------------
    public int size(){
        return count;
    }

    //---------------------------------------------------------------------------------------------
    // toString(): Returns elements of the queue in a string
    //---------------------------------------------------------------------------------------------
    public String toString(){
        String msg = "";
        LinearNode<T> current = head;
        while(current != null)
        {
            msg += current.getElement() + "\n";
            current = current.getNext();
        }

        return msg;
    }

}
