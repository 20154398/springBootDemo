package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author 唐源
 * @date 2020/12/2
 */
public class MostCompetitive {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        int len = nums.length;
        if (len == k) return nums;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i] && stack.size() + len > k + i) {
                stack.pop();
            }
            if (stack.isEmpty()) stack.push(nums[i]);
            else if (stack.size() + len == k + i) {
                while (i < len) {
                    stack.push(nums[i++]);
                }
                break;
            } else {
                stack.push(nums[i]);
            }
        }
        while (stack.size() > k) {
            stack.pop();
        }
        for (int i = 0; i < k; i++) {
            res[k - 1 - i] = stack.pop();
        }
        return res;
    }

    @Test
    public void main() {
        int[] temp = {71,18,52,29,55,73,24,42,66,8,80,2};

        mostCompetitive(temp, 3);

        String temp2 = "adwq";
        char[] temp3 = temp2.toCharArray();

    }
}
