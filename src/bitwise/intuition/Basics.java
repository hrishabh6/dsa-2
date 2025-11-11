package bitwise.intuition;

public class Basics {

    public void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    public Boolean checkIthBit(int num, int i){
        return (num & (1 << i)) != 0;
    }

    public void setIthBit(int num, int i){
        num |= (1 << i);
    }

    //Clearing means convert the bit to 0
    public void clearIthBit(int num, int i){
        num &= ~(1 << i);
    }

    public void toggleIthBit(int num, int i){
        num ^= (1 << i);
    }

    public void removeLastSetBit(int num){
        num &= num-1;
    }

    public Boolean isPowerOfTwo(int num){
        return num > 0 && ((num & (num-1)) == 0);
    }

    public int countSetBits(int num){
        int count = 0;
        while(num > 1){
            num = num & (num - 1);
            count++;
        }
        return count;
    }


}
