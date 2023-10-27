package com.kopz.library.controller;


import com.kopz.library.model.Author;
import com.kopz.library.model.Book;
import com.kopz.library.services.AuthorService;
import com.kopz.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAuthor(author));
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable ("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable ("id") Long id, @RequestBody Author author){
        author.setId(id);
        return ResponseEntity.ok().body(service.update(author));
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable("id") Long id){
        service.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

}
