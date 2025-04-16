import java.util.*;

class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long res = 0, pairCount = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int count = freq.getOrDefault(nums[right], 0);
            pairCount += count;
            freq.put(nums[right], count + 1);

            while (pairCount >= k) {
                res += nums.length - right;
                int leftCount = freq.get(nums[left]);
                pairCount -= (leftCount - 1);
                freq.put(nums[left], leftCount - 1);
                left++;
            }
        }

        return res;
    }
}
