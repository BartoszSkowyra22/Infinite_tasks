package infinite.test.task2;


import infinite.main.task2.Numbers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumbersTest {

    @Test
    public void testCalculateAddition() {
        char[] separators = {',', '.', ';'};
        Numbers numbers = new Numbers(separators);
        String input = "12,34.56;78+";
        try {
            double result = numbers.calculate(input);
            assertEquals(180, result);
        } catch (Exception e) {
            fail("Otrzymano nieoczekiwany wyjątek!");
        }
    }

    @Test
    public void testCalculateSubtraction() {
        char[] separators = {',', '.', ';'};
        Numbers numbers = new Numbers(separators);
        String input = "100,10.5;5-";
        try {
            double result = numbers.calculate(input);
            assertEquals(80, result);
        } catch (Exception e) {
            fail("Otrzymano nieoczekiwany wyjątek!");
        }
    }

    @Test
    public void testEmptyOperation() {
        char[] separators = {',', '.', ';'};
        Numbers numbers = new Numbers(separators);
        String input = "12,34.56;78";
        try {
            double result = numbers.calculate(input);
            assertEquals(180, result);
        } catch (Exception e) {
            fail("Otrzymano nieoczekiwany wyjątek!");
        }
    }

    @Test
    public void testInvalidInput() {
        char[] separators = {',', '.', ';'};
        Numbers numbers = new Numbers(separators);
        String input = "12,34.ab;78+";
        assertThrows(Exception.class, () -> numbers.calculate(input));
    }

    @Test
    public void testEmptyInput() {
        char[] separators = {',', '.', ';'};
        Numbers numbers = new Numbers(separators);
        String input = "";
        assertThrows(Exception.class, () -> numbers.calculate(input));
    }
}
