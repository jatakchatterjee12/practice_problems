/*
	
	Company Tags		    : Flipkart, Microsoft
	GfG Link		    : https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
*/

//************************************************************ C++ **********************************************8//

//Time : O(E * log(V))
//E = number of edges
//V = number of vertices
class Solution
{
	public:
	   //Function to find the shortest distance of all the vertices
    	   //from the source vertex S.
	    vector <int> dijkstra(int V, vector<vector<int>> adj[], int S) {

		priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

		vector<int> result(V, INT_MAX);

		result[S] = 0;
		pq.push({0, S});
		//NOTE - You can add a visited vector to avoid revisiting a node again and again. It will reduce the time complexity.

		while(!pq.empty()) {

		    int d  = pq.top().first;
		    int node = pq.top().second;
		    pq.pop();

		    for(auto &vec : adj[node]) {

			int adjNode = vec[0];
			int dist    = vec[1];

			if(d + dist < result[adjNode]) {

			    result[adjNode] = d + dist;
			    pq.push({d+dist, adjNode});

			}

		    }

		}

		return result;

	    }
};



//***************************************************************** JAVA **************************************************8//
//Time : O(E * log(V))
//E = number of edges
//V = number of vertices

class Pair{
    int distance;
    int node;
    
    Pair(int d,int n){
        this.distance = d;
        this.node = n;
    }
}
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
       
       PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
       
       int[] dist = new int[V];
       for(int i= 0; i <V; i++) dist[i] = (int)1e9;
       
       dist[S] = 0;
       pq.add(new Pair(0,S));
       
       while(pq.size() > 0){
           
           int dis = pq.peek().distance;
           int node = pq.peek().node;
           
           pq.remove();
           
           for(ArrayList<Integer> it : adj.get(node)){
               
               int edgeWt = it.get(1);
               int adjNode = it.get(0);
               
               if(dis + edgeWt < dist[adjNode]){
                   
                   dist[adjNode] = dis + edgeWt;
                   pq.add(new Pair(dist[adjNode], adjNode));
               }
           }
       }
       return dist;
    }
}
