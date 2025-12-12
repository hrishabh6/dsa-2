package SlidingWindow;

public class MaxPointFromCards {

    //Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, rightSum = 0;
        int maxSum = 0, rightIndex = cardPoints.length - 1;
        for(int i = 0; i < k; i++) leftSum += cardPoints[i];
        maxSum = leftSum;

        for(int i = k-1; i >= 0; i--){
            //Remove from left each time and add to right
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIndex--];
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }

}
