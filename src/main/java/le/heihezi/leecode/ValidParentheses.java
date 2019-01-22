package le.heihezi.leecode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String string1 = "()";
        String string2 = "()[]{}";
        String string3 = "(]";
        String string4 = "()[]{}";
        String string5 = "{[]}";
        ValidParenthesesSolution solution = new ValidParenthesesSolution();
        System.out.println(solution.isValid(string1));
        System.out.println(solution.isValid(string2));
        System.out.println(solution.isValid(string3));
        System.out.println(solution.isValid(string4));
        System.out.println(solution.isValid(string5));
    }


}

class ValidParenthesesSolution {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>(6){{
        put('{', 1);
        put('}', 6);
        put('[', 3);
        put(']', 4);
        put('(', 5);
        put(')', 2);
    }};
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.isEmpty()){
                stack.push(map.get(aChar));
                continue;
            }
            Integer integer = stack.lastElement();
            if (integer+map.get(aChar)==7){
                stack.pop();
            }else {
                stack.push(map.get(aChar));
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}