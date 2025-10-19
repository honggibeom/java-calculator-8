package calculator;

public class DelimiterStrategyFactory {
    public static Delimiter create(String str){
        if(str.length()>5 && str.startsWith("//") &&str.indexOf("\\n")>=3)
            return new CustomDelimiter(str.substring(2,str.indexOf("\\n")));
        return new DefaultDelimiter();
    }
}
