/*
    Company Tags                : Will update soon
    Leetcode Link               : https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone
    
*/

/******************************************************************************** C++ ******************************************************************************************/
//Approach-1 (Using Counting Sort)
//T.C : O(n+m)
//S.C : O(m)
class Solution {
public:
    int minMovesToSeat(vector<int>& seats, vector<int>& students) {
        int n = students.size();
        vector<int> position_seat(101, 0);
        vector<int> position_stud(101, 0);

        for(int &x : seats) {
            position_seat[x]++;
        }
        for(int &x : students) {
            position_stud[x]++;
        }

        int i = 0;
        int j = 0;
        int result = 0;

        while(i <= 100 && j <= 100) {
            if(position_seat[i] == 0) i++;
            if(position_stud[j] == 0) j++;
            
            if(i <= 100 && j <= 100 && position_seat[i] != 0 && position_stud[j] != 0) {
                result += abs(i-j);
                position_seat[i]--;
                position_stud[j]--;
                n--;
            }
        }

        return result;

    }
};

//Approach-2 (Using sorting)
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
public:
    int minMovesToSeat(vector<int>& seats, vector<int>& students) {
        sort(begin(seats), end(seats));
        sort(begin(students), end(students));

        int moves = 0;

        int n = seats.size();
        for(int i = 0; i < n; i++) {
            moves += abs(seats[i] - students[i]);
        }

        return moves;
    }
};


/******************************************************************************** JAVA ******************************************************************************************/
//Approach-1 (Using Counting Sort)
//T.C : O(n+m)
//S.C : O(m)
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        
        int n = seats.length;
        int[] position_seats = new int[101];
        int[] position_students = new int[101];

        for(int pos : seats) {
            position_seats[pos]++;
        }
        for(int pos : students){
            position_students[pos]++;
        }

        int i = 0, j = 0;
        int moves = 0;

        while(i <= 100 && j <= 100 ) {
            if(position_seats[i] == 0) i++;
            if(position_students[j] == 0) j++;

            if(i <= 100 && j <= 100 && position_seats[i] != 0 && position_students[j] != 0){
                moves += Math.abs(j-i);
                position_seats[i]--;
                position_students[j]--;
            }
        }
        return moves;
    }
}


//Approach-2 (Using sorting)
//T.C : O(nlogn)
//S.C : O(1)
public class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        // Sort the seats and students arrays
        Arrays.sort(seats);
        Arrays.sort(students);

        int moves = 0;
        int n = seats.length;

        // Calculate the total number of moves
        for (int i = 0; i < n; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }
}
