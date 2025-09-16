package com.crow.blog.services;

import com.crow.blog.models.Posteo;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    List<T> findall();
    Optional<T> findById(Long id);
    T save(T t);
    Optional<T> delete(Long id);
}
