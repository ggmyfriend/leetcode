package Base;

public class IntegerToRoman {
    public static String[][] ROMAN = new String[][]{
        {"I","II","III","IV","V","VI","VII","VIII","IX"},
        {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        {"M","MM","MMM"}

    };
    public static String intToRoman(int num) {
        int tempNum = num;
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while(tempNum != 0){
            int tempIndex = tempNum % 10;
            if(tempIndex > 0) {
                stringBuilder.insert(0, ROMAN[index][tempIndex - 1]);
            }
            index++;
            tempNum = tempNum / 10;
        }
        return stringBuilder.toString();
    }
}
