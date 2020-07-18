package leetcode;

public class NumIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        int[] n = new int[101];
        for (int i = 0; i < n.length; i++) {
            n[i] = 0;
        }
        int res = 0;
        for (int i : nums) {
            res+=n[i];
            n[i]++;
        }
        return res;
    }
}
