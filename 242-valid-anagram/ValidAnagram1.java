import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram1 {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        for(int i = 0; i < sa.length; i++) {
            if(sa[i] != ta[i]) {
                return false;
            }
        }
        return true;
    }
}

// time-complexity = O (nlogn)
// space-complexity = O(1)