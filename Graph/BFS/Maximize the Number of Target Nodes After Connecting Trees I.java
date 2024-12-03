/*
      Company
      Leetcode          :   https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/
*/

//Note : Most Optimized Solution Used in 2nd part of this problem.
// Maximize the Number of Target Nodes After Connecting Trees II  :  https://github.com/jatakchatterjee12/practice_problems/blob/main/Graph/DFS/Maximize%20the%20Number%20of%20Target%20Nodes%20After%20Connecting%20Trees%20II.java

//Approach : Graph | BFS | Greedy
//TC - O(n^2 + m^2)
//SC - O(n+m)

class Solution {
    private int bfsCount(Map<Integer, List<Integer>> adj, int start, int k, int size) {

        boolean[] visited = new boolean[size];
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visited[start] = true;

        int cnt  = 0;
        int dist = 0;

        while(!que.isEmpty() && dist <= k) {
            int sz = que.size();

            while(sz-- > 0){
                int node = que.poll();
                cnt++;

                for(int ngbr : adj.getOrDefault(node, new ArrayList<>())){
                    if(!visited[ngbr]){
                        que.add(ngbr);
                        visited[ngbr] = true;
                    }
                }
            }
            dist++;
        }

        return cnt;
    } 
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length;
        int m = edges2.length;

        Map<Integer, List<Integer>> adj1 = new HashMap<>();
        Map<Integer, List<Integer>> adj2 = new HashMap<>();

        for(int[] edge : edges1){
            int u = edge[0];
            int v = edge[1];

            adj1.computeIfAbsent(u, a->new ArrayList<>()).add(v);
            adj1.computeIfAbsent(v, a->new ArrayList<>()).add(u);
        }

        for(int[] edge : edges2){
            int u = edge[0];
            int v = edge[1];

            adj2.computeIfAbsent(u, a->new ArrayList<>()).add(v);
            adj2.computeIfAbsent(v, a->new ArrayList<>()).add(u);
        }

        int[] cnt1 = new int[n+1];
        for(int i = 0 ;i <= n; i++) {
            cnt1[i] = bfsCount(adj1, i, k, n+1);
        } 

        int goldenNodeDistCnt = 0;
        for(int v = 0; v <= m; v++){
            int cnt = bfsCount(adj2, v, k-1, m+1);
            if(cnt > goldenNodeDistCnt){
                goldenNodeDistCnt = cnt;
            }
        }

        int[] result = new int[n+1];

        for(int i = 0; i <= n; i++){
            int totalTargets = cnt1[i] + goldenNodeDistCnt;
            result[i] = totalTargets;
        }
        return result;


    }
}
