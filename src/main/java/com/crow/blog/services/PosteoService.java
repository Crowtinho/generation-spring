package com.crow.blog.services;

import com.crow.blog.models.Posteo;
import com.crow.blog.repositories.Repository;

import java.time.LocalDate;
import java.util.Date;

public interface PosteoService extends Repository<Posteo> {
    void agregarFecha(Posteo posteo);

}
