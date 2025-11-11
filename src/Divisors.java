import java.util.ArrayList;
import java.util.List;

public class Divisors {

    public static List<Integer> divisors(int n) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                ans.add(i);
                if(i != n/i) ans.add(n/i);
            }
            else continue;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println("Test 1: " + divisors(n));
    }

}
