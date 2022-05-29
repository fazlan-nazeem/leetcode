// Dynamic Programming

public class MaximumSubarray2 {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int[] largest = new int[nums.length];
        largest[0] = nums[0];
        for(int i= 1; i< largest.length; i++) {
            largest[i] = Math.max(largest[i-1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, largest[i]);
        }
        return maxSum;
    }
}

// time-complexity = O(n)
// space-complexity = O(1)