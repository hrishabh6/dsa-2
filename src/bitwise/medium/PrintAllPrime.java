package bitwise.medium;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPrime {

    //We will use Sieve of Eratosthenes to find all prime numbers up to n
    public int[] precomputations(int n){
        
        int[] result = new int[n+1];
        for(int i = 2; i <= n; i++){
            result[i] = i;
        }

        for(int i = 2; i*i <= n; i++){
            if(result[i] == 1){
                for(int j = i*i; j <= n; j+=i){
                    result[j] = 0;
                }
            }
        }

        return result;
    }

    public void printAllPrime(int n){
        int[] primes = precomputations(n);
        for(int i = 2; i <= n; i++){
            if(primes[i] == 1) System.out.print(i + " ");
        }
    }

}
