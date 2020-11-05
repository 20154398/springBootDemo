package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author tangyuan
 * @date 2020/11/5
 * 57. 插入区间
 */
public class LadderLength {
    Map<String, Integer> wordId = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        addWord(beginWord);
        wordList.forEach(this::addWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        for (String end : wordList) {
            if (canEdge(beginWord, end)) {
                edge.get(wordId.get(beginWord)).add(wordId.get(end));
                edge.get(wordId.get(end)).add(wordId.get(beginWord));
            }
        }
        for (String begin : wordList) {
            for (String end : wordList) {
                if (canEdge(begin, end)) {
                    edge.get(wordId.get(begin)).add(wordId.get(end));
                    edge.get(wordId.get(end)).add(wordId.get(begin));
                }
            }
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;

    }

    private boolean canEdge(String begin, String end) {
        if (begin.length() != end.length()) {
            return false;
        }
        int len = begin.length();
        int help = 0;
        char[] begins = begin.toCharArray();
        char[] ends = end.toCharArray();
        for (int i = 0; i < len; i++) {
            help += begins[i] == ends[i] ? 0 : 1;
        }
        return help == 1;
    }

    private void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }

    @Test
    public void test() {
        ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

    }
}
