// Greedy method

class MaximumSubarray1 {
    public int maxSubArray(int[] nums) {
        
        int currentSum = 0;
        int maxSum = nums[0];
        for(int i = 0; i< nums.length; i++) {

            if(currentSum < 0) {
                currentSum = 0;
            }
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}

// time-complexity = O(n)
// space-complexity = O(1)