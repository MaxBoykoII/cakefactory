package com.app.cakefactory.controllers;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.app.cakefactory.cakes.CakeItem;
import com.app.cakefactory.services.CatalogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

@WebMvcTest(HomeController.class)
public class HomeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CatalogService catalogServiceMock;

    @Test
    @DisplayName("should return the landing page")
    public void testHomePage() throws Exception {
        CakeItem item1 = new CakeItem(
                "1-1",
                "Chocolate Cake",
                10.0
        );

        CakeItem item2 = new CakeItem(
                "1-2",
                "Cheese Cake",
                11.0
        );

        when(catalogServiceMock.getCakeItems()).thenReturn(Arrays.asList(item1, item2));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(
                        containsString("Welcome to the Cake Factory!")
                ))
                .andExpect(model().attribute("cakeItems", hasItem(
                        allOf(
                                hasProperty("id", is("1-1")),
                                hasProperty("title", is("Chocolate Cake")),
                                hasProperty("price", is(10.0))
                        )
                )))
                .andExpect(model().attribute("cakeItems", hasItem(
                        allOf(
                                hasProperty("id", is("1-2")),
                                hasProperty("title", is("Cheese Cake")),
                                hasProperty("price", is(11.0))
                        )
                )));

        verify(catalogServiceMock, times(1)).getCakeItems();
        verifyNoMoreInteractions(catalogServiceMock);
    }
}
