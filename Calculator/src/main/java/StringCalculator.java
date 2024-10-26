import java.util.Arrays;

public class StringCalculator {


    public static int addition(String numbersToAdd){

           String[] numbersArray = numbersToAdd.split(",");
          return Arrays.stream(numbersArray).mapToInt(Integer::parseInt).sum();
    }
}
