class Solution {
    public int hammingDistance(int x, int y) {
        
        int n = x^y;

        int cnt = 0;
        while(n > 0) { //count set bits

            cnt++;
            n &= n-1;
        }
        return cnt;
    }
}


//One Liner
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
