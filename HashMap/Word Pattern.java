class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] words = s.split(" ");
        if(words.length != pattern.length()) 
            return false;

        Map<Character, String> mp1 = new HashMap<>();
        Map<String, Character> mp2 = new HashMap<>();

        for(int i = 0; i < words.length; i++){

            char ch  = pattern.charAt(i);
            String w = words[i];

            if(mp1.containsKey(ch) &&  !mp1.get(ch).equals(w) ||
               mp2.containsKey(w) && !mp2.get(w).equals(ch)){

                return false;
            }

            mp1.put(ch, w);
            mp2.put(w, ch);
        }
        return true;



    }
}
