// Credit to Java Foundations, version 4.0. Page 494.
// Represents the situation in which a collection is empty.

public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException(String collection)
    {
        super("The " + collection + " is empty.");
    }    
}
