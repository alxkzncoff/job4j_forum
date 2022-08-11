package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.util.Calendar;

@Controller
public class PostControl {
    private final PostService postService;

    public PostControl(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/add")
    public String addForm() {
        return "post/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Post post) {
        post.setCreated(Calendar.getInstance().getTime());
        postService.add(post);
        return "redirect:/";
    }

    @GetMapping("/description/{pId}")
    public String post(@PathVariable("pId") int id, Model model) {
        model.addAttribute("post", postService.findById(id).get());
        return "post/description";
    }

    @PostMapping("/addMessage")
    public String addMessage(@RequestParam("id") int id, @ModelAttribute Message message) {
        postService.addMessage(id, message.getText());
        return String.format("redirect:/description/%d", id);
    }
}
