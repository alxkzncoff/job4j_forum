package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
public class PostControl {
    private final PostService postService;
    private final UserService userService;

    public PostControl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "post/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Post post) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userService.findByName(username);
        post.setUser(user.get());
        post.setCreated(Calendar.getInstance().getTime());
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/description/{pId}")
    public String post(@PathVariable("pId") int id, Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("post", postService.findById(id).get());
        return "post/description";
    }

    @GetMapping("/edit/{pId}")
    public String editFrom(@PathVariable("pId") int id, Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("id", id);
        return "post/edit";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") int id, @ModelAttribute Post post) {
        post.setCreated(new Date(System.currentTimeMillis()));
        post.setId(id);
        postService.save(post);
        return String.format("redirect:/description/%d", id);
    }
}
