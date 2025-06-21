public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "Clean Code", "Robert C. Martin"),
            new Book(103, "1984", "George Orwell")
        };

        Book found1 = Search.linearSearch(books, "1984");
        System.out.println("Linear Search: " + (found1 != null ? found1 : "Not found"));

        Book found2 = Search.binarySearch(books, "Clean Code");
        System.out.println("Binary Search: " + (found2 != null ? found2 : "Not found"));
    }
}

/*
Algorithm	        Time Complexity	    When to Use
Linear Search	    O(n)	            Small/unsorted datasets
Binary Search	    O(log n)	        Large/sorted datasets (by title)
*/