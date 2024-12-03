/*
    leetcode      :  https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii
*/

//Reference Link  :  https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/solutions/6101731/java-simple-solution-o-n-m/

//Intuition : Even - Odd means 1 or 0 means something with parity

//Approach : 
 /**
    For a node in first tree, try to connect all possible connections, you will realise we just need to know number of red colors and number of white colors.

            // 0 --- red color
            // 1 --- white color

            for red nodes,

            Number of Red in 1st graph + Number of Red in 2nd Graph
            OR
            Number of Red in 1st graph + Number of White in 2nd Graph

            Similary, for any white node

            Number of white in 1st graph + Number of Red in 2nd Graph
            OR
            Number of white in 1st graph + Number of White in 2nd Graph
                    
     */

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {

        
        Map<Integer, List<Integer>> adj1 = new HashMap<>();
        Map<Integer, List<Integer>> adj2 = new HashMap<>();

        buildGraph(adj1, edges1);
        buildGraph(adj2, edges2);

        int n = adj1.size();
        int m = adj2.size();

        int[] nodeColor1 = new int[n];
        int[] colorCount1 = new int[2]; // count the total nodes with a specific color.... colorCount[0] = 5 => 5 nodes are there with red color, similar for white color nodes 

        int[] nodeColor2 = new int[m];
        int[] colorCount2 = new int[2];

        dfs(adj1, colorCount1, 0, -1, 0, nodeColor1); //start with red color
        dfs(adj2, colorCount2, 0, -1, 0, nodeColor2); // start with red color

        int[] result = new int[n];
        for(int i = 0; i < n; i++) {

            if(nodeColor1[i] == 0){ // red color
                result[i] = Math.max(colorCount1[0] + colorCount2[0], colorCount1[0] + colorCount2[1]);
            }
            else{
                // white color
                result[i] = Math.max(colorCount1[1] + colorCount2[0], colorCount1[1] + colorCount2[1]);
            }
        } 
        return result;
    }

    void buildGraph(Map<Integer, List<Integer>> adj, int[][] edges){

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }
    }

    void dfs(Map<Integer, List<Integer>> adj, int[] colorCount, int node, int parent, int currColor, int[] nodeColor) {
        nodeColor[node] = currColor; // assign the currnode with curr color
        colorCount[currColor]++; //  increase the currColor count in count array as we need to track total number of red nodes and white nodes

        for(int ngbr : adj.getOrDefault(node, new ArrayList<>())){
            if(ngbr != parent) {
                dfs(adj, colorCount, ngbr, node, 1-currColor, nodeColor);
            }
        }
    }
}
