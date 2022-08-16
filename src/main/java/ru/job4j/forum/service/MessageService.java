package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.persistence.MessageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository store;

    public MessageService(MessageRepository store) {
        this.store = store;
    }

    /**
     * Метод добавляет сообщение в тему форума.
     * @param message Сообщение.
     * @return Добавленное сообщение.
     */
    @Transactional
    public Message save(Message message) {
        return store.save(message);
    }

    /**
     * Метод возвращает сообщение на форуме по id.
     * @param id Идентификационный номер сообщения.
     * @return Найденное сообщение.
     */
    @Transactional
    public Optional<Message> findById(int id) {
        return store.findById(id);
    }

    /**
     * Метод возвращает список всех сообщений на форуме.
     * @return Список сообщений.
     */
    @Transactional
    public List<Message> findAll() {
        List<Message> messages = new ArrayList<>();
        store.findAll().forEach(messages::add);
        return messages;
    }
}
