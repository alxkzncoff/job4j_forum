package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import java.util.Optional;

@Controller
public class MessageControl {

    private final PostService postService;
    private final UserService userService;

    public MessageControl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/addMessage")
    public String addMessage(@RequestParam("id") int id, @ModelAttribute Message message) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userService.findByName(username);
        Post post = postService.findById(id).get();
        post.addMessage(Message.of(message.getMsg(), user.get()));
        postService.save(post);
        return String.format("redirect:/description/%d", id);
    }
}
