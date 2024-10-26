import java.util.Arrays;

public class StringCalculator {


    public static int addition(String numbersToAdd) {
        if (numbersToAdd.isEmpty()) {
            return 0;
        }
        String[] numbersArray = removeNewLine(numbersToAdd);
        return Arrays.stream(numbersArray).mapToInt(Integer::parseInt).sum();
    }

    private static String[] removeNewLine(String numberToAdd) {
        if (numberToAdd.startsWith("//")) {
            numberToAdd = numberToAdd.replace("//", "\n");
        }
        if (numberToAdd.startsWith("//")) {
            numberToAdd = numberToAdd.replace("//", "\n");
        }
        numberToAdd = numberToAdd.replaceAll("[,\\n;`^|#@$%&*()!\\t]+", ",").replaceAll("^,|,$", "");
        String[] separateNum = numberToAdd.split("[,\\n]");

        return separateNum;
    }
}
