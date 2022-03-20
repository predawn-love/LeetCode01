package microsoft;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Q20IsValid {
    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};
    public boolean isValid0(String s) {
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }





    static Map<Character, Character> leftVsRight;
    static {
        leftVsRight = new HashMap<>();
        leftVsRight.put('(', ')');
        leftVsRight.put('[', ']');
        leftVsRight.put('{', '}');
        leftVsRight.put('?', '?');
    }

    public boolean isValid(String input) {
        char[] cs = input.toCharArray();
        LinkedList<Character> stack = new LinkedList();
        stack.push('?');
        for (char c : cs) {
            if (leftVsRight.containsKey(c)) {
                stack.push(c);
            } else if (leftVsRight.get(stack.pop()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }
}
