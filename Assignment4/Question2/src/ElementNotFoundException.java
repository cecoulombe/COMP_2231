/* Author: Caitlin Coulombe, T00756521
 * Date: November 4, 2024
 * Course: COMP 2131
 */

// Represents the situation in which an element is not found within the tree
public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String element)
    {
        super("The element " + element + " was not found.");
    }    
}
