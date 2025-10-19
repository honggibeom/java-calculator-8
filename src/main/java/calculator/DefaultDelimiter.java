package calculator;

public class DefaultDelimiter implements Delimiter {
    @Override
    public String extractNumbers(String str){
        return str.replaceAll("(,|:)"," ");
    }
}
