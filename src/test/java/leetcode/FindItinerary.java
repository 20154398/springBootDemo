package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author 唐源
 * @date 2020/12/10
 * <p>
 * 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 */
public class FindItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> help = new HashMap<>();
        tickets.forEach(ticket -> {
            PriorityQueue<String> ticketsFrom = help.getOrDefault(ticket.get(0), new PriorityQueue<>());
            ticketsFrom.add(ticket.get(1));
            help.put(ticket.get(0), ticketsFrom);
        });
        List<String> res = new ArrayList<>();
        String cur = "JFK";
        res.add(cur);
        //贪心、每次都飞最优
        for (int i = 0; i < tickets.size(); i++) {
            String pre = help.get(cur).poll();
            //如果飞最近的点的出度为0，就不能飞，只能选第二优（一定是第二优）
            if (help.getOrDefault(pre, new PriorityQueue<>()).size() == 0 && i != tickets.size() - 1) {
                String temp = pre;
                pre = help.get(cur).poll();
                //如果没有第二优，长度也不够的话，说明有非最优的环
                if (pre == null) {
                    pre = temp;
                    res.add(pre);
                    break;
                } else {
                    help.get(cur).add(temp);
                }
            }
            res.add(pre);
            cur = pre;
        }
        //一次只处理一个环
        while (res.size() != tickets.size() + 1) {
            res = doCyc(res, help);
        }
        return res;
    }

    private List<String> doCyc(List<String> res, Map<String, PriorityQueue<String>> help) {
        List<String> resTemp = new ArrayList<>();
        int i;
        for (i = res.size() - 1; i >= 0; i--) {
            String curNode = res.get(i);
            if (help.get(curNode) == null || help.get(curNode).size() == 0) {
                resTemp.add(curNode);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(curNode);
                String pre;
                while (help.get(curNode).size() != 0 && (pre = help.get(curNode).poll()) != null) {
                    temp.add(pre);
                    curNode = pre;
                }
                Collections.reverse(temp);
                resTemp.addAll(temp);
                break;
            }
        }
        for (i = i - 1; i >= 0; i--) {
            resTemp.add(res.get(i));
        }
        Collections.reverse(resTemp);
        return resTemp;
    }

    @Test
    public void main() {
        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(Arrays.asList("MUC", "LHR"));
//        tickets.add(Arrays.asList("JFK", "MUC"));
//        tickets.add(Arrays.asList("SFO", "SJC"));
//        tickets.add(Arrays.asList("LHR", "SFO"));

//        tickets.add(Arrays.asList("JFK", "SFO"));
//        tickets.add(Arrays.asList("JFK", "ATL"));
//        tickets.add(Arrays.asList("SFO", "ATL"));
//        tickets.add(Arrays.asList("ATL", "JFK"));
//        tickets.add(Arrays.asList("ATL", "SFO"));

//        tickets.add(Arrays.asList("JFK","ATL"));
//        tickets.add(Arrays.asList("ATL","JFK"));

//        tickets.add(Arrays.asList("JFK","KUL"));
//        tickets.add(Arrays.asList("JFK","NRT"));
//        tickets.add(Arrays.asList("NRT","JFK"));


        tickets.add(Arrays.asList("EZE", "TIA"));
        tickets.add(Arrays.asList("EZE", "HBA"));
        tickets.add(Arrays.asList("AXA", "TIA"));
        tickets.add(Arrays.asList("JFK", "AXA"));
        tickets.add(Arrays.asList("ANU", "JFK"));
        tickets.add(Arrays.asList("ADL", "ANU"));
        tickets.add(Arrays.asList("TIA", "AUA"));
        tickets.add(Arrays.asList("ANU", "AUA"));
        tickets.add(Arrays.asList("ADL", "EZE"));
        tickets.add(Arrays.asList("ADL", "EZE"));
        tickets.add(Arrays.asList("EZE", "ADL"));
        tickets.add(Arrays.asList("AXA", "EZE"));
        tickets.add(Arrays.asList("AUA", "AXA"));
        tickets.add(Arrays.asList("JFK", "AXA"));
        tickets.add(Arrays.asList("AXA", "AUA"));
        tickets.add(Arrays.asList("AUA", "ADL"));
        tickets.add(Arrays.asList("ANU", "EZE"));
        tickets.add(Arrays.asList("TIA", "ADL"));
        tickets.add(Arrays.asList("EZE", "ANU"));
        tickets.add(Arrays.asList("AUA", "ANU"));

        findItinerary(tickets);
    }
}
