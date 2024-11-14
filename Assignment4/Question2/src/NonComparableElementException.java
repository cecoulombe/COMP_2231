/* Author: Caitlin Coulombe, T00756521
 * Date: November 4, 2024
 * Course: COMP 2131
 */

// Credit to Java Foundations, version 4.0. Page 494.
// Represents the situation in which a collection is empty.

public class NonComparableElementException extends RuntimeException {
    public NonComparableElementException(String msg)
    {
        super("Elements of a " + msg + " must be comparable.");
    }    
}
