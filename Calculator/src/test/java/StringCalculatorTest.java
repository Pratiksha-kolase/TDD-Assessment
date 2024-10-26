import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
