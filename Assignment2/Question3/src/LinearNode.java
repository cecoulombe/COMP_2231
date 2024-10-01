/**
 * Represents a node in a linked list.
 *
 * @author Java Foundations
 * @version 4.0
 */

 // Modified class to allow for implementation of a deque.

public class LinearNode<T> {
    private LinearNode<T> next;
    private LinearNode<T> prev;
    private T element;

    /**
     * Creates an empty node.
     */
    public LinearNode() {
        next = null;
        prev = null;
        element = null;
    }

    /**
     * Creates a node storing the specified element.
     * 
     * @param elem element to be stored
     */
    public LinearNode(T elem) {
        next = null;
        prev = null;
        element = elem;
    }

    /**
     * Returns the node that follows this one.
     * 
     * @return reference to next node
     */
    public LinearNode<T> getNext() {
        return next;
    }

    /**
     * Sets the node that follows this one.
     * 
     * @param node node to follow this one
     */
    public void setNext(LinearNode<T> node) {
        linkNext(node);
    }

    //---------------------------------------------------------------------------------------------
    // getPrev() returns the node that precedes this one
    //---------------------------------------------------------------------------------------------
    public LinearNode<T> getPrev() 
    {
        return prev;
    }

    //---------------------------------------------------------------------------------------------
    // setPrev() sets the node that precedes this one
    //---------------------------------------------------------------------------------------------
    public void setPrev(LinearNode<T> node)
    {
        linkPrev(node);
    }

    //---------------------------------------------------------------------------------------------
    // linkNext(nextNode): links this node with the next node, ensuring that they have a mutual relationship necessary for a linear arrangement
    //---------------------------------------------------------------------------------------------
    private void linkNext(LinearNode<T> nextNode)
    {
        next = nextNode;
        if(nextNode != null)
        {
            nextNode.prev = this;
        }
    }

    //---------------------------------------------------------------------------------------------
    // linkPrev(prevNode): links this node with the previous node, ensuring that they have a mutual relationship necessary for a linear arrangement
    //---------------------------------------------------------------------------------------------
    private void linkPrev(LinearNode<T> prevNode)
    {
        prev = prevNode;
        if(prevNode != null)
        {
            prevNode.next = this;
        }
    }

    /**
     * Returns the element stored in this node.
     * 
     * @return element stored at the node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element stored in this node.
     * 
     * @param elem element to be stored at this node
     */
    public void setElement(T elem) {
        element = elem;
    }
}