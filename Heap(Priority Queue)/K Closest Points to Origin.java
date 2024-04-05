//*********************************************** C++ ********************************************************************//
//Approach 1: Using MAx Heap
class Solution {
public:
    int dist(vector<int> p){

        return p[0]*p[0] + p[1]*p[1];
    }

    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        
        priority_queue<pair<int, pair<int, int>> > pq; //max-heap -> {dist,{x,y}}

        int n = points.size();
        for(int i = 0; i < n; i++) {

            pq.push({dist(points[i]), {points[i][0], points[i][1]}});

            if(pq.size() > k){
                pq.pop();
            }
        }

        vector<vector<int>> ans;

        while(pq.size() > 0){

            pair<int, int> p = pq.top().second;
            pq.pop();

            ans.push_back({p.first, p.second});
        }

        return ans;
    }
};



//************************************************ JAVA *********************************************************************//

//Approach 1: Using Custom lambda Comparator

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a,b)-> getDist(a) - getDist(b));

        return Arrays.copyOf(points, k);
    }

    int getDist(int[] p){
        return p[0]*p[0] + p[1]*p[1];
    }
}


//Approach 2: Using Max Heap

class Solution {
    int getDist(int[] p){
        return p[0]*p[0] + p[1]*p[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> maxH = new PriorityQueue<>((a,b)-> b[0] - a[0]); // maxHeap -> {dist, x, y}

        int n = points.length;
        for(int i = 0; i < n; i++) {

            int[] entry = {getDist(points[i]), points[i][0], points[i][1]};

            maxH.add(entry);

            if(maxH.size() > k){
                maxH.poll();
            }
        }

        int[][] ans = new int[k][2];
        int idx = 0;

        while(maxH.size() > 0) {

            int x = maxH.peek()[1];
            int y = maxH.peek()[2];
            maxH.poll();

            int[] temp = {x, y};

            ans[idx++] = temp;
        }

        return ans;
    }
}
