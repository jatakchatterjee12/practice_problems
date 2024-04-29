/*
    LeetCode Link      : https://leetcode.com/problems/lemonade-change/
*/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;

        if(bills[0] != 5) return false;

        int cnt_5 = 0;
        int cnt_10 = 0;
        int cnt_20 = 0;

        for(int i = 0; i  < n; i++) {
            if(bills[i] == 5){
                cnt_5++;
            }
            else if(bills[i] == 10){
                cnt_10++;
                if(cnt_5 == 0) return false;
                else cnt_5--;
            }
            else{
                cnt_20++;
                if(cnt_5 == 0 || (cnt_10 == 0 && cnt_5 < 3)) return false;
                else {
                    if(cnt_10 > 0 ) {
                        cnt_10--;
                        cnt_5--;
                    }
                    else{
                        cnt_5 -= 3;
                    }
                    
                }
            }
        }
        return true;
    }
}
