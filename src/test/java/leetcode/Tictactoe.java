package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author 唐源
 * @date 2021/1/13
 * A 和 B 在一个 3 x 3 的网格上玩井字棋。
 *
 * 井字棋游戏的规则如下：
 *
 * 玩家轮流将棋子放在空方格 (" ") 上。
 * 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
 * "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
 * 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
 * 如果所有方块都放满棋子（不为空），游戏也会结束。
 * 游戏结束后，棋子无法再进行任何移动。
 * 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
 *
 * 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 *
 * 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
 */
public class Tictactoe {
    public String tictactoe(int[][] moves) {
        A a = new A();
        for (int[] m : moves) {
            a.add(m[0], m[1]);
            if (!a.isEnd().equals("")) {
                return a.isEnd();
            }
        }
        return moves.length >= 9 ? "Draw" : "Pending";
    }

    private class A {
        private int[] a = new int[9];
        private boolean b;

        public A() {
            Arrays.fill(a, 0);
            b = true;
        }

        public void add(int a, int b) {
            this.a[a * 3 + b] = this.b ? 1 : 2;
            this.b = !this.b;
        }

        public String isEnd() {
            if (a[0] == a[3] && a[0] == a[6] && a[0] == 1) return "A";
            else if (a[0] == a[3] && a[0] == a[6] && a[0] == 2) return "B";
            else if (a[1] == a[4] && a[1] == a[7] && a[1] == 1) return "A";
            else if (a[1] == a[4] && a[1] == a[7] && a[1] == 2) return "B";
            else if (a[2] == a[5] && a[2] == a[8] && a[2] == 1) return "A";
            else if (a[2] == a[5] && a[2] == a[8] && a[2] == 2) return "B";
            else if (a[0] == a[1] && a[0] == a[2] && a[0] == 1) return "A";
            else if (a[0] == a[1] && a[0] == a[2] && a[0] == 2) return "B";
            else if (a[3] == a[4] && a[3] == a[5] && a[3] == 1) return "A";
            else if (a[3] == a[4] && a[3] == a[5] && a[3] == 2) return "B";
            else if (a[6] == a[7] && a[6] == a[8] && a[6] == 1) return "A";
            else if (a[6] == a[7] && a[6] == a[8] && a[6] == 2) return "B";
            else if (a[0] == a[4] && a[0] == a[8] && a[0] == 1) return "A";
            else if (a[0] == a[4] && a[0] == a[8] && a[0] == 2) return "B";
            else if (a[2] == a[4] && a[2] == a[6] && a[2] == 1) return "A";
            else if (a[2] == a[4] && a[2] == a[6] && a[2] == 2) return "B";
            return "";
        }
    }
}
