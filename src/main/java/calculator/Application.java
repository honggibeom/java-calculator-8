package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String str = Console.readLine();
        DelimiterStrategy delimiterStrategy  = new DelimiterStrategy();
        delimiterStrategy.setStrategy(DelimiterStrategyFactory.create(str));

        String numbers =  delimiterStrategy.extractNumbers(str);

        if(!Validator.isValid(numbers, str)) {
            throw new IllegalArgumentException();
        }

        int result = Calculator.sum(numbers);
        System.out.println("결과 : "+result);
    }
}