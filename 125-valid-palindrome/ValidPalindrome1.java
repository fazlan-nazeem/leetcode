
public class ValidPalindrome1 {

    // This solution does NOT use two pointers
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isLetterOrDigit(current)) {
                sb.append(current);
            }
        }
        sb = new StringBuilder(sb.toString().toLowerCase());   // toLowerCase() can be done only on a String
        if (sb.toString().equals(sb.reverse().toString())) {  // reverse() is supported only on a StringBuilder
            return true;
        }
        return false;
    }
}

// time = O(n)
// space = O(n)