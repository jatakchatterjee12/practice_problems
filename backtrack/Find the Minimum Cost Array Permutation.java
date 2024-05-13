/*  
    Company Tags                : will update soon
    Leetcode Link               : https://leetcode.com/problems/find-the-minimum-cost-array-permutation/description/
*/


/************************************************ C++ ************************************************/
//T.C : O(n!)
//S.C : O(n)
class Solution {
public:
    int n;
    int minSum = INT_MAX;
    vector<int> result;

    void solve(vector<int>& nums, vector<bool>& visited, vector<int>& temp, int sum) {
        if (minSum <= sum)  //If you remove this, you will get TLE. This eliminates many useless calls further
            return; // No point in going further because sum is going higher than minVal

        if (temp.size() == n) {
            sum += abs(temp.back() - nums[temp[0]]);
            if (sum < minSum) {
                minSum = sum;
                result = temp;   
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.push_back(i);
                solve(nums, visited, temp, sum + abs(temp[temp.size() - 2] - nums[temp[temp.size() - 1]]));
                temp.pop_back();
                visited[i] = false;
            }
        }
    }

    vector<int> findPermutation(vector<int>& nums) {
        n = nums.size();
        vector<bool> visited(n, false);
        vector<int> temp = {0}; // lexicographically smallest will start from 0
        visited[0] = true; // We have used and hence visited 0

        solve(nums, visited, temp, 0);
        return result;
    }
};



/************************************************ JAVA ************************************************/
//T.C : O(n!)
//S.C : O(n)
class Solution {
    int n;
    int minScore = Integer.MAX_VALUE;
    List<Integer> finalList;

    void solve(int[] nums, boolean[] visited, List<Integer> list, int score) {

        if(score > minScore) return;

        if(list.size() == n) {

            score += Math.abs(list.get(n-1) - nums[list.get(0)]);

            if(score  < minScore){

                minScore = score;
                finalList = new ArrayList<>(list);
            }
            return;
        }

        for(int num = 0; num  < n; num++) {

            if(visited[num] == false) {

                visited[num] = true;
                list.add(num);

                int size = list.size();

                solve(nums, visited, list, score + Math.abs(list.get(size-2) - nums[list.get(size-1)]));

                visited[num] = false;
                list.remove(size - 1);
            }
        }
    }
    public int[] findPermutation(int[] nums) {
        
        n = nums.length;
        boolean[] visited = new boolean[n];
        List<Integer> list = new ArrayList<>();

        list.add(0); // lexicographically order will start from 0
        visited[0] = true;

        solve(nums, visited, list, 0);

        int[] result = new int[n];
        for(int i = 0; i  < n ; i++){
            result[i] = finalList.get(i);
        }

        return result;
    }
}
