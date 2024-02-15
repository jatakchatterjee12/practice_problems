/*
      Company Tags                : GOOGLE, Akuna Capital
      Leetcode Link               : https://leetcode.com/problems/network-delay-time/
*/

//Just copy paste the Dijkstra'a Code and Find the maximum amongst the minimums in result vector
//But, Why maximum ?
//Because, we have to return the minimum time it takes for all the n nodes to receive the signal

//******************************** C++ ***************************************//
class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        unordered_map<int, vector<pair<int, int>>> adj;
        for(auto &vec : times) {
            
            int u = vec[0];
            int v = vec[1];
            int w = vec[2];
            
            adj[u].push_back({v, w});
            
        }
        
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

	vector<int> result(n+1, INT_MAX);

	result[k] = 0;
	pq.push({0, k});

	while(!pq.empty()) {

	    int d  = pq.top().first;
	    int node = pq.top().second;
	    pq.pop();

	    for(auto &vec : adj[node]) {

		int adjNode = vec.first;
		int dist    = vec.second;

		if(d + dist < result[adjNode]) {

		    result[adjNode] = d + dist;
		    pq.push({d+dist, adjNode});

		}

	    }

	}
        
        int ans = INT_MIN;
        
        for(int i = 1; i <= n; i++)
            ans = max(ans, result[i]);
        
	return ans == INT_MAX ? -1 : ans;
    }
};

//***************************************** JAVA *************************************//
class Pair{
    int first;
    int second;
    Pair(int f, int s){
        this.first = f;
        this.second = s;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Pair> > mp = new HashMap<>();
        for(int[] it : times){
            int u = it[0];
            int v = it[1];
            int wt = it[2];

            mp.computeIfAbsent(u, m-> new ArrayList<>()).add(new Pair(v,wt));
        }

        int[] dist =  new int[n+1];
        for(int i=1; i<=n; i++){
            dist[i] = (int)1e8; // INT MAX
        }
        dist[k] = 0; // dist of src = 0

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]); // {dist, node}

        pq.add(new int[]{0, k});

        while(!pq.isEmpty()){

            int[] pop = pq.poll();
            int d = pop[0];
            int node = pop[1];

            for(Pair it : mp.getOrDefault(node, new ArrayList<>())){
                int adjWt = it.second;
                int adjNode = it.first;

                if(d + adjWt < dist[adjNode]){

                    dist[adjNode] = d + adjWt;
                    pq.add(new int[]{d+adjWt, adjNode});
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            if(dist[i] == (int)1e8) return -1;
            if(dist[i] > ans) ans = dist[i];
        }
        return ans;
    }
}
