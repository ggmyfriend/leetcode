package Base;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            Integer las,pre;
            switch (s) {
                case "-":
                    pre = stack.pop();
                    las = stack.pop();
                    stack.push(las - pre);
                    break;
                case "+":
                    pre = stack.pop();
                    las = stack.pop();
                    stack.push(las + pre);
                    break;
                case "*":
                    pre = stack.pop();
                    las = stack.pop();
                    stack.push(las * pre);
                    break;
                case "/":
                    pre = stack.pop();
                    las = stack.pop();
                    stack.push(las / pre);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }
}