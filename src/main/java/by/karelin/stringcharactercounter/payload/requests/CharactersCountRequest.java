package by.karelin.stringcharactercounter.payload.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class CharactersCountRequest {
    private String input;
}
