// src/test/java/HelloWorldTest.java
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @Test
    void greet_withValidName_returnsCorrectGreeting() {
        String result = HelloWorld.greet("Алиса", LocalDate.of(2025, 12, 7));
        assertEquals("Привет, Алиса! Сегодня: 2025-12-07", result);
    }

    @Test
    void greet_withNullName_usesDefault() {
        String result = HelloWorld.greet(null, LocalDate.of(2025, 12, 7));
        assertEquals("Привет, незнакомец! Сегодня: 2025-12-07", result);
    }

    @Test
    void greet_withEmptyString_usesDefault() {
        String result = HelloWorld.greet("", LocalDate.of(2025, 12, 7));
        assertEquals("Привет, незнакомец! Сегодня: 2025-12-07", result);
    }

    @Test
    void greet_withWhitespaceOnly_usesDefault() {
        String result = HelloWorld.greet("   \t\n  ", LocalDate.of(2025, 12, 7));
        assertEquals("Привет, незнакомец! Сегодня: 2025-12-07", result);
    }

    @Test
    void greet_dateFormattingIsCorrect() {
        String result = HelloWorld.greet("Bob", LocalDate.of(2023, 1, 15));
        assertEquals("Привет, Bob! Сегодня: 2023-01-15", result);
    }
}