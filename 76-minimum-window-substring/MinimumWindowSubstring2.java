import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring2 {

    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int matched = 0;
        int minLength = s.length() + 1;
        int start = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0) {
                    matched++;
                }
            }
            while (matched == map.size()) {
                if (right - left + 1 < minLength) {
                    start = left;
                    minLength = right - left + 1;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                left++;
            }
        }
        return (minLength == s.length() + 1) ? "" : s.substring(start, start + minLength);
    }
}

// time-complexity = O(n)
// space-complexity = O(n)