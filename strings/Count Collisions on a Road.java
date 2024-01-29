/*
      LeetCode Qn Link ->  https://leetcode.com/problems/count-collisions-on-a-road/
*/
/* 
Approach : 
cars on left side which are moving in left direction are never going to collide,
Similarly, cars on right side which are moving right side are never going to collide.

In between them every car is going to collide.
*/

class Solution {
    public int countCollisions(String directions) {
        char[] d = directions.toCharArray();
        int n = d.length;

        int result = 0;

        int left = 0;
        int right = n-1;
        
        while(left < n && d[left] == 'L')    left++;
        while(right >= 0 && d[right] == 'R') right--;

        for(int i=left; i <= right; i++){
            if(d[i] != 'S'){
                result++;
            }
        }
        return result;
    }
}
