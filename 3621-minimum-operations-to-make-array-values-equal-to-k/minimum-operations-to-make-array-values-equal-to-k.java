import java.util.*;

public class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            if (num < k) return -1;
        }

        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            if (num >= k) unique.add(num);
        }

        List<Integer> sorted = new ArrayList<>(unique);
        Collections.sort(sorted, Collections.reverseOrder());

        int operations = 0;
        for (int i = 0; i < sorted.size(); i++) {
            int val = sorted.get(i);
            if (val == k) break;
            operations++;
        }

        return operations;
    }
}
