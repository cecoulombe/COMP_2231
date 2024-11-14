
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
 */

import java.io.FileNotFoundException;

public class BackPainAnalyzer {
    
    //------------------------------------------------------------------------------
    // Asks questions of the user to diagnose a medical problem.
    //------------------------------------------------------------------------------
  public static void main(String[] args) throws FileNotFoundException
  {
     System.out.println("So, you’re having back pain.");
     DecisionTree expert = new DecisionTree("BackPainFile.txt");
     expert.evaluate();
  }
}
