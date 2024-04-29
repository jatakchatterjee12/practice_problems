class Solution {
    public long minEnd(int n, int x) {
        long result = x;

        while(--n > 0) { // loop will run upto (n-1) times

            result = (result + 1) | x;
        }
        return result;
    }
}
