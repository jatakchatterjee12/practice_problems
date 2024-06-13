/*
    Leetcode Link    :    https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/
*/

//************************************************ C++ ***********************************************//
class Solution {
public:
    int minMovesToSeat(vector<int>& seats, vector<int>& students) {
        sort(seats.begin(), seats.end());
        sort(students.begin(), students.end());
        
        int res = 0;
        for (int i = 0; i < seats.size(); i++) 
              res += abs(seats[i] - students[i]);
        
        return res;
    }
};


//************************************************ JAVA ***********************************************//
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        Arrays.sort(seats);
        Arrays.sort(students);

        int result = 0;
        for(int i = 0; i < n; i++) {
            result += Math.abs(seats[i] - students[i]);
        }
        return result;
    }
}
