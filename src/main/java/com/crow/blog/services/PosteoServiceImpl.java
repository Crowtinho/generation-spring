package com.crow.blog.services;

import com.crow.blog.models.Author;
import com.crow.blog.models.Posteo;
import com.crow.blog.repositories.Posteorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PosteoServiceImpl implements PosteoService {

    Posteorepository posteorepository;

    @Autowired
    public PosteoServiceImpl(Posteorepository posteorepository) {
        this.posteorepository = posteorepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Posteo> findall() {
        return posteorepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Posteo> findById(Long id) {
        return posteorepository.findById(id);
    }

    @Transactional
    @Override
    public Posteo save(Posteo posteo) {
        agregarFecha(posteo);
        return posteorepository.save(posteo);
    }

    @Transactional
    @Override
    public Optional<Posteo> delete(Long id) {
        return posteorepository.findById(id).map(p ->{
            posteorepository.deleteById(id);
            return p;
        });
    }


    @Override
    public void agregarFecha(Posteo posteo) {
        posteo.setTitulo(posteo.getTitulo() + LocalDate.now());
    }
}
