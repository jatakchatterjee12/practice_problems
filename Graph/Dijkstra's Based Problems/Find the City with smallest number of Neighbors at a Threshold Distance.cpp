/*
    Company Tags                : Amazon, Microsoft
    Leetcode Link               : https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
*/


/************************************************************ C++ ************************************************************/
//Approach (Using Dijkstra's)
//T.C : O(V * ElogV) where E is the number of edges and V = number of vertices. We call Dijkstra's for each vertex.
        //In worst case , max edges = V*(V-1)/2
        //O(V * V*(V-1)/2 * log V)
        //Which is approximately equal to O(V^3 * log V)
//S.C : O(V^2)
class Solution {
public:
    #define P pair<int, int>

    // Khandaani Dijkstra's algorithm to find shortest paths from a source city
    void dijkstra(int n, unordered_map<int, vector<P>>& adj, vector<int>& result, int S) {
        priority_queue<P, vector<P>, greater<P>> pq;
        pq.push({0, S});
        fill(result.begin(), result.end(), INT_MAX);
        result[S] = 0;  // Distance to source itself is zero

        // Process nodes in priority order
        while (!pq.empty()) {
            int d = pq.top().first;
            int node = pq.top().second;
            pq.pop();

            for (auto& p : adj[node]) {
                int adjNode = p.first;
                int dist = p.second;

                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.push({d + dist, adjNode});
                }
            }
        }
    }

    int getCityWithFewestReachable(int n, const vector<vector<int>>& shortestPathMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = INT_MAX;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }

    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        unordered_map<int, vector<P>> adj;

        vector<vector<int>> shortestPathMatrix(n, vector<int>(n, INT_MAX));

        for (int i = 0; i < n; i++) {
            shortestPathMatrix[i][i] = 0;  // Distance to itself is zero
        }

        for (const auto& edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            adj[start].push_back({end, weight});
            adj[end].push_back({start, weight});
        }

        // Compute shortest paths from each city using Dijkstra's algorithm
        for (int i = 0; i < n; i++) {
            dijkstra(n, adj, shortestPathMatrix[i], i);
        }

        return getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold);
    }
};



/************************************************************ JAVA ************************************************************/
//Approach (Using Dijkstra's)
//T.C : O(V * ElogV) where E is the number of edges and V = number of vertices. We call Dijkstra's for each vertex.
        //In worst case , max edges = V*(V-1)/2
        //O(V * V*(V-1)/2 * log V)
        //Which is approximately equal to O(V^3 * log V)
//S.C : O(V^2)
class Solution {

    // Dijkstra's algorithm to find shortest paths from a source city
    void dijkstra(int n, Map<Integer, List<int[]>> adj, int[] result, int S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {0, S});
        Arrays.fill(result, Integer.MAX_VALUE);
        result[S] = 0;  // Distance to source itself is zero

        // Process nodes in priority order
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];

            if (adj.get(node) == null) continue;  // Check if adjacency list is null

            for (int[] p : adj.get(node)) {
                int adjNode = p[0];
                int dist = p[1];

                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.add(new int[] {d + dist, adjNode});
                }
            }
        }
    }

    int getCityWithFewestReachable(int n, int[][] shortestPathMatrix, int distanceThreshold) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = Integer.MAX_VALUE;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }

            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        int[][] shortestPathMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], Integer.MAX_VALUE);
            shortestPathMatrix[i][i] = 0;  // Distance to itself is zero
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            adj.computeIfAbsent(start, k -> new ArrayList<>()).add(new int[] {end, weight});
            adj.computeIfAbsent(end, k -> new ArrayList<>()).add(new int[] {start, weight});
        }

        // Compute shortest paths from each city using Dijkstra's algorithm
        for (int i = 0; i < n; i++) {
            dijkstra(n, adj, shortestPathMatrix[i], i);
        }

        return getCityWithFewestReachable(n, shortestPathMatrix, distanceThreshold);
    }
}


////////////////////////////////// More Simpler Way to code /////////////////////////////////////////////////////////
class Solution {
    private class Pair{
        int node;
        int dist;
        Pair(int n, int d){
            node  = n;
            dist = d;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        List<Pair> adj[] = new List[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj[u].add(new Pair(v, wt));
            adj[v].add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist); // min heap


        int result = 0;
        int cntOfCity = n;

        for(int city = 0; city < n; city++) {

            int[] distance = new int[n];
            Arrays.fill(distance, (int)1e8);

            pq.add(new Pair(city, 0));
            distance[city] = 0;

            while(!pq.isEmpty()) {
                Pair p = pq.poll();
                int node = p.node;
                int dist = p.dist;

                for(Pair it : adj[node]) {
                    int adjNode = it.node;
                    int adjWt = it.dist;

                    if(dist + adjWt < distance[adjNode]){
                        distance[adjNode] = dist + adjWt;
                        pq.add( new Pair(adjNode, distance[adjNode]));

                    }
                }
            }

            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(distance[j] <= distanceThreshold) {
                    cnt++;
                }
            }

            if(cnt <= cntOfCity){
                cntOfCity = cnt;
                result = city;
            }


        }
        return result;


    }
}
