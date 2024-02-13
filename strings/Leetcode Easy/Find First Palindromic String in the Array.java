/// *********************************************** JAVA ************************************************************//

class Solution {
    boolean isPalindrome(String word){
        int n = word.length();
        //Stack<Character> st
        int l = 0;
        int r = n-1;
        while(l <= r){
            if(word.charAt(l) != word.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String word : words){
            if(isPalindrome(word) == true){
                return word;
            }
        }
        return "";
    }
}
