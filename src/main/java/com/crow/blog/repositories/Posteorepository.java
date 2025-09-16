package com.crow.blog.repositories;

import com.crow.blog.models.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Posteorepository extends JpaRepository<Posteo,Long> {

}
