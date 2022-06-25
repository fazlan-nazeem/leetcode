import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// This implementation uses two separate hashmaps to track what's needed and what we have
public class MinimumWindowSubstring1 {

    public String minWindow(String s, String t) {

        //populate 'need' hashmap with character counts in t
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> have = new HashMap<>();
        Set<Character> matched = new HashSet<>();
        int minLength = Integer.MAX_VALUE;
        int[] indexes = new int[2];
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (need.containsKey(current)) { // ignore all characters not in 'need' map
                have.put(current, have.getOrDefault(current, 0) + 1);
                if (have.get(current) >= need.get(current)) {
                    matched.add(current);
                }
            }
            while (left <= right && matched.size() == need.size()) {
                if (right - left + 1 < minLength) {
                    indexes[0] = left;
                    indexes[1] = right;
                    minLength = right - left + 1;
                }
                char leftChar = s.charAt(left);
                if (have.get(leftChar) != null) {
                    int count = have.get(leftChar);
                    if (count == 1) {
                        have.remove(leftChar);
                        matched.remove(leftChar);
                    } else {
                        have.put(leftChar, count - 1);
                        if (have.get(leftChar) < need.get(leftChar)) {
                            matched.remove(leftChar);
                            System.out.println("Removing " + leftChar);
                        }
                    }
                }
                left++;
            }

        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(indexes[0], indexes[1] + 1);
    }
}

// time-complexity = O(n)
// space-complexity = O(n)