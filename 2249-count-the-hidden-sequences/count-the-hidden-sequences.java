public class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long prefixSum = 0;
        long minPrefix = 0, maxPrefix = 0;

        for (int diff : differences) {
            prefixSum += diff;
            minPrefix = Math.min(minPrefix, prefixSum);
            maxPrefix = Math.max(maxPrefix, prefixSum);
        }

        long range = (upper - lower) - (maxPrefix - minPrefix);
        return (int)Math.max(0, range + 1);
    }
}
