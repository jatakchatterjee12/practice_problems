class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sortedArr = new int[n];
        for(int i = 0; i < n; i++){
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);
        
        Map<Integer, Integer> mp = new HashMap<>(); // num -> rank
        int rank = 1;
        for(int num : sortedArr){
            if(!mp.containsKey(num)){
                mp.put(num, rank);
                rank++;
            }
        }

        for(int i= 0 ; i < arr.length; i++){
            arr[i] = mp.get(arr[i]);
        }
        return arr;
        
    }
}

//Using Stream API

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = Arrays.stream(arr).distinct().sorted().toArray();

        Map<Integer, Integer> mp = new HashMap<>(); // num -> rank(
        int rank = 1;
        for(int num : sortedArr){
            if(!mp.containsKey(num)){
                mp.put(num, rank);
                rank++;
            }
        }

        for(int i= 0 ; i < arr.length; i++){
            arr[i] = mp.get(arr[i]);
        }
        return arr;
        
    }
}
