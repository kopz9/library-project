package com.kopz.library.services;


import com.kopz.library.model.Author;
import com.kopz.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {


    @Autowired
    private AuthorRepository repository;

    public Author createAuthor(Author obj){
        return repository.save(obj);
    }

    public void deleteAuthor(Long id){
        repository.deleteById(id);
    }

    public Author findById(Long id){
        Optional<Author> obj = repository.findById(id);
        return obj.get();
    }

    public List<Author> findAll(){
        return repository.findAll();
    }

    public Author update(Author obj){
        Optional<Author> newObj = repository.findById(obj.getId());
        updateAuthor(newObj, obj);
        return repository.save(newObj.get());
    }

    public void updateAuthor(Optional<Author> newObj, Author obj){
        newObj.get().setName(obj.getName());

    }


}
