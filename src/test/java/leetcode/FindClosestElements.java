package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 唐源
 * @date 2020/12/9
 */
public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>(k);
        int len = arr.length;
        if (k == len) return Arrays.stream(arr).boxed().collect(Collectors.toList());
        if (arr[0] > x) {
            for (int i = 0; i < k; i++) {
                res.add(arr[i]);
            }
        } else if (arr[len - 1] < x) {
            for (int i = len - k; i < len; i++) {
                res.add(arr[i]);
            }
        } else {
            int l = 0, r = len - 1;
            for (int i = 1; i < len; i++) {
                if (arr[i - 1] < x && x <= arr[i] || arr[i - 1] <= x && x < arr[i]) {
                    l = i - 1;
                    r = i;
                    break;
                }
            }
            boolean canLeft = true;
            boolean canRight = true;
            for (int i = 0; i < k; i++) {
                if (canLeft && canRight) {
                    if (x - arr[l] <= arr[r] - x) {
                        res.add(arr[l]);
                        l--;
                        if (l < 0) {
                            l = 0;
                            canLeft = false;
                        }
                    } else {
                        res.add(arr[r]);
                        r++;
                        if (r > len - 1) {
                            r = len - 1;
                            canRight = false;
                        }
                    }
                } else if (canLeft) {
                    res.add(arr[l]);
                    l--;
                    if (l < 0) {
                        l = 0;
                        canLeft = false;
                    }
                } else if (canRight) {
                    res.add(arr[r]);
                    r++;
                    if (r > len - 1) {
                        r = len - 1;
                        canRight = false;
                    }
                }
            }
        }
        res.sort(Comparator.comparingInt(a -> a));
        return res;
    }

    @Test
    public void main() {
        int[] nums = {1,1,2,3,3,3,4,6,8,8};
        findClosestElements(nums, 6, 1);
    }
}
