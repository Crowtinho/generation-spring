package com.crow.blog.controllers;


import com.crow.blog.models.Comment;
import com.crow.blog.services.CommentService;
import com.crow.blog.services.CommentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("comments")
public class CommentController {

    final private CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<Comment>> listarComments(){
        return ResponseEntity.of(Optional.ofNullable(commentService.findall()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id){
        Optional<Comment> optionalComment = commentService.findById(id);
        if (optionalComment.isPresent()){
            return ResponseEntity.ok(optionalComment.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/crear")
    public ResponseEntity<Comment> guardarComment(@Valid @RequestBody Comment comment){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(comment));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Comment> editarComment(@Valid @RequestBody Comment comment, @PathVariable Long id){
        Optional<Comment> optionalComment = commentService.findById(id);
        if (optionalComment.isPresent()){
            Comment commentDb = optionalComment.orElseThrow();
            commentDb.setText(comment.getText());
            commentDb.setPosteo(comment.getPosteo());
            return ResponseEntity.ok(commentService.save(commentDb));
        }
        return ResponseEntity.notFound().build();
    }



}
