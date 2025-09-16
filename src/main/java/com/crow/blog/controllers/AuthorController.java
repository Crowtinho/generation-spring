package com.crow.blog.controllers;


import com.crow.blog.models.Author;
import com.crow.blog.services.AuthorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    final private AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> listarAuthors(){
        return ResponseEntity.of(Optional.ofNullable(authorService.findall()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        Optional<Author> optionalAuthor = authorService.findById(id);
        if (optionalAuthor.isPresent()){
            return ResponseEntity.ok(optionalAuthor.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/crear")
    public ResponseEntity<Author> guardarAuthor(@Valid @RequestBody Author author){
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.save(author));
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<Author> editarAuthor(@Valid @RequestBody Author author, @PathVariable Long id){
        Optional<Author> optionalAuthor = authorService.findById(id);
        if (optionalAuthor.isPresent()){
            Author authorDb  =optionalAuthor.orElseThrow();
            authorDb.setName(author.getName());
            authorDb.setEmail(author.getEmail());
            authorDb.setPosteos(author.getPosteos());
            return ResponseEntity.ok(authorService.save(authorDb));
        }
        return ResponseEntity.notFound().build();
    }

}
