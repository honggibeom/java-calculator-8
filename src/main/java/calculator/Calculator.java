package calculator;

public class Calculator {
    public static int sum(String str) {
        int sum = 0;
        for (String num : str.split(" ")) {
            if (!num.isBlank()) sum += Integer.parseInt(num);
        }
        return sum;
    }
}
