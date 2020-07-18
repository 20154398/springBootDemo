package leetcode;

public class NumSub {
    public int numSub(String s) {
        int len = s.length();
        int l = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                l++;
                l %= 1000000007;
                res += l;
                res %= 1000000007;
            } else {
                l = 0;
            }
        }
        return res;
    }
}
