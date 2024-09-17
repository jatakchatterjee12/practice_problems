class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> count = new HashMap<>();

        String s1_s2 = s1 + " " + s2;
        String[] s1_s2_array = s1_s2.split(" ");

        for(String word : s1_s2_array){
            count.put(word, count.getOrDefault(word, 0)+1);
        }

        List<String> res = new ArrayList<>();
        for(String word : count.keySet()){
            if(count.get(word) == 1){
                res.add(word);
            }
        }

        return res.toArray(new String[0]);
    }
}
