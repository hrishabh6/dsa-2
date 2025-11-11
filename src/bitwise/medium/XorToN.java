package bitwise.medium;

public class XorToN {

    public int xorOperation(int n) {
        if (n % 4 == 1) return 0;
        else if(n %4 == 2) return n+1;
        else if(n %4 == 3) return 0;
        else return n;
    }

    //Follow up: Xor from L to R
    public int xorOperation2(int L, int R) {
        return xorOperation(L-1) ^ xorOperation(R);
    }

}
