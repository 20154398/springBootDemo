package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DivingBoard {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{shorter * k};
        int[] res = new int[k];
        for (int i = 0; i <= k; i++) {
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
    }

    @Test
    public void main() {
        divingBoard(1, 1, 0);
        divingBoard(1, 1, 2);
        divingBoard(1, 2, 3);
    }
}
