package leetcode;

/**
 * @author 唐源
 * @date 2020/12/4
 */
public class MaxRepeating {
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        String temp = word;
        while (word.length() < sequence.length()) {
            if (!sequence.contains(word)){
                break;
            }
            res++;
            word += temp;
        }
        return res;
    }
}
