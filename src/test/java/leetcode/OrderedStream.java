package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 唐源
 * @date 2020/11/27
 */
public class OrderedStream {
    String[] values;
    Boolean[] visit;

    int ptr;
    int len;

    boolean canGet;

    public OrderedStream(int n) {
        values = new String[n + 1];
        visit = new Boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            visit[i] = false;
        }
        ptr = 1;
        len = n + 1;
        canGet = true;
    }

    public List<String> insert(int id, String value) {
        values[id] = value;
        visit[id] = true;
        if (id == 1) canGet = false;
        return canGet ? new ArrayList<>() : getRes(id);
    }

    private List<String> getRes(int id) {
        List<String> res = new ArrayList<>(len);
        while (ptr < len && visit[ptr]) {
            res.add(values[ptr]);
            ptr++;
        }
        return res;
    }
}
