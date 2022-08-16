package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Message;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.util.Calendar;
import java.util.Date;

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
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/description/{pId}")
    public String post(@PathVariable("pId") int id, Model model) {
        model.addAttribute("post", postService.findById(id).get());
        return "post/description";
    }

    @PostMapping("/addMessage")
    public String addMessage(@RequestParam("id") int id, @ModelAttribute Message message) {
        Post post = postService.findById(id).get();
        post.addMessage(Message.of(message.getMsg()));
        postService.save(post);
        return String.format("redirect:/description/%d", id);
    }

    @GetMapping("/edit/{pId}")
    public String editFrom(@PathVariable("pId") int id, Model model) {
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
