package leetcode;

import lombok.var;

import java.util.PriorityQueue;

/**
 * @author 唐源
 * @date 2021/1/13
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 */
public class DominantIndex {
    public int dominantIndex(int[] nums) {
        PriorityQueue<A> priorityQueue = new PriorityQueue<>((a1, a2) -> a2.getValue() - a1.getValue());
        for (int i = 0; i < nums.length; i++){
            A a = new A(i, nums[i]);
            priorityQueue.offer(a);
        }
        A max = priorityQueue.poll();
        A max2 = priorityQueue.poll();
        return max.getValue() >= max2.getValue() * 2 ? max.getIndex() : -1;
    }

    private class A {
        int index;
        int value;

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }

        public A(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
