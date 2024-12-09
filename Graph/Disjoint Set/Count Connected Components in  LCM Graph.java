/*
      Leetcode link      :  https://leetcode.com/problems/count-connected-components-in-lcm-graph/
*/

//TC - O(mlogm + m*sqrt(nums[i]) + 4*alpha)
//SC - O(logm + n + divisorMap(2*10^5)

class DSU{
    private int[] parent;
    private int[] rank;

    DSU(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 0; i < n+1; i++){
            parent[i] = i;
        }
    }

    int findPar(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = findPar(parent[x]);
    }

    void union(int x, int y){
        int x_par = findPar(x);
        int y_par = findPar(y);

        if(x_par == y_par){
            return;
        }

        if(rank[x_par] > rank[y_par] ){
            parent[y_par] = x_par;
        }
        else if(rank[y_par] > rank[x_par]){
            parent[x_par] = y_par;
        }
        else{
            parent[x_par] = y_par;
            rank[y_par]++;
        }
    }
}

class Solution {

    private int getGCD(int a, int b){
        if(b == 0) return a;
        return getGCD(b, a%b);
    }
    private int getLCM(int a, int b){
        return (a*b)/getGCD(a,b);
    }
    public int countComponents(int[] nums, int threshold) {
        
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            if(num <= threshold){
                list.add(num);
            }
        }

        int components = nums.length - list.size();
        if(list.size() == 0){
            return components;
        }

        int m = list.size();
        Collections.sort(list);

        Map<Integer, Integer> divisorMap = new HashMap<>();
        DSU dsu = new DSU(m);

        for(int i = 0; i < m; i++){

            for(int divisor = 1 ; divisor*divisor <= list.get(i); divisor++){

                if(list.get(i) % divisor == 0){

                    if(divisorMap.containsKey(divisor)){
                        int otherIdx = divisorMap.get(divisor);
                        if(getLCM(list.get(i), list.get(otherIdx)) <= threshold){
                            dsu.union(i, otherIdx);
                        } 
                    }
                    else{
                        divisorMap.put(divisor, i);
                    }

                    int quotent = list.get(i) / divisor;
                    if(divisorMap.containsKey(quotent)){
                        int otherIdx = divisorMap.get(quotent);
                        if(getLCM(list.get(i), list.get(otherIdx)) <= threshold){
                            dsu.union(i, otherIdx);
                        } 
                    }
                    else{
                        divisorMap.put(quotent, i);
                    }
                }
            }

        }

        Set<Integer> countComponents = new HashSet<>();
        for(int i = 0; i < m; i++){
            countComponents.add(dsu.findPar(i));
           
        }
       
        return components + countComponents.size();

    }
}
