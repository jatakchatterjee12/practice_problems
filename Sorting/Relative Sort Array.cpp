/* 
    Company Tags                : will soon update
    Leetcode Link               : https://leetcode.com/problems/relative-sort-array
*/

/******************************************************************************** C++ ************************************************************/
//Approach-1 (Using counting sort)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        map<int, int> mp;

        for(int &num : arr1) {
            mp[num]++;
        }

        int i = 0;
        for(int &num : arr2) {
            while(mp[num]-- > 0) {
                arr1[i++] = num;
            }
        }

        for(auto &it : mp) {
            int freq = it.second;
            while(freq > 0) {
                arr1[i++] = it.first;
                freq--;
            }
        }

        return arr1;
    }
};


//Approach-2 (Using lambda)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        unordered_map<int, int> mp;

        for(int i = 0; i < arr2.size(); i++) {
            mp[arr2[i]] = i;
        }

        for(int &num : arr1) {
            if(!mp.count(num)) {
                mp[num] = 1e9;
            }
        }

        auto lambda = [&](int &num1, int &num2){
            if(mp[num1] == mp[num2]) { //1e9
                return num1 < num2;
            }

            return mp[num1] < mp[num2];
        };

        sort(begin(arr1), end(arr1), lambda);

        return arr1;
    }
};



/******************************************************************************** JAVA ************************************************************/
//Approach-1 (Using counting sort)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        Map<Integer, Integer> mp = new TreeMap<>();
        for(int num : arr1) {
            mp.put(num, mp.getOrDefault(num,0) + 1);
        }

        int i = 0;
        for(int num : arr2){
            while(mp.get(num) > 0) {
                arr1[i++] = num;
                mp.put(num, mp.get(num) - 1);
            }
        }

        for(int key : mp.keySet()) {

            int freq = mp.get(key);
            while(freq > 0) {
                arr1[i++] = key;
                freq--;
            }
        }
        return arr1;
    }
}


//Approach-2 (Using lambda)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < arr2.length; i++) {
            mp.put(arr2[i], i);
        }

        for(int num : arr1) {
            if(!mp.containsKey(num)) {
                mp.put(num, (int)1e8);
            }
        }
       
        List<Integer> list = new ArrayList<>();
        for(int num : arr1){
            list.add(num);
        }
        Comparator<Integer> comparator = (num1, num2)->{
            int index1 = mp.get(num1);
            int index2 = mp.get(num2);
            if (index1 == index2) {
                return Integer.compare(num1, num2);
            }
            return Integer.compare(index1, index2);
        };
        Collections.sort(list, comparator);

        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
        
    }
}
