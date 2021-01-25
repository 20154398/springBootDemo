package leetcode;

/**
 * @author 唐源
 * @date 2020/12/15
 */
public class LastSubstring {
    public String lastSubstring(String s) {
        int left = 0;
        int right = left + 1;
        int step = 0;
        while(right + step < s.length()){
            if(s.charAt(left + step) < s.charAt(right + step)){
                left = right;
                right++;
                step = 0;
            }else if(s.charAt(left + step) == s.charAt(right + step)){
                step++;
            }else{
                right += step + 1;
                step = 0;
            }

        }
        return s.substring(left);
    }
}
