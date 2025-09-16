package com.crow.blog.controllers;


import com.crow.blog.models.Posteo;
import com.crow.blog.services.PosteoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posteos")
public class PosteoController {

    private PosteoService posteoService;

    @Autowired
    public PosteoController(PosteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping
    public List<Posteo> listarPosts(){
        return posteoService.findall();
    }

    @GetMapping("/{id}")
    public Optional<Posteo> findById(@PathVariable Long id){
        return posteoService.findById(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarPost(@Valid @RequestBody Posteo posteo){
        posteoService.save(posteo);
        return ResponseEntity.ok("post guardado");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPost(@Valid @PathVariable Long id, @RequestBody Posteo posteo){
        return posteoService.findById(id).map(p -> {
            p.setAuthor(posteo.getAuthor());
            p.setTitulo(posteo.getTitulo());
            posteoService.save(p);
            return ResponseEntity.ok("Producto Actualizado");
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPost(@PathVariable Long id){
        posteoService.delete(id);
    }





}
