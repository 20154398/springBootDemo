package leetcode;

/**
 * @author tangyuan
 * @date 2020/11/3
 * 941. 有效的山脉数组
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int size = A.length;
        if (size == 1) return false;
        int l = 0;
        int r = size - 1;
        while (l < size - 2 && A[l] < A[l + 1]) l++;
        while (r > 1 && A[r] < A[r - 1]) r--;
        return l == r;
    }
}
