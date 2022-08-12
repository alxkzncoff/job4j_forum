package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControl {

    @GetMapping("/login")
    public String loginFrom() {
        return "login";
    }

    @GetMapping("/reg")
    public String regForm() {
        return "reg";
    }
}
