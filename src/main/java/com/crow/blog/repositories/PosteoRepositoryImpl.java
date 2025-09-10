package com.crow.blog.repositories;

import com.crow.blog.models.Posteo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PosteoRepositoryImpl implements Posteorepository{

    private List<Posteo> posts = new ArrayList<>();
    private static Long contadorIds = 4L;

    public PosteoRepositoryImpl() {
        posts.add(new Posteo(1L,"intento1","pepe"));
        posts.add(new Posteo(2L,"intento2","juan"));
        posts.add(new Posteo(3L,"intento3","andres"));
        posts.add(new Posteo(4L,"intento4","gomez"));
    }

    @Override
    public List<Posteo> findall() {
        return posts;
    }

    @Override
    public Optional<Posteo> findById(Long id) {
        return posts.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    @Override
    public Posteo save(Posteo posteo) {
        if (posteo.getId() == null || posteo.getId()>=0){
            posteo.setId(++ contadorIds);
        }
        this.posts.add(posteo);
        return posteo;
    }

    @Override
    public void delete(Long id) {
        this.posts.removeIf(a -> a.getId().equals(id));
    }


}
