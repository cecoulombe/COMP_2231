
/* Author: Caitlin Coulombe, T00756521
 * Date: November 2, 2024
 * Course: COMP 2131
 * Assignment 4, Question 1: Complete the implementation of a DecisionTree, introduced 
 * in Chapter 19. This will require completing a number of methods from the source 
 * code for this chapter, particularly for LinkedBinaryTree. Your initial test should 
 * be the BackPainAnalyzer output from Listing 19.6 on page 746. Show test cases for 
 * at least two other correct traversals of this tree.
 * 
 * Develop and demonstrate another decision tre that is more complex than the BackPainAnalyzer 
 * tree. Provide at least two correct traversals of this tree as well.
 * 
 */

 import java.io.FileNotFoundException;

 public class CharacterGuesser {
     
     //------------------------------------------------------------------------------
     // Asks questions to try to determine which character was chosen from either Harry Potter or the Lord of the Rings
     //------------------------------------------------------------------------------
   public static void main(String[] args) throws FileNotFoundException
   {
      System.out.println("Pick a character from Harry Potter or the Lord of the Rings. I will try to guess who you picked.");
      DecisionTree expert = new DecisionTree("Characters.txt");
      expert.evaluate();
   }
 
 // Daniel Radcliff
 // Rupert Grint
 // Emma Watson
 // Tom Felton
 // Evanna Lynch
 // Michael Gambom
 // Richard Harris
 // Alan Rickman
 // Maggie Smith
 
 
 // Elijah Wood
 // Sean Astin
 // Dominic Monaghan
 // Billy Boyd
 // Ian McKellen
 // Orlando Bloom
 // John Rhys-Davies
 // Viggo Mortensen
 // Sean Bean
 }
 