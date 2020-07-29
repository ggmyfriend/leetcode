package Base;

/**
 * @author gkf
 * @date 2020 - 07 -29
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfPhoneNumber {
    public static final Map<Integer,String> phone = new HashMap<>();
    static{
        phone.put(2,"abc");
        phone.put(3,"def");
        phone.put(4,"ghi");
        phone.put(5,"jkl");
        phone.put(6,"mno");
        phone.put(7,"pqrs");
        phone.put(8,"tuv");
        phone.put(9,"wxyz");
    }
    public static List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        String number = digits.substring(0,1);
        String text = phone.get(Integer.valueOf(number));
        if(digits.length() == 1){
            List<String> list = new ArrayList<>();
            for(char c : text.toCharArray()){
                list.add(c+"");
            }
            return list;
        }else{
            List<String> resultString = letterCombinations(digits.substring(1));
            List<String> list = new ArrayList<>();
            for(String s : resultString){
                for(char c : text.toCharArray()){
                    list.add(c+s);
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23456"));
    }
}
