//   Code Studio Link  :  https://www.codingninjas.com/studio/problems/find-the-number-of-states_1377943?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

import java.util.*;
public class Solution {
    

    public static int findNumOfProvinces(int[][] roads, int n) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i= 0; i < n; i++){
            for(int j= 0; j < n; j++){
                if(i != j){
                    if(roads[i][j] == 1){
                        adj.get(i).add(j);
                    }
                }
            }
        }
        
        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i <n; i++) {
          
                if(vis[i] == false) {
                    dfs(i, adj, vis);
                    count++;
                }
        }

        return count;
    }

    static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        vis[i] = true;

        for(int it : adj.get(i)){
            if(vis[it] == false) {
                dfs(it, adj,vis);
            }
        }

        
    }
}
