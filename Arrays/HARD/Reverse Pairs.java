/*
    Time Complexity: O(2N*logN), where N = size of the given array.
    Reason: 
      Inside the mergeSort() we call merge() and countPairs() except mergeSort() itself. Now, inside the function
      countPairs(), though we are running a nested loop, we are actually iterating the left half once and the right half once
      in total. That is why, the time complexity is O(N). And the merge() function also takes O(N). The mergeSort() takes 
      O(logN) time complexity. Therefore, the overall time complexity will be O(logN * (N+N)) = O(2N*logN).

    Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.
*/

class Solution {
    private void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> tmp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                tmp.add(arr[left]);
                left++;
            }
            else{
                tmp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            tmp.add(arr[left]);
            left++;
        }
        while(right <= high) {
            tmp.add(arr[right]);
            right++;
        }

        for(int i=low; i<= high; i++) {
            arr[i] = tmp.get(i-low);
        }
    }

    private int reverseCount(int[] arr, int low, int mid, int high){
        int cnt= 0;
        int right = mid+1;

        for(int i=low; i<=mid; i++) {
            while(right <= high && (long)arr[i] > (long)2*arr[right]){
                right++;
            }

            cnt = cnt +  (right - (mid+1));
        }

        return cnt;

    }
    private int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if(low >= high) return cnt;

        int mid = low + (high-low)/2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr,mid+1, high);

        cnt += reverseCount(arr, low, mid, high);

        merge(arr, low, mid, high);

        return cnt;
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n-1);
        
    }
}
