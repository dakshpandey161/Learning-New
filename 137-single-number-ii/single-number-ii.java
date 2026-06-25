class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        
        for (int num : nums) // 'ones' holds bits that are odd number of times
        {
            ones = (ones ^ num) & ~twos;
            
            // twos holds bits that have appeared a multiple of 2 time
            twos = (twos ^ num) & ~ones;
        }
        
        return ones;
    }
}