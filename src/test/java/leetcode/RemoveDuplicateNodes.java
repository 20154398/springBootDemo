package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodes {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //20200625 leetcode每日一题
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> s = new HashSet<>();
        ListNode curr = head;
        ListNode pre = curr;
        while (curr != null) {
            if (s.contains(curr.val)){
                pre.next = curr.next;
            }else {
                s.add(curr.val);
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    @Test
    public void main(){
        ListNode head = new ListNode(1);
        ListNode curr = head;
        curr.next = new ListNode(1);
        curr = curr.next;
        curr.next = new ListNode(1);
        curr = curr.next;
        curr.next = new ListNode(1);
        curr = curr.next;
        curr.next = new ListNode(1);
        curr = curr.next;
        curr.next = new ListNode(2);
        removeDuplicateNodes(head);
    }
}
