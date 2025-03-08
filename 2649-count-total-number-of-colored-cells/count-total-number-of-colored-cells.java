class Solution {
    public long coloredCells(int n) {
        return 1L + 4L * (n - 1) * n / 2;
    }
}