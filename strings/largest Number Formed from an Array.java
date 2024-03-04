/*
    Company Tags   : Paytm, Zoho, Amazon, Microsoft, MakeMyTrip
    GFG  Link      : https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
*/

//Approach 1 : Using Comparator

class Comp implements Comparator<String> {
    public int compare(String a, String b) {
        String s1 = a + b;
        String s2 = b + a;
        
        return s2.compareTo(s1);
    }
}
class Solution {
    String printLargest(int n, String[] arr) {
        
        Arrays.sort(arr, new Comp());
        
        String ans = "";
        for(int i =0; i <n; i++){
            ans += arr[i];
        }
        return ans;
    }
}

//Approach 2: using Lambda Function

class Solution {
    String printLargest(int n, String[] arr) {
        
        Arrays.sort(arr, (a,b)->{
            String ab = a+b;
            String ba = b+a;
            return ba.compareTo(ab);
        });
        
        String ans = "";
        for(int i =0; i <n; i++){
            ans += arr[i];
        }
        return ans;
    }
}
