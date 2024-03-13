class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> ans = new ArrayList<>();

        for(int i = left; i <= right; i++) {

            if(selfDividing(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    boolean selfDividing(int num) {
        int n = num;
        while(n > 0) {
            if(n%10 == 0 || (num % (n%10) != 0)){
                return false;
            }
            n = n/10;
        }
        return true;
    }
}
