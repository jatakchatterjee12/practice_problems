/*
  
  Company Tags                : Flipkart, Amazon, Microsoft, Samsung, MakeMyTrip, Oracle, Adobe, BankBazaar
  Gfg Link                    : https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
*/

/************************************************** C++ *********************************************************//

class Solution {
  public:
    // Function to detect cycle in a directed graph.
    bool isCyclic(int N, vector<int> adj[]) {
        queue<int> que;
	    vector<int> indegree(N, 0);
	    int count = 0;
	    //1
	    for(int u = 0; u<N; u++) {
	        for(int &v : adj[u]) {
	            indegree[v]++;
	        }
	    }
	    
	    //2. Fill que, indegree with 0
	    for(int i = 0; i<N; i++) {
	        if(indegree[i] == 0) {
	            que.push(i);
	            count++;
	        }
	    }
	    
	    //3. Simple BFS
	    while(!que.empty()) {
	        int u = que.front();
	        que.pop();
	        
	        for(int &v : adj[u]) {
	            indegree[v]--;
	            
	            if(indegree[v] == 0) {
	                que.push(v);
	                count++;
	            }
	            
	        }
	    }
	    
	    return count != N;
    }
};

/************************************************** JAVA *************************************************//


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        
         int indegree[] = new int[V];
	    
	    for(int i = 0; i <V; i++){
	        
	        for(int it: adj.get(i)){
	            indegree[it]++;
	        }
	    }
	    
	    Queue<Integer>  que =  new LinkedList<>();
	    for(int i = 0; i <V; i++){
	        if(indegree[i] == 0){
	            
	            que.add(i);
	        }
	    }
	    
	   int cnt = 0;
	    
	    while(!que.isEmpty()){
	        
	        int node = que.poll();
	        
	        
	        cnt++;
	        
	        for(int it : adj.get(node)){
	            
	            indegree[it]--;
	            
	            if(indegree[it] == 0){
	                que.add(it);
	            }
	        }
	    }
	    return cnt != V;
    }
}
