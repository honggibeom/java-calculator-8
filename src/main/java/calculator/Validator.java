package calculator;

public class Validator {
    static void doValidation(String str, String origin){
        boolean hasCustomDelimiter =  origin.startsWith("//")&&origin.indexOf("\\n")>=3
                &&!origin.substring(2,origin.indexOf("\\n")).matches(".*[0-9].*");
        boolean isDefaultDelimiter = origin.charAt(0)>='0'&&origin.charAt(1)<='9';

        if(!hasCustomDelimiter&&!isDefaultDelimiter) {
            throw new IllegalArgumentException();
        }
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(ch!=' '&&(ch>'9'||ch<'0'))
                throw new IllegalArgumentException();
        }
    }
}
