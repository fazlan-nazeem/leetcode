import java.util.ArrayDeque;

public class PlusOne2 {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int carry = 1;
        for(int i = size -1 ; i >= 0; i--) {
            int sum = digits[i] + carry;
            if(sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            stack.push(sum%10);
        }

        if(carry == 1) {
            stack.push(1);
        }

        int[] ans = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()) {
            ans[i] = stack.pop();
            i++;
        }

        return ans;
    }
}

// time-complexity = O(n)
// space-complexity = O(n)