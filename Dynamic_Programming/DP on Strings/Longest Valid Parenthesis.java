class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        int[] dp = new int[n+1]; // length + 1
      
        //dp[i+1] --> length of valid parenthesis that includes s[i];
        //s = "" dp[0] = 0;
        //s = "(" or s = ")" --> for any single character dp[1] = 0; [no valid parenthesis]

        int res = 0;
        for(int i=1; i<n; i++){   //start with s[1] as s[0] always make invalid parenthesis with only single character

            int j = i - dp[i] - 1;
            if((j >= 0 && s.charAt(j) == '(') && s.charAt(i) == ')') {
                dp[i+1] = dp[i] + dp[j] + 2;

                res = Math.max(res, dp[i+1]);
            }
        }
        return res;
    }
}
