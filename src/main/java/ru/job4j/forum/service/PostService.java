package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {
    private final AtomicInteger id = new AtomicInteger(3);
    private final HashMap<Integer, Post> posts = new HashMap<>();

    public PostService() {
        posts.put(1, Post.of(1, "О чем форум.", "Описание форума.",
                Calendar.getInstance().getTime()));
        posts.put(2, Post.of(2, "Правила форума.", "Свод правил.",
                Calendar.getInstance().getTime()));
        posts.put(3, Post.of(3, "Беседка.", "Свободное общение.",
                Calendar.getInstance().getTime()));
    }

    public void add(Post post) {
        post.setId(id.incrementAndGet());
        posts.put(post.getId(), post);
    }

    public void update(int id, Post post) {
        posts.replace(id, post);
    }

    public Optional<Post> findById(int id) {
        return Optional.of(posts.get(id));
    }

    public List<Post> findAll() {
        return posts.values().stream().toList();
    }

    public void addMessage(int id, String message) {
        posts.get(id).getMessages().add(message);
    }
}
