class Solution {
    int[] countingSort(int[] arr) {

        int mini = 1000;
        int maxi = -1;
        for(int num : arr){
            if(num < mini) mini = num;
            if(num > maxi) maxi = num;
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0)+1);
        } 

        int i = 0;
        for(int num = mini; num <= maxi; num++) {
            if(mp.containsKey(num) && mp.get(num) > 0){
                while(mp.get(num) > 0) {

                    arr[i] = num;
                    i++;
                    mp.put(num, mp.get(num)-1);
                }
            }
        }
        return arr;
    }
    public int heightChecker(int[] heights) {
        
        int n = heights.length;
        int[] expected = heights.clone();

        expected = countingSort(expected);
        

        int  result = 0;
        for(int i = 0; i < n; i++) {
            
            if(heights[i] != expected[i]){
                result++;
            }
        }
        return result;
    }
}
