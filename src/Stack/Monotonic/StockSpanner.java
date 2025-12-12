package Stack.Monotonic;

import java.util.Stack;

class Pair {
    int price;
    int span;
    Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

public class StockSpanner {

    Stack<Pair> stack;
    int i;

    public StockSpanner() {
        stack = new Stack<>();
        i = -1;
    }

    public int next(int price) {
        i += 1;
        int ans;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop();
        }
        ans = i - (stack.empty() ? -1 : stack.peek().span);
        Pair pairi = new Pair(price, i);

        stack.push(pairi);
        return ans;
    }

}
