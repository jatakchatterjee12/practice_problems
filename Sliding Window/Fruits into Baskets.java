//Brute Force
class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        
        int n = fruits.size();

        int count = 0;
        

        for(int i = 0; i < n; i++){
            set<int> st;
            for(int j = i; j < n; j++) {
                st.insert(fruits[j]);

                if(st.size() <= 2){
                    count = max(count, j-i+1);
                }
                else{
                    //st.size() > k
                    break;
                }
            }
            
        }
        return count;
    }
};


//********************************************************* C++ *************************************************************//
class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        
        unordered_map<int, int> mp; // num -> freq

        int n = fruits.size();

        int i = 0;
        int j = 0;

        int result = 0;

        while(j < n) {

            mp[fruits[j]]++;

            while(mp.size() > 2) {
                mp[fruits[i]]--;
                if(mp[fruits[i]] == 0){
                    mp.erase(fruits[i]);
                }
                i++;
            }

            result = max(result, j-i+1);
            j++;
        }
        return result;


    }
};


//******************************************************** JAVA ***************************************************************************//
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        Map<Integer, Integer> mp = new HashMap<>();

        int i =0 ;
        int j = 0;
        int result = 0;

        while(j < n) {

            mp.put(fruits[j], mp.getOrDefault(fruits[j],0) +1);

            while(mp.size() > 2){
                mp.put(fruits[i], mp.getOrDefault(fruits[i],0) - 1);

                if(mp.get(fruits[i]) == 0){
                    mp.remove(fruits[i]);
                }
                i++;
            }

            result  = Math.max(result, j-i+1);
            j++;
        }
        return result;
    }
}
