package greedy;

public class MinCoins {

    public int findMin(int n) {
        int[] currency = {1,2,5,10};
        int counter = 0;
        for (int i = 4-1; i >= 0 ; i--) {
            if (currency[i] <= n){
               while(n >= currency[i]){
                   n -= currency[i];
                   counter++;
               }
            }
            if (n == 0) break;
        }
        return counter;

    }

}
