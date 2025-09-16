package com.crow.blog.services;

import com.crow.blog.models.Posteo;

public interface PosteoService extends Service<Posteo> {
    void agregarFecha(Posteo posteo);

}
