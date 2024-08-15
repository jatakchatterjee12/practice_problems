
/*
    Company Tags                : will update soon
    Leetcode Link               : https://leetcode.com/problems/lemonade-change
*/


/*************************************************************** C++ ********************************************************/
//Simply Simulation
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int five = 0;
        int ten  = 0;


        for(int &bill : bills) {
            if(bill == 5) {
                five++;
            } else if(bill == 10) { //return 5$ to customer
                if(five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if(five > 0 && ten > 0) { //return 15$ to customer
                five--;
                ten--;
            } else if(five >= 3) { //5, 5, 5
                five -= 3;
            } else {
                return false;
            }
        }

        return true;
    }
};


/*************************************************************** JAVA ********************************************************/
//Simply Simulation
//T.C : O(n)
//S.C : O(1)
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten  = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) { // return $5 to customer
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if (five > 0 && ten > 0) { // return $15 to customer
                five--;
                ten--;
            } else if (five >= 3) { // $5, $5, $5
                five -= 3;
            } else {
                return false;
            }
        }

        return true;
    }
}



//////////////////////////////////////////
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
