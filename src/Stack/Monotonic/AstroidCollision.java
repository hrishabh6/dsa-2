package Stack.Monotonic;

import java.util.ArrayList;
import java.util.List;

public class AstroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();
        for (int a : asteroids) {
            // Process collisions only when `a` is moving left (<0)
            boolean alive = true;
            while (alive && a < 0 && !stack.isEmpty() && stack.get(stack.size() - 1) > 0) {
                int top = stack.get(stack.size() - 1);
                if (top < -a) {
                    // top asteroid explodes
                    stack.remove(stack.size() - 1);
                } else if (top == -a) {
                    // both explode
                    stack.remove(stack.size() - 1);
                    alive = false;
                } else {
                    // incoming asteroid explodes
                    alive = false;
                }
            }
            if (alive) {
                stack.add(a);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }


}
