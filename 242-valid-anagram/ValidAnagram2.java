import java.util.HashMap;
import java.util.Map;

public class ValidAnagram2 {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for(char c : sMap.keySet()) {
            if(!sMap.get(c).equals(tMap.get(c))) { //use equals for value matching
                return false;
            }
        }
        return true;
    }
}
// time-complexity = O(n)
// space-complexity = O(n)