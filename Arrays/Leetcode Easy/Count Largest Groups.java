/*     
    Company Tags                : 
    Leetcode Link               : https://leetcode.com/problems/count-largest-group/description/
*/

/*********************************************************** C++ **************************************************/
//Approach (Simulation)
//T.C : O(n * d), d = average number of digits in all numbers
//S.C : O(n)
class Solution {
public:
    int findDigitsSum(int num) {
        int sum = 0;
        while(num) {
            sum += num%10;
            num /= 10;
        }

        return sum;
    }

    int countLargestGroup(int n) {
        unordered_map<int, int> mp;

        int maxSize = 0;
        int count   = 0;

        for(int num = 1; num <= n; num++) {
            int digitsSum = findDigitsSum(num);

            mp[digitsSum]++;
            if(mp[digitsSum] == maxSize) {
                count++;
            } else if(mp[digitsSum] > maxSize) {
                maxSize = mp[digitsSum];
                count   = 1;
            }
        }

        return count;

    }
};


/*********************************************************** JAVA **************************************************/
//Approach (Simulation)
//T.C : O(n * d), d = average number of digits in all numbers
//S.C : O(n)
class Solution {
    int findSum(int num){
        int sum = 0;
        while(num > 0){
            sum += (num%10);
            num = num / 10;
        }
        return sum;
    }
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int maxSize = 0;
        int count  = 0;

        for(int num = 1; num <= n; num++){
                
            int digitSum = findSum(num);

            mp.put(digitSum, mp.getOrDefault(digitSum,0)+1);

            if(mp.get(digitSum) == maxSize){
                count++;
            }
            else if(mp.get(digitSum) > maxSize){
                maxSize = mp.get(digitSum);
                count = 1;
            }
        }
        return count;
    }
}
