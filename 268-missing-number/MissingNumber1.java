public class MissingNumber1 {
    public int missingNumber(int[] nums) {

        int total = 0;
        for(int num: nums) {
            total += num;
        }
        int expected = ((nums.length + 1) * (nums.length))/2;
        return expected - total;
    }
}

// time-complexity = O(n)
// space-complexity = O(1)