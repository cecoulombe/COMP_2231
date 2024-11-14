/* Author: Caitlin Coulombe, T00756521
 * Date: November 4, 2024
 * Course: COMP 2131
 * Assignment 4, Question 2: Complete all missing methods in LinkedBinarySearchTree. Show 
 * test cases for all implemented methods being sure to include edge cases for methods 
 * where applicable.
 * Then, implement a balance tree method for this class using the brute force method 
 * described in Section 20.5 of your textbook.
 * Show test cases for two different degenerate trees, outputting the height of the tree
 * before and after balancing the tree. Then, demonstrate insertions into a balanced tree 
 * that result in degenerate trees and rebalance the tree again.
 * 
 *  * Hint: Copy the elements into an ArrayList using an in-order traversal. Recursively 
 *    build a balanced tree using a binary partitioning.
 * 
 */

 import java.util.ArrayList;

public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T>{
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    //------------------------------------------------------------------------------------------
    // Creates an empty binary search tree
    //------------------------------------------------------------------------------------------
    public LinkedBinarySearchTree()
    {
        super();
    }

    //------------------------------------------------------------------------------------------
    // Creates a binary search with the specified element as its root
    //------------------------------------------------------------------------------------------
    public LinkedBinarySearchTree(T element)
    {
        super(element);

        if(!(element instanceof Comparable))
        {
            throw new NonComparableElementException("LinkedBinarySearchTree");
        }
    }

    //------------------------------------------------------------------------------------------
    // Adds the specified object to the binary search tree in the appropriate position according 
    // to its natural order.
    //------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    public void addElement(T element) {
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("LinkedBinarySearchTree");
        }

        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty()) {
            root = new BinaryTreeNode<T>(element);
        } else {
            addElement(element, root);
        }
    }

    //------------------------------------------------------------------------------------------
    // Adds the specified object to the binary search tree in the appropriate position according 
    // to its natural order. Note that equal elements are added to the right
    //------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    private void addElement(T element, BinaryTreeNode<T> node) {
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (comparableElement.compareTo(node.getElement()) < 0) {
            // Go left
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<T>(element));
            } else {
                addElement(element, node.getLeft());
            }
        } else {
            // Go right (including equal case)
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<T>(element));
            } else {
                addElement(element, node.getRight());
            }
        }
    }


    //------------------------------------------------------------------------------------------
    // Removes the first element that matches the specified target element from the binary search 
    // tree and returns a reference to it. Throws an ELementNotFountException if the specified 
    // target element is not found in the binary search tree
    //------------------------------------------------------------------------------------------
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public T removeElement(T targetElement) throws ElementNotFoundException {
        T result = null;
        if (isEmpty()) {
            throw new ElementNotFoundException(String.valueOf(targetElement));
        } else {
            BinaryTreeNode<T> parent = null;
            if (((Comparable<T>) targetElement).equals(root.element)) {
                result = root.element;
                BinaryTreeNode<T> temp = replacement(root);
                if (temp == null) {
                    root = null; // No children
                } else {
                    root.element = temp.element;
                    root.setLeft(temp.left);
                    root.setRight(temp.right);
                }
                modCount--;
            } else {
                parent = root;
                if (((Comparable) targetElement).compareTo(root.element) < 0) {
                    result = removeElement(targetElement, root.getLeft(), parent);
                } else {
                    result = removeElement(targetElement, root.getRight(), parent);
                }
            }
        }
        return result;
    }

    //------------------------------------------------------------------------------------------
    // Removes the first element that matches the specified target element from the binary search 
    // tree and returns a reference to it. Throws an ELementNotFountException if the specified 
    // target element is not found in the binary search tree
    //------------------------------------------------------------------------------------------
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent) throws ElementNotFoundException {
        if (node == null) {
            throw new ElementNotFoundException(String.valueOf(targetElement)); // Correctly check against targetElement
        }

        T result = null;

        // Compare targetElement with the current node's element
        if (((Comparable<T>) targetElement).equals(node.element)) {
            result = node.element; // Found the element to remove
            BinaryTreeNode<T> temp = replacement(node);
            if (parent.left == node) {
                parent.left = temp; // Adjust parent's left reference
            } else {
                parent.right = temp; // Adjust parent's right reference
            }
            modCount--;
        } else {
            // Move down the tree
            if (((Comparable) targetElement).compareTo(node.element) < 0) {
                // Move to the left child
                result = removeElement(targetElement, node.getLeft(), node);
            } else {
                // Move to the right child
                result = removeElement(targetElement, node.getRight(), node);
            }
        }

        return result;
    }

    //------------------------------------------------------------------------------------------
    // Returns a reference to a node that will replace the one specified for removal. In the case
    // where the removed node has two children, the inorder successor is used as its replacement
    //------------------------------------------------------------------------------------------
    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node)
    {
        BinaryTreeNode<T> result = null;
        if((node.left == null) && (node.right == null))
        {
            result = null;
        } else if((node.left != null) && (node.right == null))
        {
            result = node.left;
        } else if((node.left == null) && (node.right != null))
        {
            result = node.right;
        } else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;

            while(current.left != null)
            {
                parent = current;
                current = current.left;
            }

            current.left = node.left;
            if(node.right != current)
            {
                parent.left = current.right;
                current.right = node.right;
            }

            result = current;
        }
        return result;
    }

    //------------------------------------------------------------------------------------------
    // Removes elements that match the specified target element from the binary search tree. 
    // Throws an ElementNotFoundException if the specified target element is not found in the 
    // tree
    //------------------------------------------------------------------------------------------
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException 
    {
        removeElement(targetElement);
        try 
        {
            while (contains((T) targetElement))
            {
                removeElement(targetElement);
            }
        } catch (Exception ElementNotFoundException) 
        {
        }
    }

    //------------------------------------------------------------------------------------------
    // Removes the node with the least value from the binary search tree and returns a reference 
    // to its element. Throws an EmptyCollectionExcpetion if this tree is empty
    //------------------------------------------------------------------------------------------
    public T removeMin() throws EmptyCollectionException 
    {
        T result = null;
        if (isEmpty())
        {
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        } else {
            if (root.left == null) 
            {
                result = root.element;
                root = root.right;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;

                while (current.left != null) 
                {
                    parent = current;
                    current = current.left;
                }
                
                result = current.element;
                parent.left = current.right;
            }
            modCount--;
        }
        return result;
    }

    //------------------------------------------------------------------------------------------
    // Removes the node with the greatest value from the binary search tree and returns a reference 
    // to its element. Throws an EmptyCollectionExcpetion if this tree is empty
    //------------------------------------------------------------------------------------------
    public T removeMax() {
        T result = null;
        if(isEmpty())
        {
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        } else {
            if(root.right == null)
            {
                result = root.element;
                root = root.left;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;

                while(current.right != null)
                {
                    parent = current;
                    current = current.right;
                }

                result = current.element;
                parent.right = current.left;
            }
            modCount--;
        }
        return result;
    }

    //------------------------------------------------------------------------------------------
    // Returns a reference to the minimum element in the binary search tree but does not remove 
    // the element. Throws an EmptyCollectionException if the binary search tree is empty
    //------------------------------------------------------------------------------------------
    public T findMin() throws EmptyCollectionException
    {
        T result = null;
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        }
        
        BinaryTreeNode<T> current = root;
        while (current.left != null) {
            current = current.left;
        }
        result = current.element;
        
        return result;
    }

    //------------------------------------------------------------------------------------------
    // Returns a reference to the maximum element in the binary search tree but does not remove 
    // the element. Throws an EmptyCollectionException if the binary search tree is empty
    //------------------------------------------------------------------------------------------
    public T findMax() throws EmptyCollectionException
    {
        T result = null;
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        }
        
        BinaryTreeNode<T> current = root;
        while (current.right != null) {
            current = current.right;
        }
        result = current.element;
        
        return result;
    }

    //------------------------------------------------------------------------------------------
    // Brute force method to balance a binary search tree. Returns a balanced tree
    //------------------------------------------------------------------------------------------
    public void buildBalancedTree() 
    {
        ArrayList<T> elementsList = new ArrayList<>();
        inOrderToArrayList(root, elementsList);
        root = buildBalancedTree(elementsList, 0, elementsList.size() - 1);
    }
    
    //------------------------------------------------------------------------------------------
    // Helper method which is called recursively to balance the tree
    //------------------------------------------------------------------------------------------
    private BinaryTreeNode<T> buildBalancedTree(ArrayList<T> elementsList, int start, int end) 
    {
        if (start > end) {
            return null;
        }
    
        // Get the middle element
        int mid = (start + end) / 2;
        BinaryTreeNode<T> node = new BinaryTreeNode<>(elementsList.get(mid));
    
        // Recursively build the left and right subtrees
        node.setLeft(buildBalancedTree(elementsList, start, mid - 1));
        node.setRight(buildBalancedTree(elementsList, mid + 1, end));
    
        return node;
    }
    
    

    //------------------------------------------------------------------------------------------
    // Helper method which creates a sorted list of the elements in the tree
    //------------------------------------------------------------------------------------------
    public ArrayList<T> getSortedElements()
    {
        ArrayList<T> elementsList = new ArrayList<>();
        inOrderToArrayList(root, elementsList);
        return elementsList;
    }

    //------------------------------------------------------------------------------------------
    // Returns the height of the binary tree. The height of an empty tree is -1
    //------------------------------------------------------------------------------------------
    public int height()
    {
        return getHeight(root);
    }

    //------------------------------------------------------------------------------------------
    // Helper method to recursively calculate the height of the tree
    //------------------------------------------------------------------------------------------
    private int getHeight(BinaryTreeNode<T> node) 
    {
        if (node == null) {
            return -1; // or return 0, depending on your height definition
        }
        
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        
        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //------------------------------------------------------------------------------------------
    // Returns a formatted visual representation of the tree
    //------------------------------------------------------------------------------------------
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb, "", true);
        return sb.toString();
    }

    //------------------------------------------------------------------------------------------
    // Helper method to build the string representation of the tree
    //------------------------------------------------------------------------------------------
    private void buildString(BinaryTreeNode<T> node, StringBuilder sb, String indent, boolean last) 
    {
        if (node != null) {
            sb.append(indent);
            if (last) {
                sb.append("R---- "); // R for right child
                indent += "     "; // Add spaces for the next level
            } else {
                sb.append("L---- "); // L for left child
                indent += "|    "; // Use a vertical bar for the next level
            }
            sb.append(node.getElement()).append("\n");
            buildString(node.getLeft(), sb, indent, false);
            buildString(node.getRight(), sb, indent, true);
        }
    }

    
}