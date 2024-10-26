import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {


    public static int addition(String numbersToAdd) {
        if (numbersToAdd.isEmpty()) {
            return 0;
        }

        String[] numbersArray = removeNewLine(numbersToAdd);
        List<Integer> negative = isNegative(numbersArray);
        if(!negative.isEmpty()){
            throw new IllegalArgumentException("negative numbers not allowed "+negative.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }

        return Arrays.stream(numbersArray).mapToInt(Integer::parseInt).sum();
    }

    private static String[] removeNewLine(String numberToAdd) {
        if (numberToAdd.startsWith("//")) {
            numberToAdd = numberToAdd.replace("//", "\n");
        }
        numberToAdd = numberToAdd.replaceAll("[,\\n;`^|#@$%&*()!\\t]+", ",").replaceAll("^,|,$", "");
        String[] separateNum = numberToAdd.split("[,\\n]");
        return separateNum;
    }

    private static List<Integer> isNegative(String[] numbersArray) {
        List<Integer> integers = Arrays.stream(numbersArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        integers = integers.stream().filter(negativeNum -> negativeNum < 0)
                .collect(Collectors.toList());
        if (!integers.isEmpty()) {
            return integers;
        }else {
            return null;
        }
    }
}
