package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tangyuan
 * @date 2020/11/2
 * 429
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.singletonList(root.val));
        List<Node> nodes;
        List<Node> temp = root.children;
        while ((nodes = temp).size() != 0) {
            temp = new ArrayList<>();
            List<Node> finalTemp = temp;
            res.add(nodes.stream().map(node -> {
                finalTemp.addAll(node.children);
                return node.val;
            }).collect(Collectors.toList()));
            temp = finalTemp;
        }
        return res;
    }
}
