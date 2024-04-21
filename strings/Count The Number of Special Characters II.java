class Solution {
    public int numberOfSpecialChars(String word) {
        
        int n = word.length();
        int count = 0;

        int[] small = new int[26];
        int[] capital = new int[26];

        Arrays.fill(small, -1);
        Arrays.fill(capital, -1);

        for(int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                if(capital[ch-'A'] == -1) capital[ch-'A'] = i; // first occurence of caps letters
            }
            else{
                small[ch - 'a'] = i; // last occurence of small letters
            }
        }

        for(int i = 0; i  < 26; i++) {
            if(small[i] == -1 || capital[i] == -1) continue;
            if(small[i] < capital[i] ) count++;
        }
        return count;
    }
}
