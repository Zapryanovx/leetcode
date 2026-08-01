// https://leetcode.com/problems/online-stock-span/description

package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_0901_OnlineStockSpan {
    Deque<int[]> stack;

    public LC_0901_OnlineStockSpan() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && price >= stack.peekLast()[0]) {
            span += stack.pollLast()[1];
        }

        stack.addLast(new int[]{price, span});
        return span;
    }
}
