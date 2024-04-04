//************************************************ C++ *******************************************************//
//Approach 1: Using min heap
//Tc - O(k^2 * logK)
//SC - O(k^2)


class Solution
{
    public:
    //Function to merge k sorted arrays.
    vector<int> mergeKArrays(vector<vector<int>> arr, int K)
    {
        
        vector<pair<int, pair<int, int>>> temp;
        for(int i = 0; i < K; i++){
            
            temp.push_back({arr[i][0], {i, 0}});
        }
        
        //data, row, col
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq(temp.begin(), temp.end());
        
        vector<int> ans;
        
        while(!pq.empty()) {
            
            auto elem = pq.top();
            pq.pop();
            
            ans.push_back(elem.first);
            
            int i = elem.second.first;
            int j = elem.second.second;
            
            if(j+1 < K){
                pq.push({arr[i][j+1], {i, j+1}});
            }
            
            
        }
        
        return ans;
    }
};




//Approach 2: Merge Sort
////Tc - O(k^2 * logK)
//SC - O(k^2)


class Solution
{
    public:
    
    void merge(vector<int> &arr, int start, int mid, int end) {
        
        vector<int> temp;
        
        int left = start;
        int right = mid+1;
        
        
        while(left <= mid && right <= end) {
            
            if(arr[left] < arr[right]){
                temp.push_back(arr[left]);
                left++;
            }
            else{
                temp.push_back(arr[right]);
                right++;
            }
        }
        
        while(left <= mid){
            
            temp.push_back(arr[left]);
            left++;
        }
        while(right <= end){
            temp.push_back(arr[right]);
            right++;
        }
        
        for(int i = start; i <= end; i++){
            arr[i] = temp[i - start];
        }
        
        
    }
    
    void mergeSort(vector<int> &arr, int start, int end, int portion, int K){
        
        if(portion == 1) return;
        
        int mid  = start + (portion/2)*K - 1;
        
        mergeSort(arr, start, mid, portion/2, K);
        mergeSort(arr, mid+1, end, portion - portion/2, K);
        
        merge(arr, start, mid, end);
        
        
    }
    //Function to merge k sorted arrays.
    vector<int> mergeKArrays(vector<vector<int>> arr, int K)
    {
        //code here
        //merge sort
        
        vector<int> ans;
        for(int i =0; i < K; i++) {
            for(int j = 0; j < K; j++) {
                ans.push_back(arr[i][j]);
            }
        }
        
        mergeSort(ans, 0, ans.size()-1, K, K);
        return ans;
        
    }
};



//**************************************************** JAVA ***********************************************************//
//Approach 1 : Min Heap
//Tc - O(k^2 * logK)
//SC - O(k^2)


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        
        PriorityQueue<int[] > pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        
        for(int i = 0; i < K; i++) {
            
            pq.add(new int[]{arr[i][0], i, 0}); // data, row, col
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            
            int[] temp = pq.poll();
            
            int elem = temp[0];
            int row = temp[1];
            int col = temp[2];
            
            ans.add(elem);
            
            if(col + 1 < K) pq.add(new int[] {arr[row][col+1], row, col+1});
        }
        
        return ans;
        
    }
}
