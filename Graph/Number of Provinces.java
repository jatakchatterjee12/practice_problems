/*
    LC Link   :  https://leetcode.com/problems/number-of-provinces/description/
*/

class Solution {

    void dfs( List<List<Integer>> adjList ,boolean[] vis,int i){
        vis[i] = true;
        for(int it:adjList.get(i)){
            if(vis[it] == false){
                dfs(adjList,vis,it);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int count = 0;
        boolean[] vis = new boolean[n+1];
        for(int i = 0;i<n;i++){
            if(vis[i] == false){
                count++;
                dfs(adjList,vis,i);
               
            }
        }

        return count;

        
    }
}
