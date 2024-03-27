class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;

        int leftSum = 0;
        int rightSum = 0;
        int maxPoints = 0;

        for(int i = 0; i < k; i++){
            leftSum += cardPoints[i];
        }

        maxPoints = leftSum;

        int rightIdx = n-1;

        for(int i = k-1; i >= 0; i--){

            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIdx];
            rightIdx--;

            maxPoints = Math.max(maxPoints, leftSum + rightSum); 
        }

        return maxPoints;
    }
}
