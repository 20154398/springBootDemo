package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 唐源
 * @date 2020/11/27
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 */
public class MinOperations {

    private int[][] help;

    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int[] sum = new int[nums.length + 1];
        help = new int[len + 1][len + 1];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < len + 1; j++) {
                help[i][j] = Integer.MAX_VALUE;
            }
        }
        sum[0] = 0;
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        if (sum[len] < x) return -1;
        int res = help(sum, 0, len, len, x);
        return res != Integer.MIN_VALUE ? res : -1;
    }

    private int help(int[] sum, int l, int r, int len, int x) {
        if (help[l][r] != Integer.MAX_VALUE) return help[l][r];
        if (l > len || r < 0) return Integer.MIN_VALUE;
        if (sum[l] + sum[len] - sum[r] == x) {
            return help[l][r] = 0;
        } else if (sum[l] + sum[len] - sum[r] < x) {
            int num1 = help(sum, l + 1, r, len, x);
            int num2 = help(sum, l, r - 1, len, x);
            if (num1 == Integer.MIN_VALUE && num2 == Integer.MIN_VALUE) {
                return help[l][r] = Integer.MIN_VALUE;
            } else if (num1 != Integer.MIN_VALUE && num2 == Integer.MIN_VALUE) {
                return help[l][r] = num1 + 1;
            } else if (num1 == Integer.MIN_VALUE) {
                return help[l][r] = num2 + 1;
            } else {
                return help[l][r] = Math.min(num1, num2) + 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    @Test
    public void main() {
        minOperations(new int[]{1, 1, 4, 2, 3}, 5);
    }
}
