package by.karelin.stringcharactercounter.payload.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class CharactersCountResponse {
    private Map<Character, Integer> charactersCountMap;
}
