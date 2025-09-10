package com.crow.blog.repositories;

import com.crow.blog.models.Posteo;

import java.util.List;
import java.util.Optional;

public interface Repository <T>{
    List<T> findall();
    Optional<T> findById(Long id);
    Posteo save(T t);
    void delete(Long id);
}
