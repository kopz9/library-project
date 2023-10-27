package com.kopz.library.services;

import com.kopz.library.model.Book;
import com.kopz.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book createBook(Book book){
        return repository.save(book);
    }

    public void deleteBook(Long id){
        repository.deleteById(id);
    }

    public Book findById(Long id){
        Optional<Book> book = repository.findById(id);
        return book.orElse(null);
    }

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Book update(Book book){
        Optional<Book> newBook = repository.findById(book.getId());
        updateBook(newBook, book);
        return repository.save(newBook.get());
    }

    public void updateBook(Optional<Book> newBook, Book book){
        newBook.get().setName(book.getName());

    }


}
