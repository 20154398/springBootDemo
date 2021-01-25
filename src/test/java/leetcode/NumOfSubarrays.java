package leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author 唐源
 * @date 2020/12/15
 */
public class NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int[] sum = new int[arr.length + 1];
        sum[0] = 0;
        for (int i = 1; i < arr.length + 1; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        for (int i = 1; i < arr.length + 1 - k; i++) {
            if (sum[i + k] - sum[i] >= threshold * k) {
                res++;
            }
        }
        return res;
    }

    public int f(int[] arr, int k, int threshold){
        int res = 0;
        for (int i = 0; i < arr.length - k; i++) {
            if (Arrays.stream(arr).skip(i).limit(k).sum() >= threshold * k) {
                res++;
            }
        }
        return res;
    }
}
