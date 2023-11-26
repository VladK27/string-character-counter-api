package by.karelin.stringcharactercounter.controllers;

import by.karelin.stringcharactercounter.payload.requests.CharactersCountRequest;
import by.karelin.stringcharactercounter.payload.responses.CharactersCountResponse;
import by.karelin.stringcharactercounter.services.StringCharacterCounterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CharacterCounterController {
    private final StringCharacterCounterService counterService;

    @PostMapping("/count-characters")
    public ResponseEntity<CharactersCountResponse> getCharactersCount(
            @Valid @RequestBody CharactersCountRequest input
    ){
        CharactersCountResponse response = counterService.countCharacters(input);
        return ResponseEntity.ok(response);
    }
}
