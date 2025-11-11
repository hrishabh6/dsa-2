package bitwise.medium;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public List<Integer> primeFactors(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                ans.add(i);
                while(n % i == 0){
                    n /= i;
                }
            }
        }
        if(n != 1) ans.add(n);
        return ans;
    }

    public static void main(String[] args) {
        PrimeFactors obj = new PrimeFactors();
        int n = 37;
        System.out.println("Test 1: " + obj.primeFactors(n));
    }

}
