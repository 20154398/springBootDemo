package leetcode;

/**
 * @author 唐源
 * @date 2020/12/4
 */
public class MergeInBetween {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nodeA = null;
        ListNode nodeB = null;
        for(int i = 0; i < b + 1;i++){
            ListNode node = list1.next;
            if (i == a - 1)nodeA=node;
            else if (i == b)nodeB=node;
        }
        nodeA.next = list2;
        ListNode end = null;
        while ((end = list2.next) != null);
        end.next = nodeB;
        return list1;
    }
}
