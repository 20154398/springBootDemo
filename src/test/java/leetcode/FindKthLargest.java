package leetcode;

import org.junit.jupiter.api.Test;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int temp;
        do {
            findMax(nums, len--);
            temp = nums[len];
            nums[len] = nums[0];
            nums[0] = temp;
            k--;
        } while (k > 0);
        return nums[len];
    }

    public void findMax(int[] nums, int len) {
        int temp;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > nums[(i - 1) / 2]) {
                temp = nums[i];
                nums[i] = nums[(i - 1) / 2];
                nums[(i - 1) / 2] = temp;
            }
        }
    }

    @Test
    public void main() {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        findKthLargest(nums, 4);
    }
}
