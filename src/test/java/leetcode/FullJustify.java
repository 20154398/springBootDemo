package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author 唐源
 * @date 2020/12/9
 */
public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> wordList = Arrays.stream(words).collect(Collectors.toList());
        int len = words.length;
        int[] lens = new int[len];
        for (int i = 0; i < len; i++) {
            lens[i] = words[i].length();
        }
        List<String> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack.push(-1);
        stack2.push(0);
        for (int l : lens) {
            int lastLen = stack.peek();
            if (lastLen + l + 1 <= maxWidth) {
                int num = stack2.pop();
                stack2.push(num + 1);
                num = stack.pop();
                stack.push(num + l + 1);
            } else {
                stack.push(l);
                stack2.push(1);
            }
        }
        int sum = 0;
        if (!stack2.isEmpty()) {
            int num1 = stack2.pop();
            sum += num1;
            List<String> list = wordList.subList(len - sum, len - sum + num1);
            int num2 = stack.pop();
            StringBuilder resTemp = new StringBuilder();
            resTemp.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                resTemp.append(" ");
                resTemp.append(list.get(i));
            }
            for (int k = 0; k < maxWidth; k++) {
                resTemp.append(" ");
            }
            res.add(resTemp.substring(0, maxWidth));
        }
        while (!stack2.isEmpty()) {
            int num1 = stack2.pop();
            sum += num1;
            List<String> list = wordList.subList(len - sum, len - sum + num1);
            int num2 = stack.pop();
            StringBuilder resTemp = new StringBuilder();
            if (num1 == 1) {
                resTemp.append(list.get(0));
                for (int k = 0; k < maxWidth; k++) {
                    resTemp.append(" ");
                }
            } else {
                int x = maxWidth - num2 + list.size() - 1;
                int y = list.size() - 1;
                int m = x / y;
                int n = x % y;
                resTemp.append(list.get(0));
                for (int i = 1; i < list.size(); i++) {
                    for (int k = 0; k < m; k++) {
                        resTemp.append(" ");
                    }
                    if (i <= n){
                        resTemp.append(" ");
                    }
                    resTemp.append(list.get(i));
                }
            }
            res.add(resTemp.substring(0, maxWidth));
        }
        Collections.reverse(res);
        return res;
    }

    @Test
    public void main() {
        String[] temp = {"This", "is", "an", "example", "of", "text", "justification."};
        fullJustify(temp, 16);
    }
}
