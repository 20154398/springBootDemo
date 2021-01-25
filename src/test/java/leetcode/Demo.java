package leetcode;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author 唐源
 * @date 2020/12/8
 */
public class Demo {


    @Test
    public void main2() {
        List<A> list = new ArrayList<>();
        B b = new B();
        b.setTest1231232List(Arrays.asList(7,8));
        b.setTestList(Arrays.asList("1","2"));

        list.add(b);
        System.out.println(list);
    }


    @Data
    private class A {
        private List<String> testList;
    }

    @Data
    private class B extends A{
        private List<Integer> test1231232List;
    }
}
