package bitwise.medium;

public class SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        int bucket1 = 0, bucket2 = 0;
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        xor = (xor & (xor - 1)) ^ xor;

        for(int num : nums){
            if((num & xor) == 0) bucket2 ^= num;
            else bucket1 ^= num;
        }

        int[] arr = new int[2];
        arr[0] = bucket1;
        arr[1] = bucket2;
        return arr;
    }

}
