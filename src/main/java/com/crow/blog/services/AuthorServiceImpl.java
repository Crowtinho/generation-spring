package com.crow.blog.services;

import com.crow.blog.models.Author;
import com.crow.blog.models.Posteo;
import com.crow.blog.repositories.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService{


    final private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findall() {
        return authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Transactional
    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    @Override
    public Optional<Author> delete(Long id) {
        return authorRepository.findById(id).map(a ->{
            authorRepository.deleteById(id);
            return a;
        });
    }
}
