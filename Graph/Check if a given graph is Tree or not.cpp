// just check two things...... 1. graph contains cycle or not 
//                             2. all nodes are connected components or not


// ************************************** C++ ****************************************//
class Solution {
  public:
    bool cycleCheck(vector<int> adjG[], vector<bool> &visited, int node, int parent){
        visited[node] = true;
        for(auto it : adjG[node]){
            if(visited[it] == false){
                if(cycleCheck(adjG,visited,it,node) == true){
                    return true;
                }
            }
            else if(it != parent) return true;
        }
        return false;
    }
    int isTree(int n, int m, vector<vector<int>> &adj) {
        
        vector<int> adjG[n];
        
        for(auto it : adj){
            int u = it[0];
            int v = it[1];
            adjG[u].push_back(v);
            adjG[v].push_back(u);
        }
        
        vector<bool> visited(n,false);
        bool hasCycle = cycleCheck(adjG,visited,0,-1);
        if(hasCycle == true){
            return 0;
        }
        
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                return 0;
            }
        }
        return 1;
    }
};

//********************************************** JAVA ***************************************8//


//User function Template for Java
class Solution {
    boolean cycleCheck(List<Integer>[] adjG, boolean[] visited, int node, int parent){
        visited[node] = true;
        for(int it : adjG[node]){
            if(visited[it] == false){
                if(cycleCheck(adjG,visited,it,node) == true){
                    return true;
                }
            }
            else if(it != parent) return true;
        }
        return false;
    }
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
       
       List<Integer>[] adjG = new List[n];
       for(int i=0;i<n;i++){
           adjG[i] = new ArrayList<>();
       }
       for(int i=0;i<m;i++){
           int u = edges.get(i).get(0);
           int v = edges.get(i).get(1);
           adjG[u].add(v);
           adjG[v].add(u);
       }
       
       boolean[] visited = new boolean[n];
       
       boolean hasCycle = cycleCheck(adjG,visited,0,-1);
       if(hasCycle == true) return false;
       
       for(int i=0;i<n;i++){
           if(visited[i] == false) return false;
       }
       return true;
    }
}
