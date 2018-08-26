package Base;

import java.util.Stack;

/**
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char x = s.charAt(i);
            if(x=='('||x=='{'||x=='['){
                stack.push(x);
            }else{
                try {
                    char c = stack.peek();
                    if ((c == '(' && x == ')') || (x == ']' && c == '[') || (x == '}' && c == '{')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }catch (Exception e){
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }else{
            return false;
        }
    }
}
