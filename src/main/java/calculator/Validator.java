package calculator;

public class Validator {
    static boolean isValid(String str, String origin){
        boolean hasCustomDelimiter =  origin.startsWith("//")&&origin.indexOf("\\n")>=3
                &&!origin.substring(2,origin.indexOf("\\n")).matches(".*[0-9].*");
        boolean isDefaultDelimiter = origin.charAt(0)>='0'&&origin.charAt(1)<='9';

        if(!hasCustomDelimiter&&!isDefaultDelimiter) {
            return false;
        }
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(ch!=' '&&(ch>'9'||ch<'0'))
                return false;
        }
        return true;
    }
}
