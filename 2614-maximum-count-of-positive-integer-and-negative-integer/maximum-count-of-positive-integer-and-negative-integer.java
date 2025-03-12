class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;

        for (int num : nums) {
            if (num > 0) pos++;
            else if (num < 0) neg++;
        }

        return Math.max(pos, neg);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {-2, -1, -1, 1, 2, 3};
        System.out.println(solution.maximumCount(nums1)); // Output: 3

        int[] nums2 = {-3, -2, -1, 0, 0, 1, 2};
        System.out.println(solution.maximumCount(nums2)); // Output: 3

        int[] nums3 = {5, 20, 66, 1314};
        System.out.println(solution.maximumCount(nums3)); // Output: 4
    }
}