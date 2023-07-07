package com.example.restfulmenu.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class RestfulMenuTest {

    private final MockMvc mockMvc;

    public RestfulMenuTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void testMenuItem1() throws Exception {
        mockMvc.perform(get("/menu/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1 Beef with fried potatoes 50.0"));
    }
}
