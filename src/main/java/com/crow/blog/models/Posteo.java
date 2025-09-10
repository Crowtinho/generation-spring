package com.crow.blog.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Posteo {
    private Long id;
    @NotBlank(message = "el título no puede ir vacío")
    @NotNull(message = "No puede ser nulo")
    private String titulo;
    @NotBlank(message = "el título no puede ir vacío")
    @NotNull(message = "No puede ser nulo")
    private String autor;



    public Posteo() {
    }

    public Posteo(Long id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
