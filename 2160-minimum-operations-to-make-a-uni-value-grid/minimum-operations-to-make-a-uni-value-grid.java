import java.util.*;

public class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[] arr = new int[size];
        int index = 0;
        
        for (int[] row : grid) {
            for (int num : row) {
                arr[index++] = num;
            }
        }

        int remainder = arr[0] % x;
        for (int num : arr) {
            if (num % x != remainder) return -1;
        }

        Arrays.sort(arr);
        int median = arr[size / 2], operations = 0;
        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}
