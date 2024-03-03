//Approach 1:
class Solution {
    List<String> ans = new ArrayList<>();
    void solve(int idx, String digits, String curr, Map<Character, String> mp, int n) {

        if(idx >= n) {
            ans.add(curr);
            return;
        }
        char ch = digits.charAt(idx);
        String str = mp.get(ch);

        for(int i=0; i < str.length(); i++) {

            curr += str.charAt(i);
            solve(idx+1, digits, curr, mp, n);

            curr = curr.substring(0, curr.length()-1); // backtrack
        }
    }
    public List<String> letterCombinations(String digits) {
        int n = digits.length();

        if(n ==0) return ans;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        String curr = "";

        solve(0, digits, curr, map, n);
        return ans;

    }
}


//Approach 2: taking String array instead of map
class Solution {
    List<String> ans = new ArrayList<>();
    void solve(int idx, String digits, String curr, String[] mp, int n) {

        if(idx >= n) {
            ans.add(curr);
            return;
        }
        char ch = digits.charAt(idx);
        String str = mp[ch-'0'];

        for(char c : str.toCharArray()) {

            curr += c;
            solve(idx+1, digits, curr, mp, n);

            curr = curr.substring(0, curr.length()-1); // backtrack
        }
    }
    public List<String> letterCombinations(String digits) {
        int n = digits.length();

        if(n ==0) return ans;

        String[] map = {
            "", //0
            "", // 1
            "abc", // 2
            "def", //3
            "ghi", //4
            "jkl", //5
            "mno", //6
            "pqrs", //7
            "tuv",// 8
            "wxyz", // 9
        };
        String curr = "";

        solve(0, digits, curr, map, n);
        return ans;


    }
}

//Approach 3 : taking String Builder
class Solution {
    public List<String> letterCombinations(String digits) {
         List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] mapping = {
            "",    // 0
            "",    // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs",// 7
            "tuv", // 8
            "wxyz", // 9
            "", // *
            "" //#
        };
        
        backtrack(result, digits, mapping, new StringBuilder(), 0);
        return result;
    };
    
    private void backtrack(List<String> result, String digits, String[] mapping, StringBuilder combination, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        
        char digit = digits.charAt(index);
        String letters = mapping[digit - '0'];
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            backtrack(result, digits, mapping, combination, index + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
};
