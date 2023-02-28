package com.jc.springrestdocs.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
class ExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void example1() throws Exception {
        mockMvc.perform(get("/example").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("post-get-one",
                        responseFields(
                                fieldWithPath("id").description("example id"),
                                fieldWithPath("name").description("example name")
                        )
                ));
    }

}