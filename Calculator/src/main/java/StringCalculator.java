import java.util.Arrays;

public class StringCalculator {


    public static int addition(String numbersToAdd) {
        if (numbersToAdd.isEmpty()) {
            return 0;
        }
        numbersToAdd = removeNewLine(numbersToAdd);
        String[] numbersArray = numbersToAdd.split(",");
        return Arrays.stream(numbersArray).mapToInt(Integer::parseInt).sum();
    }

    private static String removeNewLine(String numberToAdd) {
        numberToAdd = numberToAdd.replace("\n", ",");
        return numberToAdd;
    }
}
