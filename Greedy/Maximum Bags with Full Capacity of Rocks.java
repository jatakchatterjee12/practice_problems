/*
    Company Tags                : <soon>
    Leetcode Link               : https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
*/

//**************************************************** C++ *************************************************************//

//Filling the least one first : O(nlogn)
class Solution {
public:
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        int n = capacity.size();
        int count = 0;
        vector<int> required(n);
        
        for(int i = 0; i<n; i++) {
            required[i] = capacity[i] - rocks[i];
        }
        
        sort(begin(required), end(required));
        
        for(int i = 0; i<n; i++) {
            if(additionalRocks >= required[i]) {
                additionalRocks -= required[i];
                count++;
            } else
                break;
        }
        
        return count;
    }
};


//************************************************* JAVA **********************************************************//
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int n = capacity.length;

        int[] required = new int[n];
        for(int i = 0;i < n; i++){
            required[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(required);
        int count = 0;

        for(int i = 0; i < n ; i++) {
           
            if(additionalRocks >= required[i]){
                count++;
                additionalRocks -= required[i];
            }
            else{
                break;
            }    
            
        }
        return count;
    }
}
