import java.util.List;
import java.util.Stack;

public class LC20_ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]{}";
        LC20_ValidParentheses m = new LC20_ValidParentheses();
        boolean result = m.isValid(s);
        System.out.println(result);
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return true;
    }
}
