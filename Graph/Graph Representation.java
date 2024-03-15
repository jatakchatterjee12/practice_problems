import java.util.*;
public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for(int i= 0;i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i< m; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);

        }

        int[][] g = new int[n][];

        for(int i=0; i < n; i++) {
            int size  = adj[i].size();
            int[] tmp = new int[size+1];
            tmp[0] = i;

            for(int j = 0; j < size; j++) {
                tmp[j+1] = adj[i].get(j);
            }
            g[i] = tmp;
        }   
        return g;     
    }
}
