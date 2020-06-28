package leetcode;

import org.junit.jupiter.api.Test;

public class MinSubArrayLen {
    //2020/06/28
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = 0;
        int add = 0;
        int res = len + 1;
        while (r < len) {
            add += nums[r];
            while (add >= s) {
                res = Math.min(res, r - l + 1);
                add -= nums[l];
                l++;
            }
            r++;
        }
        return res == len + 1 ? 0 : res;
    }

    @Test
    public void main() {
        int[] nums = {2,3,1,2,4,3};
        minSubArrayLen(7,nums);
    }
}
