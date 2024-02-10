//*************************************************** C++ *******************************************//

//*************************************************** JAVA ******************************************// 
//Approach 1 : simply add and sort (TC - O((m+n)log(m+n))
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int j = 0, i = m; j < n; j++){
            nums1[i] = nums2[j];
            i++;
        }
        Arrays.sort(nums1);
    }
}

//Approach 2 : Two pointer TC- O(m+n)  Fastest Solution
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // starting from the end 
        int i = m-1;
        int j = n-1;
        int k = m + n - 1;

        while(j >= 0){                       // only need to complete j loop . i wala nums1 ke liye hai to elements bach bhi gya to sorted order me hi hoga
            if(i >= 0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];     // i wala banda bada hai to end me woh rahega
            }else {
                nums1[k--] = nums2[j--];     // j wala banda bada hai to end me woh baithega
            }
        }
    
    }
}
