class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int leftSum = 0;
        int rightSum = 0; //initially totalSum == rightSum
        for(int num : nums) rightSum += num;

        for(int i=0; i<nums.size(); i++){
            
            rightSum -= nums[i];

            if(leftSum == rightSum) return i;

            leftSum += nums[i];
        }
        return -1;
    }
};

//Same Approach in different way
class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int totalSum = 0;
        int leftSum = 0;

        for(int num : nums) totalSum += num;

        for(int i=0; i<nums.size(); leftSum += nums[i++]){
            
            /*
                sum to the left = leftSum
                sum to the right = totalSum - leftSum - nums[i] (excluding that element nums[i])
                check if leftSum == totalSum - leftSum - nums[i]
                i.e. -> leftSum * 2 == totalSum - nums[i]
            */

            if(leftSum * 2 == totalSum - nums[i]){
                return i;
            }
        }
        return -1;
    }
};
