//TC - O(n^2)
//SC - O(n)
class Solution {
    boolean canSend(int ageX, int ageY){
        if(ageY <= 0.5 * ageX + 7 || ageY > ageX || ageY > 100 && ageX < 100 ) return false;
        return true;
    }
    public int numFriendRequests(int[] ages) {
        
        Map<Integer, Integer> mp = new HashMap<>();
        for(int age : ages){
            mp.put(age, mp.getOrDefault(age, 0)+1);
        }

        int requests = 0;
        for(int ageX : mp.keySet()){
            for(int ageY : mp.keySet()){
                if(canSend(ageX, ageY) == false) continue;

                int countX = mp.get(ageX);
                int countY = mp.get(ageY);

                if(ageX == ageY){
                    requests += (countX - 1)*countX;
                }
                else{
                    requests += (countX * countY);
                }
            }
        }
        return requests;
    }
}
