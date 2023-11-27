package by.karelin.stringcharactercounter.services;

import by.karelin.stringcharactercounter.payload.requests.CharactersCountRequest;
import by.karelin.stringcharactercounter.payload.responses.CharactersCountResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

public class StringCharacterCounterServiceTest {
    private final StringCharacterCounterService counter = new StringCharacterCounterService();

    private static Stream<Arguments> testParameters(){
        return Stream.of(
                Arguments.of("aaabcabcc", Map.of('a', 4, 'c', 3, 'b', 2)),
                Arguments.of("abbbca", Map.of('b', 3, 'a', 2, 'c', 1)),
                Arguments.of("ccbaaaa", Map.of('a', 4, 'c', 2, 'b', 1))
        );
    }

    @ParameterizedTest
    @MethodSource("testParameters")
    public void countCharactersTest(String input, Map<Character, Integer> expectedCharacters){
        var request = new CharactersCountRequest(input);
        var response = new CharactersCountResponse(expectedCharacters);

        var actualResult = counter.countCharacters(request);

        Assertions.assertEquals(response, actualResult);
    }

}
