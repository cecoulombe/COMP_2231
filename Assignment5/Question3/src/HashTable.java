/* Author: Caitlin Coulombe, T00756521
 * Date: November 20, 2024
 * Course: COMP 2231
 * Assignment 5, Question 3: PP I.4 (page 1020). Implement a dynamically resizable hash table
 * to store book names and 10-digit ISBN numbers. Use an initial table size of 11 and a load 
 * factor of 0.7. Use the extraction method with division using the last three digits of the 
 * ISBN as the first hash address. For a collision, use linear probing. 
 * 
 * For your testing, make sure uou deliberately code ISBNs so that collisions will occur, and 
 * demonstrate how the same set of values can result in different hashes, depending on the 
 * order in which they are added. Test adding items until the hash tab;e must be resized. Test 
 * finding and removing items from the hash table.
 * 
 */



public class HashTable {
    // define the hashtable structure 
            // load factor determines the threshold after which the table needs to be resized (0.7)
            // should store both the book name (string) and the isbn number (string) as key value pairs.

    // global variables
    private Entry[] table;
    private int size;
    private int numElements;
    private final double LOAD_FACTOR = 0.7;

    //------------------------------------------------------------------------
    // constructor
    //------------------------------------------------------------------------
    public HashTable(int initialSize)
    {
        this.size = initialSize;
        numElements = 0;
        table = new Entry[initialSize];
    }

    //------------------------------------------------------------------------
    // Hash function based on the last three digits of the isbn
    // Hashed by division = hash(k) = k mod size
    //------------------------------------------------------------------------
    private int hash(String isbn)
    {
        int lastThreeDigits = Integer.parseInt(isbn.substring(isbn.length() - 3));
        return lastThreeDigits % size;
    }

    //------------------------------------------------------------------------
    // resize the table and rehash all entries
    //------------------------------------------------------------------------
    private void resize()
    {
        int newSize = size * 2;
        Entry[] newTable = new Entry[newSize];
        Entry[] oldTable = table;

        table = newTable;
        size = newSize;
        numElements = 0;    // will be updaated as we rehash entries

        for(Entry entry : oldTable)
        {
            if(entry != null && entry.isOccupied && !entry.isDeleted)
            {
                insert(entry.bookName, entry.isbn);
            }
        }
    }

    //------------------------------------------------------------------------
    // insert a book and isbn into the hashtable. Resize table if necessary
    //------------------------------------------------------------------------
    public void insert(String bookname, String isbn)
    {
        if((double) numElements / size > LOAD_FACTOR)
        {
            resize();
        }

        int index = hash(isbn);
        while(table[index] != null && table[index].isOccupied)
        {
            if(table[index].isbn.equals(isbn))
            {
                return; // this isbn already exists so we wont duplicate it
            }
            index = (index + 1) % size; // linear probing
        }

        table[index] = new Entry(bookname, isbn);
        numElements++;
    }

    //------------------------------------------------------------------------
    // find a book name by isbn and return a reference
    //------------------------------------------------------------------------
    public String find(String isbn)
    {
        int index = hash(isbn);
        int originalIndex = index;

        while(table[index] != null)
        {
            if(table[index].isOccupied && !table[index].isDeleted && table[index].isbn.equals(isbn))
            {
                // found the book, return it
                return table[index].bookName;
            }

            index = (index + 1) % size; // linear probing if its not in the hashed index
            if(index == originalIndex) break;   // prevents infinite probing once it has looped all the way around
        }

        return null;    // book not found
    }

    //------------------------------------------------------------------------
    // find and remove a book by isbn
    //------------------------------------------------------------------------
    public void remove(String isbn)
    {
        int index = hash(isbn);
        int originalIndex = index; 

        while(table[index] != null)
        {
            if(table[index].isOccupied && !table[index].isDeleted && table[index].isbn.equals(isbn))
            {
                // found the book, delete it
                table[index].isDeleted = true;
                numElements--;
                return;
            }

            index = (index + 1) % size; // linear probing if its not in the hashed index
            if(index == originalIndex) break;   // prevents infinite probing once it has looped all the way around
        }
    }

    //------------------------------------------------------------------------
    // for testing purposes, print the table contents
    //------------------------------------------------------------------------
    public void printTable()
    {
        for(int i = 0; i < size; i ++)
        {
            if(table[i] != null && table[i].isOccupied && !table[i].isDeleted)
            {
                System.out.println("Index " + i + " : " + table[i].bookName + " | ISBN: " + table[i].isbn);
            }
        }
    }


    //------------------------------------------------------------------------
    // Entry class is used to store entries consisting of book names and ISBNs
    //------------------------------------------------------------------------
    class Entry {
        String bookName;
        String isbn;
        boolean isOccupied;
        boolean isDeleted;  // used for soft deletions

        public Entry(String bookName, String isbn)
        {
            this.bookName = bookName;
            this.isbn = isbn;
            isOccupied = true;
            isDeleted = false;
        }
    }
}
