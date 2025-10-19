package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String str = Console.readLine();
        DelimiterStrategy delimiterStrategy  = new DelimiterStrategy();
        delimiterStrategy.setStrategy(DelimiterStrategyFactory.create(str));

        String numbers =  delimiterStrategy.extractNumbers(str);

        Validator.doValidation(numbers, str);

        int result = Calculator.sum(numbers);
        System.out.println("결과 : "+result);
    }
}