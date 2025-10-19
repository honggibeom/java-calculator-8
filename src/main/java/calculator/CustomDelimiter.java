package calculator;

public class CustomDelimiter implements Delimiter {
    String pattern;

    public CustomDelimiter(String pattern) {
        this.pattern = "("+pattern+"|,|:)";
    }

    @Override
    public String extractNumbers(String str){
        return str.substring(str.indexOf("\\n")+2).replaceAll(this.pattern," ");
    }
}
