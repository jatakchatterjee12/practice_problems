// TC - O(n)
// SC - O(n)
class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();
        for(int num  : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for(int keyVal : mp.keySet()){
            if(k == 0){
                if(mp.get(keyVal) >= 2){
                    count++;
                }
            }
            else{
                if(mp.containsKey(keyVal + k)){
                    count++;
                }
            }
        }
        return count;
    }
}
