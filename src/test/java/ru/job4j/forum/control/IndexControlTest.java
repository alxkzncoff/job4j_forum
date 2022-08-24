package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class IndexControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void indexShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/index"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @WithMockUser
    public void loginShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    @WithMockUser
    public void logoutShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/logout"))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/login?logout=true"));
    }

    @Test
    @WithMockUser
    public void addShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/add"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/add"));
    }

    @Test
    @WithMockUser
    public void descriptionShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/description/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/description"));
    }

    @Test
    @WithMockUser
    public void editShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/edit/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/edit"));
    }
}