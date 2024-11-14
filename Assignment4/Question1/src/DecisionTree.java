/* Author: Caitlin Coulombe, T00756521
 * Date: November 2, 2024
 * Course: COMP 2131
 * Assignment 4, Question 1: Complete the implementation of a DecisionTree, introduced 
 * in Chapter 19. This will require completing a number of methods from the source 
 * code for this chapter, particularly for LinkedBinaryTree. Your initial test should 
 * be the BackPainAnalyzer output from Listing 19.6 on page 746. Show test cases for 
 * at least two other correct traversals of this tree.
 * 
 * Develop and demonstrate another decision tre that is more complex than the BachPainAnalyzer 
 * tree. Provide at least two correct traversals of this tree as well.
 * 
 * ** This class is modified based on the version from Java Foundations 4.0**
 */

import java.util.*;
import java.io.*;

/**
 * The DecisionTree class uses the LinkedBinaryTree class to implement
 * a binary decision tree. Tree elements are read from a given file and
 * then the decision tree can be evaluated based on user input using the
 * evaluate method.
 *
 * @author Java Foundations
 * @version 4.0
 */

public class DecisionTree {
    private LinkedBinaryTree<String> tree;

    /**
     * Builds the decision tree based on the contents of the given file
     *
     * @param filename the name of the input file
     * @throws FileNotFoundException if the input file is not found
     */
    public DecisionTree(String filename) throws FileNotFoundException {
        File inputFile = new File(filename);
        Scanner scan = new Scanner(inputFile);
        int numberNodes = scan.nextInt();
        scan.nextLine();
        int root = 0, left, right;
        List<LinkedBinaryTree<String>> nodes = new java.util.ArrayList<LinkedBinaryTree<String>>();
        for (int i = 0; i < numberNodes; i++)
        {
            nodes.add(i, new LinkedBinaryTree<String>(scan.nextLine()));
        }
        while (scan.hasNextInt()) {
            root = scan.nextInt();
            
            // Check if there are enough integers left to read
            if (scan.hasNextInt()) {
                left = scan.nextInt();
                if (scan.hasNextInt()) {
                    right = scan.nextInt();
        
                    // Check for valid indices
                    if (root >= 0 && root < nodes.size() && left >= 0 && left < nodes.size() && right >= 0 && right < nodes.size()) {
                        nodes.set(root, new LinkedBinaryTree<>(nodes.get(root).getRootElement(), nodes.get(left), nodes.get(right)));
                    } else {
                        System.out.println("Invalid indices: root=" + root + ", left=" + left + ", right=" + right);
                    }
                }
            }
            
            // Move to the next line, but ensure it exists
            if (scan.hasNextLine()) {
                scan.nextLine(); // Move to the next line
            } else {
                break; // Exit if there are no more lines
            }
        }
        tree = nodes.get(root);
        scan.close();
    }

    /**
     * Follows the decision tree based on user responses.
     */
    public void evaluate() {
        LinkedBinaryTree<String> current = tree;
        Scanner scan = new Scanner(System.in);
        while (current.size() > 1) {
            System.out.println(current.getRootElement());
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("N"))
                current = current.getLeft();
            else if (answer.equalsIgnoreCase("Y"))
                current = current.getRight();
        }
        System.out.println(current.getRootElement());
        scan.close();
    }
}
