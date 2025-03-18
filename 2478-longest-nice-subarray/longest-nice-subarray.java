class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLen = 0, andValue = 0, left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            while ((andValue & nums[right]) != 0) {
                andValue ^= nums[left];
                left++;
            }
            andValue |= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}