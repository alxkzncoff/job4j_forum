package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.persistence.PostRepository;

import java.util.*;

@Service
public class PostService {
    private final PostRepository store;

    public PostService(PostRepository store) {
        this.store = store;
    }

    /**
     * Метод добавляет пост на форум.
     * @param post Новый пост.
     * @return Добавленный пост.
     *
     *  Метод save реализован так, что при его вызове SD проверяет, есть ли у переданного объекта идентификатор.
     *  Если его нет, то SD понимает, что это новый объект и сохраняет его в базу данных.
     *  Объект, соответственно получает ID. Если же ID есть, то SD обновляет его.
     *  Поэтому на два действия у нас один метод.
     */
    @Transactional
    public Post save(Post post) {
        return store.save(post);
    }

    /**
     * Метод возвращает пост по id.
     * @param id Идентификационный номер поста.
     * @return Найденный пост.
     */
    @Transactional
    public Optional<Post> findById(int id) {
        return store.findById(id);
    }

    /**
     * Метод возвращает список всех постов на форуме.
     * @return Список постов.
     */
    @Transactional
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();
        store.findAll().forEach(posts::add);
        return posts;
    }
}
