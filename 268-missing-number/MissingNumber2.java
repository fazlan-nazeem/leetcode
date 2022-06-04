public class MissingNumber2 {

    public int missingNumber(int[] nums) {

        int xor = 0;
        for(int i = 0; i <= nums.length; i++) {
            xor ^= i ;
        }

        for(int i=0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        return xor;
    }
}

// time-complexity = O(n)
// space-complexity = O(1)