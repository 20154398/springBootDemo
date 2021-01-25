package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 唐源
 * @date 2020/12/23
 */
public class FindRelativeRanks {
    public static String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> help = new HashMap<>(1 + len * 4 / 3);
        for (int i = 0; i < len; i++) {
            help.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] res = new String[len];
        for (int i = 0; i < len; i++) {
            res[help.get(nums[i])] = "" + (len - i);
        }
        for (int i = 0; i < len; i++) {
            switch (res[i]) {
                case "1":
                    res[i] = "Gold Medal";
                    break;
                case "2":
                    res[i] = "Silver Medal";
                    break;
                case "3":
                    res[i] = "Bronze Medal";
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        findRelativeRanks(nums);
    }
}
