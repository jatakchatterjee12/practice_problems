class Solution {
    public String getHint(String secret, String guess) {
        
        int n = secret.length();
 
        int[] count_for_s = new int[10];
        int[] count_for_g = new int[10];

        int bulls = 0 , cows = 0;

        for(int i=0; i<n; i++){

            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if(s == g) bulls++;
            else{
               count_for_s[s]++;
               count_for_g[g]++;
            }
        }

        for(int i=0; i<10; i++){
            cows += Math.min(count_for_s[i] , count_for_g[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
