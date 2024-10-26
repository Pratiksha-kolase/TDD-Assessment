import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {


    public static int addition(String numbersToAdd) {
        if (numbersToAdd.isEmpty()) {
            return 0;
        }
        if (numbersToAdd.length() == 1) {
            return Integer.parseInt(numbersToAdd);
        }
        String[] numbersArray = removeNewLine(numbersToAdd);
         isNegative(numbersArray);
        return Arrays.stream(numbersArray).mapToInt(Integer::parseInt).sum();
    }

    private static String[] removeNewLine(String numberToAdd) {
        if (numberToAdd.startsWith("//")) {
            numberToAdd = numberToAdd.replace("//", "\n");
        }

        numberToAdd = numberToAdd.replaceAll("[,\\n;`^|#@$%&*()!\\t]+", ",").replaceAll("^,|,$", "");
        String[] separateNum = numberToAdd.split(",");
        return separateNum;
    }

    private static void isNegative(String[] numbersArray) {
        List<Integer> integers = Arrays.stream(numbersArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        integers = integers.stream().filter(negativeNum -> negativeNum < 0)
                .collect(Collectors.toList());
        if (!integers.isEmpty()) {
                throw new IllegalArgumentException("negative numbers not allowed " + integers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
