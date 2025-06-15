/*
Q)You have given an array of fruits with frequencies in a specific order. We need to give all the possible arrangements of these fruits in such a way that
same fruits are not adjacent and
all fruits should be consumed

Input: nums = [2,1,2] (M, O, A)

Output:
M O A M A
M A M O A
M A M A O
M A O M A
M A O A M
O M A M A
O A M A M
A M O M A
A M O A M
A M A M O
A M A O M
A O M A M

  */

// ANS:-

// TIME : O(k⋅T)   k = total number of fruits    T = total valid permuation
// worst case : 

// SPACE : O(T⋅n)
// (assuming T valid permutations and each one is of size n)
​
 

import java.util.*;

public class Solution {

    static List<List<String>> result;

    public static List<List<String>> fruitArrangements(int[] nums, String[] fruits) {
        result = new ArrayList<>();
        int total = Arrays.stream(nums).sum();
        backtrack(new ArrayList<>(), nums, fruits, "", total);
        return result;
    }

    private static void backtrack(List<String> path, int[] freq, String[] fruits, String prev, int total) {
        if (path.size() == total) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < fruits.length; i++) {
            if (freq[i] > 0 && !fruits[i].equals(prev)) {
                freq[i]--;
                path.add(fruits[i]);
                backtrack(path, freq, fruits, fruits[i], total);
                path.remove(path.size() - 1);
                freq[i]++;
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {2, 1, 2};               // Frequencies
        String[] fruits = {"M", "O", "A"};    // Corresponding fruits

        List<List<String>> arrangements = fruitArrangements(nums, fruits);
        for (List<String> arrangement : arrangements) {
            System.out.println(String.join(" ", arrangement));
        }
    }
}
