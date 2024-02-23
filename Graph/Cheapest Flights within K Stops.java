/*
      Company Tags                : GOOGLE
      Leetcode Link               : https://leetcode.com/problems/cheapest-flights-within-k-stops/
      GfG Link                    : https://practice.geeksforgeeks.org/problems/cheapest-flights-within-k-stops/1
*/

/****************************************************************** C++ ******************************************************************/
//Approach-1 (BFS)
//T.C : O(V+E) - BFS traversal of Graph
//S.C : O(V+E)
class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<int> distance(n, INT_MAX);
        
        unordered_map<int, vector<pair<int, int>>> adj;
        
        for(vector<int> &vec : flights) {
            int u    = vec[0];
            int v    = vec[1];
            int cost = vec[2];
            
            adj[u].push_back({v, cost});
        }
        
        queue<pair<int, int>> que;
        que.push({src, 0});
        distance[src] = 0;
        
        int level = 0;
        
        while(!que.empty() && level <= k) {
            int N = que.size();
            
            while(N--) {
                int u = que.front().first;
                int d = que.front().second;
                que.pop();
                
                for(pair<int, int> &P : adj[u]) {
                    
                    int v    = P.first;
                    int cost = P.second;
                    
                    if(distance[v] > d + cost) {
                        distance[v] = d + cost;
                        que.push({v, d+cost});
                    }
                    
                }
                
            }
            level++;
        }
        
        return distance[dst] == INT_MAX ? -1 : distance[dst];
    }
};

//Approach 2:
class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        
        vector<pair<int, int>> adj[n];
        for(auto it : flights) {
            int u = it[0];
            int v = it[1];
            int cost = it[2];

            adj[u].push_back({v,cost});
        }

        vector<int> dist(n, 1e8);
        queue<pair<int, pair<int, int>>> que;

        dist[src] = 0;
        que.push({0,{src, 0}}); // steps - { node, dist}


        while(!que.empty()) {

                int steps = que.front().first;
                int node = que.front().second.first;
                int cost = que.front().second.second;
                que.pop();

                if(steps > k) break;

                for(auto it : adj[node]) {
                    int adjNode = it.first;
                    int adjCost = it.second;

                    if(cost + adjCost < dist[adjNode]) {
                        dist[adjNode] = cost + adjCost;
                        que.push({steps+1, {adjNode, dist[adjNode]}});
                    }
                }
        }

        return dist[dst] == 1e8 ? -1  : dist[dst];
    }
};


/****************************************************************** JAVA ******************************************************************/
//Approach-1 (BFS)
//T.C : O(V+E) - BFS traversal of Graph
//S.C : O(V+E)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, cost});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        distance[src] = 0;

        int level = 0;

        while (!queue.isEmpty() && level <= k) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int u = current[0];
                int d = current[1];

                List<int[]> neighbors = adj.getOrDefault(u, Collections.emptyList());
                for (int[] neighbor : neighbors) {
                    int v = neighbor[0];
                    int cost = neighbor[1];

                    if (distance[v] > d + cost) {
                        distance[v] = d + cost;
                        queue.offer(new int[]{v, d + cost});
                    }
                }
            }
            level++;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
//Another Approach creating new class pair
class Pair{
    int first; // node
    int second; // dist

    Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Pair>> adj = new HashMap<>();
        for(int[] flight : flights) {
            adj.computeIfAbsent(flight[0], v-> new ArrayList<>()).add(new Pair(flight[1], flight[2]));
        }

        int steps = 0;
        int[] dist = new int[n];
        for(int i=0; i<n; i++){
            dist[i] = (int)1e8;
        }

        dist[src] = 0;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(src, 0));

        while(!que.isEmpty() && steps <= k) {

            int size = que.size();
            while(size-- > 0) {
                Pair P = que.poll();
                int node = P.first;
                int cost = P.second;

                for(Pair it : adj.getOrDefault(node,new ArrayList<>())) {
                    int adjNode = it.first;
                    int adjCost = it.second;

                    if(cost + adjCost < dist[adjNode]) {
                        dist[adjNode] = cost + adjCost;
                        que.add(new Pair(adjNode, dist[adjNode]));
                    }
                }
            }
            steps++; 
        }
        return dist[dst] == (int)1e8 ? -1 : dist[dst];

    }
}

//Approach 2:
class Pair{
    int node;
    int cost;
    Pair(int n, int c) {
        this.node = n;
        this.cost = c;
    }
}

class Tuple {
    int steps;
    int node;
    int cost;
    Tuple(int s, int n, int c) {
        this.steps = s;
        this.node = n;
        this.cost = c;
        
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i <n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adj.get(u).add(new Pair(v, cost));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e8);

        Queue<Tuple> q = new LinkedList<>();

        dist[src] = 0;
        q.add(new Tuple(0, src, 0));

        while(!q.isEmpty()) {
            Tuple T = q.poll();

            int steps = T.steps;
            int node = T.node;
            int cost = T.cost;

            if(steps > k) break;

            for(Pair it : adj.get(node)) {
                int adjNode = it.node;
                int adjCost = it.cost;

                if(cost + adjCost < dist[adjNode]) {
                    dist[adjNode] = cost + adjCost;
                    q.add(new Tuple(steps+1, adjNode, dist[adjNode]));
                }
            }
        }

        return dist[dst] == (int)1e8 ? -1 : dist[dst];
    }
}
