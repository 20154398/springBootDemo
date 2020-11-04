package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author tangyuan
 * @date 2020/11/4
 * 57. 插入区间
 */
public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval.length == 0) return new int[1][0];
        Map<Integer, Integer> help = new TreeMap();
        for (int[] interval : intervals) {
            help.put(interval[0], help.getOrDefault(interval[0], 0) + 1);
            help.put(interval[1], help.getOrDefault(interval[1], 0) - 1);
        }
        help.put(newInterval[0], help.getOrDefault(newInterval[0], 0) + 1);
        help.put(newInterval[1], help.getOrDefault(newInterval[1], 0) - 1);
        int i = 0;
        List<int[]> resTemp = new ArrayList<>();
        int[] temp = new int[2];
        for (Map.Entry<Integer, Integer> entry : help.entrySet()) {
            if (i == 0 && i + entry.getValue() == 0){
                temp[0] = entry.getKey();
                temp[1] = entry.getKey();
                resTemp.add(temp);
                temp = new int[2];
            }
            if (i <= 0 && i + entry.getValue() > 0) {
                temp[0] = entry.getKey();
            } else if (i > 0 && i + entry.getValue() <= 0) {
                temp[1] = entry.getKey();
                resTemp.add(temp);
                temp = new int[2];
            }
            i += entry.getValue();
        }
        int[][] res = new int[resTemp.size()][2];
        for (int j = 0; j < resTemp.size(); ++j) {
            res[j] = resTemp.get(j);
        }
        return res;
    }
}
