package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class PostControlTest {

    @MockBean
    private PostService postService;

    @Autowired
    private MockMvc mockMvc;


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

    @Test
    @WithMockUser
    public void addPost() throws Exception {
        this.mockMvc.perform(post("/add")
                .param("name", "Test"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).save(argument.capture());
        assertThat(argument.getValue().getName()).isEqualTo("Test");
    }

    @Test
    @WithMockUser
    public void editPost() throws Exception {
        MultiValueMap<String, String> values = new LinkedMultiValueMap<>();
        values.add("id", "1");
        values.add("name", "Test 2");
        this.mockMvc.perform(post("/edit")
                        .params(values))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postService).save(argument.capture());
        assertThat(argument.getValue().getName()).isEqualTo("Test 2");
    }

}