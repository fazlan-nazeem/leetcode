import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParantheses {

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i< s.length(); i++){
            char current = s.charAt(i);
            if(current == '(' || current == '[' || current == '{' ) {
                stack.push(current);
            } else{
                if(!stack.isEmpty()){
                    char popped = stack.pop();
                    if(popped != map.get(current)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

// time = O(n)
// space = O(n)