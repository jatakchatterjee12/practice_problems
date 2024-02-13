class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        if(s.isEmpty()) return true;

        int start = 0;
        int last = n-1;

        while(start <= last){
            char curr_first = s.charAt(start);
            char curr_last = s.charAt(last);

            if(!Character.isLetterOrDigit(curr_first)) { start++; continue; }
            if(!Character.isLetterOrDigit(curr_last)) { last--; continue; }
            
            if(Character.toLowerCase(curr_first) != Character.toLowerCase(curr_last)){
                return false;
            }
            else{
                start++;
                last--;  
            }
            
        }
        return true;
    }
}
