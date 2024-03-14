//leetCode does not have this problem;
//Code Studio has this problem

import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {

        int n = a.length;
        int m = b.length;
        
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < n && j < m) {

            if(a[i] <= b[j]) {
                if(ans.size() == 0 || 
                  ans.get(ans.size() - 1) != a[i]){

                      ans.add(a[i]);
                }

                  i++;
            }
            else {
                if(ans.size() == 0 ||
                 ans.get(ans.size() -1) != b[j]){

                     ans.add(b[j]);
                 }
                 j++;
            }
        }

        while(i < n) {
            if(ans.size() == 0 || 
                ans.get(ans.size() - 1) != a[i]){

                    ans.add(a[i]);
            }

            i++;
        }

        while(j < m) {

            if(ans.size() == 0 ||
                ans.get(ans.size() -1) != b[j]){

                    ans.add(b[j]);
            }
            j++;
        }

        return ans;
    }
}
