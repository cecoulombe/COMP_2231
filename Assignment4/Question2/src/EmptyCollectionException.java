/* Author: Caitlin Coulombe, T00756521
 * Date: November 4, 2024
 * Course: COMP 2131
 */

// Credit to Java Foundations, version 4.0. Page 494.
// Represents the situation in which a collection is empty.

public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException(String collection)
    {
        super("The " + collection + " is empty.");
    }    
}
