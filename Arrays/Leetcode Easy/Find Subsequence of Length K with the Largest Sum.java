/*   
    Company Tags                : will update later
    Leetcode Link               : https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum
*/

/*********************************************************** C++ **************************************************/
//Approach-1 (Using sorting with indices)
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        int n = nums.size();
        if (k == n)
            return nums;

        vector<pair<int, int>> vec(n);
        for(int i = 0; i < n; i++) {
            vec[i] = make_pair(i, nums[i]);
        }

        auto lambda = [](auto &p1, auto& p2) {
            return p1.second > p2.second;
        };

        sort(begin(vec), end(vec), lambda);

        sort(begin(vec), begin(vec)+k);

        vector<int> result;
        for(int i = 0; i < k; i++) {
            result.push_back(vec[i].second);
        }

        return result;
    }
};


//Approach-2 (Using nth_element for partial sort)
//T.C : Average O(n+k)
//S.C : O(1)
class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        if (k == nums.size())
            return nums;

        // Copy nums to a temp vector to find k largest elements
        vector<int> temp(nums);
        
        // Use nth_element to put the k largest elements in the first k positions (unordered)
        nth_element(begin(temp), begin(temp) + k - 1, end(temp), greater<int>()); //Average TC is O(n)

        // Determine the threshold value (k-th largest element)
        int threshold = temp[k - 1];

        // Count how many times threshold appears in top k elements
        int countThreshold = count(temp.begin(), temp.begin() + k, threshold); //O(k)

        vector<int> result;
        for (int num : nums) {
            if (num > threshold) {
                result.push_back(num);
            } else if (num == threshold && countThreshold > 0) {
                result.push_back(num);
                --countThreshold;
            }
            if (result.size() == k)
                break;
        }

        return result;
    }
};



/*********************************************************** JAVA **************************************************/
//Approach-1 (Using sorting with indices)
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        if (k == n)
            return nums;

        // Pair: index and value
        int[][] vec = new int[n][2];
        for (int i = 0; i < n; i++) {
            vec[i][0] = i;      // index
            vec[i][1] = nums[i]; // value
        }

        // Sort by value descending
        Arrays.sort(vec, (a, b) -> Integer.compare(b[1], a[1]));

        // Then sort the top-k by original index to maintain order
        Arrays.sort(vec, 0, k, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = vec[i][1];
        }

        return result;
    }
}


//NOTE :  Java doesn't have nth_element (partial sort) utility.
//Approach-2 (Using nth_element for partial sort)
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if (k == nums.length)
            return nums;

        // Copy nums to a temp array to find k largest elements
        int[] temp = Arrays.copyOf(nums, nums.length);

        // Use a partial sort to place the k largest elements in the first k slots (unordered)
        Arrays.sort(temp); // Java doesn't have nth_element, so sort entire array (O(n log n) worst-case)
        int threshold = temp[temp.length - k]; // k-th largest

        // Count how many times threshold appears in the top-k largest
        int countThreshold = 0;
        for (int i = temp.length - k; i < temp.length; i++) {
            if (temp[i] == threshold)
                countThreshold++;
        }

        int[] result = new int[k];
        int index = 0;

        for (int num : nums) {
            if (num > threshold) {
                result[index++] = num;
            } else if (num == threshold && countThreshold > 0) {
                result[index++] = num;
                countThreshold--;
            }
            if (index == k)
                break;
        }

        return result;
    }
}


//Using Priority Queue
// Approach  :   // 1. take a min heap -> stroing nums[i], i
                // 2. put all elements in min heap and maintain only k size
                //    thus only k larger elements are left in heap
        
                // 3. traverse heap and pop out elements and indices , store the indices in set
                // 4. take an array result and traverse the main input array and see if the current index is in our set, put the element in to our resut array

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);

        for(int i=0; i<n; i++){
            pq.add(new int[]{nums[i], i});

            if(pq.size() > k){
                pq.poll();
            }
        }

        Set<Integer> indices = new HashSet<>();
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            indices.add(top[1]);
        }

        int[] res = new int[k];
        int p=0;

        for(int i=0; i<n; i++){
            if(indices.contains(i)){
                res[p] = nums[i];
                p++;
            }
        }
        return res;
    }
}

//Using Sorting
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int n = nums.length;
        int K = k;

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = n-1; i >= 0 && k-- > 0; i--){
            mp.put(sorted[i], mp.getOrDefault(sorted[i],0)+1);

        }

        int[] res = new int[K];
        int p  =0;
        for(int i = 0; i < n; i++){
            if(mp.containsKey(nums[i])){
                res[p++] = nums[i];
                mp.put(nums[i], mp.get(nums[i])-1);
                if(mp.get(nums[i]) == 0){
                    mp.remove(nums[i]);
                }
                if(p == K) break;
            }
        }
        return res;
    }
}
