import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> seenElements = new HashSet<>();
        for(int item: nums) {
            if(seenElements.contains(item)) {
                return true;
            }
            seenElements.add(item);
        }
        return false;
    }
}

// time-complexity = O(n)
// space-complexity = O(n)
