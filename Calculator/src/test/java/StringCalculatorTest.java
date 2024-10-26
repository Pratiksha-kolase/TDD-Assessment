import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    public void testWithEmptyString(){
        assertEquals(0,StringCalculator.addition(""));
    }
    @Test
    public void testWithOnlyOneNumber(){
        assertEquals(1,StringCalculator.addition("1"));
    }

    @Test
    public void testWithNewLineInBetween(){
        assertEquals(6,StringCalculator.addition("1\n2,3"));
    }

    @Test
    public void testWithDifferentDelimiters(){
        assertEquals(3,StringCalculator.addition("//;\n1;2"));
    }

    @Test
    public void testWithNegativeNumbers(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.addition("-1,2,3,-4");
        });
        assertEquals("negative numbers not allowed -1, -4", exception.getMessage());
    }

}
