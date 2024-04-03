// We can use Floyd Cycle Detection Algo here..
// A very good Qns

class Solution {
    int digitSqSum(int n) {
        int sum = 0;
        int temp = 0;

        while(n > 0) {
            temp = n%10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }

  
    public boolean isHappy(int n) {

        if(n == 1) return true;
        
        int slow, fast;

        slow = n;
        fast = digitSqSum(n);

        while(slow != fast) {

            slow = digitSqSum(slow);
            fast = digitSqSum(digitSqSum(fast));

            if(fast == 1) return true;
        }

        return false;
    }
}
