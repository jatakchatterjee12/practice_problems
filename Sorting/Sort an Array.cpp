/*
   
    Company Tags               : Microsoft, Goldman Sachs, Cisco
    Leetcode Link              : https://leetcode.com/problems/sort-an-array/
*/

//********************************************************** C++ *****************************************************88//
//solving using Counting Sort (O(n+k))
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        int minE = *min_element(begin(nums), end(nums));
        int maxE = *max_element(begin(nums), end(nums));
        
        unordered_map<int, int> mp;
        
        for(int &num : nums)
            mp[num]++;
        
        int i = 0;
        
        for(int num = minE; num <= maxE; num++) {
            
            while(mp[num] > 0) {
                nums[i] = num;
                i++;
                mp[num]--;
            }
            
        }
        
        return nums;
    }
};

//********************************************************** JAVA *************************************************************//
//Counting SOrt - O(n+k)
class Solution {
    public int[] sortArray(int[] nums) {
        
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>(); 

        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num,0) + 1);
        }

        int minE = Integer.MAX_VALUE;
        int maxE = Integer.MIN_VALUE;

        for(int num :  nums){
            minE = Math.min(num, minE);
            maxE = Math.max(num, maxE);
        }

        int i = 0;
        for(int num = minE; num <= maxE; num++){

            while(mp.containsKey(num) && mp.get(num) > 0) {

                nums[i] = num;
                i++;
                mp.put(num, mp.get(num) - 1);
            }
        }

        return nums;
    }
}


//Heap Sort o(nlogn)
class Solution {

    private void heapify(int[] nums, int curr,int size){

        int largest = curr;

        int  l= 2*curr+1;
        int r= 2*curr+2;

        if(l<size && nums[l]> nums[largest]) largest = l;
        if(r<size && nums[r]> nums[largest]) largest = r;

        if(largest != curr){

            int temp = nums[curr];
            nums[curr] = nums[largest] ;
            nums[largest] = temp;

            heapify(nums,largest,size);
        }
    }
    public int[] sortArray(int[] nums) {

        int n = nums.length;

        for(int i = n/2 -1;i>=0;i--){
            heapify(nums,i,n);
        }

        for(int i= n-1;i>0;i--){

            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums,0,i);
        }

        return nums;
        
    }
}
