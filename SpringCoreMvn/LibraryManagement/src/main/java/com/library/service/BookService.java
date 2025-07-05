// package com.library.service;

// import com.library.repository.BookRepository;

// public class BookService {

//     private BookRepository bookRepository;

//     // ✅ Setter method for DI
//     public void setBookRepository(BookRepository bookRepository) {
//         this.bookRepository = bookRepository;
//     }

//     public void addBook(String book) {
//         System.out.println("Adding book: " + book);
//         bookRepository.saveBook(book);
//     }
// }

// package com.library.service;

// import com.library.repository.BookRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class BookService {

//     @Autowired  // ← tells Spring to inject this dependency
//     private BookRepository bookRepository;

//     public void addBook(String book) {
//         System.out.println("Adding book: " + book);
//         bookRepository.saveBook(book);
//     }
// }

package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired // constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String book) {
        System.out.println("Adding book: " + book);
        bookRepository.saveBook(book);
    }
}
