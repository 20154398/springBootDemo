package leetcode;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class FirstMissingPositive {
    //2020/06/27
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return len + 1;
    }

    @Test
    public void main() {
        int[] nums = {3,4,-1,1};
        firstMissingPositive(nums);
    }
}
