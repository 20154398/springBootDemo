package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MakeGood {
    public String makeGood(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        for (int i = len - 1; i > 0; i--) {
            char c1 = cs[i];
            char c2 = cs[i - 1];
            if (c1 - c2 == 32 || c2 - c1 == 32) {
                cs[i] = '0';
                cs[i - 1] = '0';
                i--;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if (cs[i] != '0') {
                sb.append(cs[i]);
            }
        }
        return sb.toString().length() == s.length() ? s : makeGood(sb.toString());
    }

    @Test
    public void main() {
        makeGood("NROornwPFOBbofpWMm");
    }
}
