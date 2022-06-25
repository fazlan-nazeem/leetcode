// Uses two pointer method.
public class ValidPalindrome2 {

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left <= right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
// time = O(n)
// space = O(1)