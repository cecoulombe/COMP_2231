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


public class HashTableDriver {
    public static void main(String[] args) {
        // instantiate the hash table
        HashTable ht = new HashTable(11);

        // insert some books, deliberately causing a collision
        ht.insert("Book 1", "1234567890");
        ht.insert("Book 2", "0987654321");
        ht.insert("Book 3", "7654321890");  // collision with Book 1, but a unique isbn
        ht.insert("Book 4", "5678901234");

        // print the hashtable
        System.out.println("Populated the table with four books, including one collision");
        ht.printTable();
        System.out.println();

        // text finding a book
        System.out.println("Finding book 2 via ISBN (0987654321): " + ht.find("0987654321"));
        System.out.println();

        // test removing a book
        System.out.println("Removing book 4.");
        ht.remove("5678901234");
        ht.printTable();
        System.out.println();

        // test resizing
        System.out.println("Test resizing the table");
        for(int i = 0; i < 20; i++)
        {
            ht.insert("Book " + (i + 5), "000000000" + i);
        }
        ht.printTable();
    }
}
