import java.util.ArrayList;
import java.util.List;

public class PlusOne1 {
    public int[] plusOne(int[] digits) {

        List<Integer> result = new ArrayList<>();
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            result.add(remainder);
        }
        if(carry > 0) {
            result.add(carry);
        }
        int[] resultArray = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(result.size() - 1 - i);
        }

        return resultArray;
    }
}

// time-complexity = O(n)
// space-complexity = O(n)