//Brute Force
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static int kDistinctChars(int k, String str) {
		
		int n = str.length();
		int maxLen = 0;
		Map<Character, Integer> mp = new HashMap<>();

		for(int i = 0; i  < n; i++) {

			mp.clear();

			for(int j = i; j < n; j++) {

				mp.put(str.charAt(j), mp.getOrDefault(str.charAt(j), 0)+1);

				if(mp.size() <= k) {
					maxLen = Math.max(maxLen, j-i+1);
				}
				else{
					break;
				}
			}
			
		}
		return maxLen;
	}

}



//optimal - Sliding Window - O(2*N))
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static int kDistinctChars(int k, String str) {
		
		int n = str.length();
		int maxLen = 0;
		Map<Character, Integer> mp = new HashMap<>();

		int  i = 0;
		int  j = 0;

		while(j  < n) {

			mp.put(str.charAt(j), mp.getOrDefault(str.charAt(j), 0) + 1);

			while(mp.size() > k) {
				char ch = str.charAt(i);
				i++;
				mp.put(ch, mp.get(ch) - 1);

				if(mp.get(ch) == 0){
					mp.remove(ch);
				}

			}

			maxLen = Math.max(maxLen, j-i+1);
			j++;
		}

		return maxLen;
	}

}




//Most Optimal - Sliding Window - O(N)
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static int kDistinctChars(int k, String str) {
		
		int n = str.length();
		int maxLen = 0;
		Map<Character, Integer> mp = new HashMap<>();

		int  i = 0;
		int  j = 0;

		while(j  < n) {

			mp.put(str.charAt(j), mp.getOrDefault(str.charAt(j), 0) + 1);

			if(mp.size() > k) {
				char ch = str.charAt(i);
				i++;
				mp.put(ch, mp.get(ch) - 1);

				if(mp.get(ch) == 0){
					mp.remove(ch);
				}

			}

			maxLen = Math.max(maxLen, j-i+1);
			j++;
		}

		return maxLen;
	}

}
