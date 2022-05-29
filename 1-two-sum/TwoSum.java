
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        // The hashmap stores <value, index>
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(seen.containsKey(target - nums[i])) {
                return new int[]{i, seen.get(target-nums[i])};
            }
            seen.put(nums[i], i);
        }
        return null;
    }
}

// time-complexity = O(n)
// space-complexity = O(n)