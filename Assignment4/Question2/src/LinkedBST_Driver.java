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

public class LinkedBST_Driver {
    // requirements
    // demonstrate all added methods
    // create two different degenerate trees and output the height before and after
    // balancing the trees
    // then make an insertion to the tree that results in it being degenerate and
    // rebalance

    public static void main(String[] args) 
    {
        testMethods();
        balanceTree();
    }

    // ------------------------------------------------------------------------------------
    // Creates a test tree and demonstrates the functionality of all methods in
    // LinkedBinarySearchTree
    // ------------------------------------------------------------------------------------
    private static void testMethods() 
    {
        // Initialize the tree
        LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();

        // use addElement to add to the tree
        System.out.println("The empty tree has a height of: " + tree.height());
        System.out.println("Adding 11 elements to the tree using addElement:");
        tree.addElement(10);
        tree.addElement(5);
        tree.addElement(20);
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(15);
        tree.addElement(30);
        tree.addElement(19);
        tree.addElement(4);
        tree.addElement(15);
        tree.addElement(25);
        System.out.println("Current tree: \n" + tree);
        System.out.println("The height of the tree is now: " + tree.height());
        System.out.println();

        // demonstrate findMin and findMax
        System.out.println("Minimum element in the tree: " + tree.findMin());
        System.out.println("Maximum element in the tree: " + tree.findMax());
        System.out.println();

        // demonstrate removeMin and removeMax
        System.out.println("Removing the minimum element: " + tree.removeMin());
        System.out.println("New minimum element in the tree: " + tree.findMin());
        System.out.println("Removing the maximum element: " + tree.removeMax());
        System.out.println("New maximum element in the tree: " + tree.findMax());
        System.out.println();

        // demonstrate remove root
        System.out.println("Current tree: \n" + tree);
        System.out.println("Removing element 10 from the tree.");
        tree.removeElement(10);
        System.out.println("New tree after removal: \n" + tree);
        System.out.println();

        // demonstrate removeAllOccurances
        System.out.println("Removing all occurances of element 15");
        tree.removeAllOccurrences(15);
        System.out.println("New tree after removals: \n" + tree);
        System.out.println();

        // demonstrate edge cases
        // remove an element that doesn't exist
        System.out.println("Attempting to remove an element that does not exist (99).");
        try {
            tree.removeElement(99);
        } catch (ElementNotFoundException e) {
            System.out.println("Caught expected exception for non-existent element: " + e.getMessage());
        }
        System.out.println();
    }

    // ------------------------------------------------------------------------------------
    // Creates an unbalanced tree and balances it
    // ------------------------------------------------------------------------------------
    private static void balanceTree() 
    {
        // Degenerate tree 1
        System.out.println("Creating two unbalanced trees.");
        LinkedBinarySearchTree<Integer> unbalanced_1 = new LinkedBinarySearchTree<>();
        unbalanced_1.addElement(10);
        unbalanced_1.addElement(8);
        unbalanced_1.addElement(7);
        unbalanced_1.addElement(5);
        unbalanced_1.addElement(3);
        System.out.println("Current tree: \n" + unbalanced_1);
        System.out.println("Height of unbalanced tree 1 before balancing: " + unbalanced_1.height());
        unbalanced_1.buildBalancedTree();
        System.out.println("Tree after balancing: \n" + unbalanced_1);
        System.out.println("Height of unbalanced tree 1 after balancing: " + unbalanced_1.height());
        System.out.println();

        LinkedBinarySearchTree<Integer> unbalanced_2 = new LinkedBinarySearchTree<>();
        unbalanced_2.addElement(10);
        unbalanced_2.addElement(8);
        unbalanced_2.addElement(11);
        unbalanced_2.addElement(12);
        unbalanced_2.addElement(15);
        unbalanced_2.addElement(17);
        unbalanced_2.addElement(20);
        System.out.println("Current tree: \n" + unbalanced_2);
        System.out.println("Height of unbalanced tree 2 before balancing: " + unbalanced_2.height());
        unbalanced_2.buildBalancedTree();
        System.out.println("Tree after balancing: \n" + unbalanced_2);
        System.out.println("Height of unbalanced tree 2 after balancing: " + unbalanced_2.height());
        System.out.println();

        // Demonstrate addElement esulting in a degenerate tree and rebalancing it
        System.out.println("Inserting elements into unbalanced tree 1 to make it degenerate.");
        unbalanced_1.addElement(11);
        unbalanced_1.addElement(12);
        unbalanced_1.addElement(13);
        System.out.println("Tree after creating an imbalance: \n" + unbalanced_1);
        System.out.println("Height of unbalanced tree 1 after creating an imbalance: " + unbalanced_1.height());
        unbalanced_1.buildBalancedTree();
        System.out.println("Tree after balancing: \n" + unbalanced_1);
        System.out.println("Height of unbalanced tree 1 after balancing again: " + unbalanced_1.height());
    }
}
