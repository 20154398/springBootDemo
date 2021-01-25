package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author tangyuan
 * @date 2020/11/2
 */
public class Intersection {
    //给定两个数组，编写一个函数来计算它们的交集。
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        Map<Integer, Integer> help = new HashMap<>(((nums1.length + nums2.length) / 16 + 1) * 16);
        for (int i : nums1) {
            help.put(i, 1);
        }
        for (int i : nums2) {
            if (Objects.nonNull(help.get(i)) && help.get(i) == 1) {
                help.put(i, 2);
            }
        }
        return help.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    @Test
    public void test() {
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};

        intersection(num1, num2);
    }
}
