/*    
    Company Tags                : will update soon
    Leetcode Link               : https://leetcode.com/problems/find-edges-in-shortest-paths/
*/

/**************************************************** C++ *******************************************/
//Using Dijkstra's
//T.C : O(n+E) , where n = number of vertices, E = number of edges
//S.C : O(n+E)
class Solution {
public:
    typedef long long ll;
    typedef pair<ll, ll> P;
    
    vector<int> dijkstra(unordered_map<int, vector<P>>& adj, int src, int n) {
        priority_queue<P, vector<P>, greater<P>> pq;

        vector<int> dist(n, INT_MAX);
        vector<bool> visited(n, false);

        dist[src] = 0;

        pq.push({0, src});

        while(!pq.empty()) {

            ll  currWt   = pq.top().first;
            int currNode = pq.top().second;
            pq.pop();
        
                        
            if(visited[currNode] == true) {
                continue;
            }


            for(auto adj: adj[currNode]) {
                int nextNode = adj.first;
                ll nextWt = adj.second;

                if(dist[nextNode] > currWt + nextWt) {
                    dist[nextNode] = currWt + nextWt;
                    pq.push({currWt + nextWt, nextNode});
                }
            }
            
            visited[currNode] = true;


        }

        return dist;
    }
    
    vector<bool> findAnswer(int n, vector<vector<int>>& edges) {
        int E = edges.size();
        
        unordered_map<int, vector<P>> adj;
        for(auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adj[u].push_back({v, w});
            adj[v].push_back({u, w});
        }
        
        vector<int> fromSrc  = dijkstra(adj, 0, n);
        vector<int> fromDest = dijkstra(adj, n-1, n);
        
        vector<bool> result(E, false);
        
        for(int i = 0; i < E; i++) {
            
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            ll distFromSrc  = fromSrc[u]; //x
            ll distFromDest = fromDest[v]; //y
            
            if(distFromSrc + w + distFromDest == fromSrc[n-1]) {
                result[i] = true;
            }
            
            
            distFromSrc  = fromSrc[v]; //x
            distFromDest = fromDest[u]; //y
            if(distFromSrc + w + distFromDest == fromSrc[n-1]) {
                result[i] = true;
            }
            
        }
        
        return result;
    }
};



/**************************************************** JAVA *******************************************/
//Using Dijkstra's
class Pair{
    long first;
    long second;

    Pair(long f, long s){
        this.first = f;
        this.second = s;
    }
}

class Solution {

    int[] dijkstra(List<List<Pair>> adj, int src, int n) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> (int)(a.first - b.first));
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e8);

        pq.add(new Pair(0, src));
        dist[src] = 0;

        while(!pq.isEmpty()) {

            Pair p = pq.poll();
            int node = (int)p.second;
            long wt = p.first;

            for(Pair it : adj.get(node)) {
                int adjNode = (int)it.first;
                long adjWt  = it.second;

                if(wt + adjWt < dist[adjNode]) {
                    dist[adjNode] = (int)(wt + adjWt);
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;

    }
    public boolean[] findAnswer(int n, int[][] edges) {
        int E = edges.length;

        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        int[] fromSrc = dijkstra(adj, 0, n);
        int[] fromDest = dijkstra(adj, n-1, n);

        boolean[] result = new boolean[E];
        for(int i = 0; i < E ; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            int distFromStart = fromSrc[u];
            int distFromEnd   = fromDest[v];

            if(distFromStart + w + distFromEnd == fromSrc[n-1]){
                result[i] = true;
                continue;
            }  

            distFromStart = fromSrc[v];
            distFromEnd   = fromDest[u];

            if(distFromStart + w + distFromEnd == fromSrc[n-1]){
                result[i] = true;
            }  

        }
        return result;
    }
}


//Using Dijkstra's
//T.C : O(n+E) , where n = number of vertices, E = number of edges
//S.C : O(n+E)
import java.util.*;

public class Solution {
    class Pair {
        long first;
        long second;
        
        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public long[] dijkstra(HashMap<Integer, ArrayList<Pair>> adj, int src, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.first, b.first));
        long[] dist = new long[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;
        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            long currWt = top.first;
            int currNode = (int) top.second;

            if (visited[currNode]) {
                continue;
            }

            visited[currNode] = true;

            if (!adj.containsKey(currNode)) {
                continue; // Skip if there are no neighbors for this node
            }

            for (Pair neighbor : adj.get(currNode)) {
                int nextNode = (int) neighbor.first;
                long nextWt = neighbor.second;

                if (dist[nextNode] > currWt + nextWt) {
                    dist[nextNode] = currWt + nextWt;
                    pq.add(new Pair(dist[nextNode], nextNode));
                }
            }
        }

        return dist;
    }

    public boolean[] findAnswer(int n, int[][] edges) {
        int E = edges.length;

        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (!adj.containsKey(u))
                adj.put(u, new ArrayList<>());
            if (!adj.containsKey(v))
                adj.put(v, new ArrayList<>());

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        long[] fromSrc = dijkstra(adj, 0, n);
        long[] fromDest = dijkstra(adj, n - 1, n);

        boolean[] result = new boolean[E];

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            long distFromSrc = fromSrc[u]; // x
            long distFromDest = fromDest[v]; // y

            if (distFromSrc + w + distFromDest == fromSrc[n - 1]) {
                result[i] = true;
            }

            distFromSrc = fromSrc[v]; // x
            distFromDest = fromDest[u]; // y
            if (distFromSrc + w + distFromDest == fromSrc[n - 1]) {
                result[i] = true;
            }
        }

        return result;
    }
}
