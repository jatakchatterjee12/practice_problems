/*
  Leetcode    :  https://leetcode.com/problems/maximize-sum-of-weights-after-edge-removals/

*/

// TC - o(nlogn)
// SC - o(n)
// REcursion + Memo

class Solution {
    static class Edge{
        int ngbr;
        int wt;
        Edge(int ngbr, int wt){
            this.ngbr=ngbr;
            this.wt=wt;
        }
    }

    private List<List<Edge>> graph;
    private int K;

    private long[][] dp;

    public long maximizeSumOfWeights(int[][] edges, int k) {
        graph = new ArrayList<>();
        K = k;

        int n = edges.length+1;
        for(int i = 0; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        dp = new long[n][2];
        for(long[] row : dp){
            Arrays.fill(row, -1L);
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new Edge(v,w));
            graph.get(v).add(new Edge(u,w));
        }

        return solve(0, 0, -1);
    }

    private long solve(int node, int isParentEdgeRemoved, int parent){

        if(dp[node][isParentEdgeRemoved] != -1L){
            return dp[node][isParentEdgeRemoved];
        }

        int edgesToRemove = Math.max(0, graph.get(node).size() - K - isParentEdgeRemoved);
        long result = 0L;

        List<long[]> candidates = new ArrayList<>();

        for(Edge edge : graph.get(node)){
            int ngbrNode = edge.ngbr;
            int ngbrWt = edge.wt;

            if(ngbrNode != parent){
                long notRemoved = solve(ngbrNode, 0, node) + ngbrWt;
                long removed    = solve(ngbrNode, 1, node);
                candidates.add(new long[] {notRemoved, removed}); 
            }

            
        }

        candidates.sort((a,b) -> Long.compare(a[0] - a[1], b[0] - b[1]));

        for(int i = 0; i < candidates.size(); i++) {
            long notRemoved = candidates.get(i)[0];
            long removed    = candidates.get(i)[1];

            if( i < edgesToRemove) {
                result += removed;
            }
            else{
                result += Math.max(notRemoved, removed);
            }
        }

        return dp[node][isParentEdgeRemoved] = result;
    }
}
