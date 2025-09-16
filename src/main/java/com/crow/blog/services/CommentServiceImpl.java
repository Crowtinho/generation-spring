package com.crow.blog.services;

import com.crow.blog.models.Comment;
import com.crow.blog.repositories.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    final private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> findall() {
        return commentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Transactional
    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public Optional<Comment> delete(Long id) {
        return commentRepository.findById(id).map(c -> {
            commentRepository.deleteById(id);
            return c;
        });
    }
}
