package by.karelin.stringcharactercounter.controllers;

import by.karelin.stringcharactercounter.payload.requests.CharactersCountRequest;
import by.karelin.stringcharactercounter.payload.responses.CharactersCountResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.LinkedHashMap;
import java.util.Map;

@AutoConfigureMockMvc
@SpringBootTest
class CharacterCounterControllerTest {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Should return sorted map of characters and numbers of it's appearance")
    void getCharactersCountTest() throws Exception {
        var request = new CharactersCountRequest("aaaaabbbbccdctt");
        Map<Character, Integer> map = new LinkedHashMap<>();
        map.put('a',5);
        map.put('b',4);
        map.put('c', 3);
        map.put('t', 2);
        map.put('d', 1);
        var expectedResult = new CharactersCountResponse(map);

        mvc.perform(
                post("/api/v1/count-characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(expectedResult)));
    }
}