/*
    Company Tags         : Amazon
    GFG Link             : https://www.geeksforgeeks.org/problems/count-pairs-whose-sum-is-equal-to-x/1
*/


class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2,
                          int x) {
        
        int n = head1.size();
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(Integer it : head1){
            mp.put(it, mp.getOrDefault(it,0)+1);
        }
        
        int result = 0;
        for(Integer it : head2){
            
            Integer target = x - it;
            if(mp.containsKey(target)){
                result += mp.get(target);
            }
        }
        
        return result;
        
    }
}
