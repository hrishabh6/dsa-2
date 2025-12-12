package Stack.Monotonic;

import java.util.Stack;

public class CelibrityProblem {

    public int celebrity(int mat[][]) {
        Stack<Integer> stack = new Stack<>();
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            stack.push(i);

        }

        while(stack.size() > 1){
            int i = stack.pop();
            int j = stack.pop();

            if (mat[i][j] == 0){
                stack.push(i);
            } else {
                stack.push(j);
            }

        }

        int celeb = stack.peek();

        for (int i = 0; i < n; i++) {
            if (i != celeb && (mat[celeb][i] == 1 || mat[i][celeb] == 0)){
                return -1;
            }
        }
        return celeb;


    }

}
