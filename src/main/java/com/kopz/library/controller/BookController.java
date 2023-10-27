package com.kopz.library.controller;


import com.kopz.library.model.Author;
import com.kopz.library.model.Book;
import com.kopz.library.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createBook(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable ("id") Long id, @RequestBody Book book){
        book.setId(id);
        return ResponseEntity.ok().body(service.update(book));
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Long id){
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
