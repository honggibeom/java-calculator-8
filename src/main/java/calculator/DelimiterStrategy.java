package calculator;

public class DelimiterStrategy {
    Delimiter delimiter;
    void setStrategy(Delimiter delimiter){
        this.delimiter = delimiter;
    }
    String extractNumbers(String str){
        return  this.delimiter.extractNumbers(str);
    }
}
