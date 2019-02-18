package Base;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        ArrayList<String> stack = new ArrayList<>();
        generateRecursion(n,"",stack);
        return list;
    }
    private void generateRecursion(int n,String result,ArrayList<String> stack){
        if(n==0){
            for(String s : stack){
                result += s;
            }
            list.add(result);
        }
        else{
            ArrayList<String> temp = new ArrayList<>(stack);
            if(stack.size()>0) {
                temp.remove(0);
                generateRecursion(n, result + ")", temp);
                temp.add(")");
            }
            temp.add(")");
            generateRecursion(n-1,result+"(",temp);
        }
    }
    public static void main(String[] args){
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(3);
        System.out.println(list);
    }
}
