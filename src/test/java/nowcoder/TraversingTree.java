package nowcoder;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class TraversingTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] strArr = str.split(" ");
            String pre = strArr[0];
            String mid = strArr[1];
            System.out.println(traversingTree(pre, mid));
        }
    }

    private static String traversingTree(String pre, String mid) {
        Queue<String> pQ = new LinkedList<>();
        Queue<String> mQ = new LinkedList<>();
        StringBuffer res = new StringBuffer();
        pQ.add(pre);
        mQ.add(mid);
        do {
            pre = pQ.poll();
            mid = mQ.poll();
            if (pre.length()==1){
                res.append(pre);
                continue;
            }
            String root = pre.substring(pre.length() - 1);
            res.append(root);
            int pos = mid.indexOf(root);
            if (pos != 0){
                pQ.add(pre.substring(0, pos));
                mQ.add(mid.substring(0, pos));
            }
            if (pos != pre.length() - 1){
                pQ.add(pre.substring(pos, pre.length() - 1));
                mQ.add(mid.substring(pos + 1));
            }
        } while (!pQ.isEmpty());
        return res.toString();
    }

    @Test
    public void test() {
        System.out.println(traversingTree("CBEFDA", "CBAEDF"));
    }
}