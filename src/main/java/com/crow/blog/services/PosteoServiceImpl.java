package com.crow.blog.services;

import com.crow.blog.models.Posteo;
import com.crow.blog.repositories.Posteorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoServiceImpl implements PosteoService {

    Posteorepository posteoService;

    @Autowired
    public PosteoServiceImpl(Posteorepository posteoService) {
        this.posteoService = posteoService;
    }

    @Override
    public List<Posteo> findall() {
        return posteoService.findall();
    }

    @Override
    public Optional<Posteo> findById(Long id) {
        return posteoService.findById(id);
    }

    @Override
    public Posteo save(Posteo posteo) {
        return posteoService.save(posteo);
    }

    @Override
    public void delete(Long id) {
        posteoService.delete(id);
    }
}
