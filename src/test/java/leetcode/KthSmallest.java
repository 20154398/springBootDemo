package leetcode;

import org.junit.jupiter.api.Test;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int l = matrix[0][0];
        int r = matrix[len - 1][len - 1];
        while (l < r) {
            int m = l + ((r - l) / 2);
            if (check(matrix, m, k, len)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public boolean check(int[][] matrix, int m, int k, int len) {
        int i = len - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < len) {
            if (matrix[i][j] <= m) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    @Test
    public void main() {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        kthSmallest(matrix,8);
    }
}
