package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author 唐源
 * @date 2020/12/10
 */
public class IsToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 1; i < n + m - 1; i++) {
            int temp = 0;
            int n1 = 0;
            int m1 = 0;
            if (i < n) {
                temp = matrix[n - 1 - i][0];
                n1 = n - 1 - i;
            } else {
                temp = matrix[0][i + 1 - n];
                m1 = i + 1 - n;
            }
            while (n1 >= 0 && n1 < n && m1 >= 0 && m1 < m) {
                if (matrix[n1][m1] == temp) {
                    n1++;
                    m1++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void main() {
        int[][] matrix = new int[][]{{1,2,3,4}, {5,1,2,3},{9,5,1,2}};
        isToeplitzMatrix(matrix);
    }
}
