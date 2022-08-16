package ru.job4j.forum.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    @Query("SELECT DISTINCT p FROM Post p JOIN FETCH p.messages WHERE p.id = ?1")
    Optional<Post> findById();

//    @Query("SELECT DISTINCT p FROM Post p JOIN FETCH p.messages")
//    Iterable<Post> findAll();
}
