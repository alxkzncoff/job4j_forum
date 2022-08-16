package ru.job4j.forum.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
