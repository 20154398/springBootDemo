package leetcode;

/**
 * @author 唐源
 * @date 2020/12/15
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > nums[i]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i - 1] < nums[i]) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][1] = dp[i - 1][1];
                dp[i][0] = dp[i - 1][0];
            }
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }

}
