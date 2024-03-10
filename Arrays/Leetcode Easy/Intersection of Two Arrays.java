//Approach 1 :Using Set --> TC- O(n), SC - O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for(int num : nums1) st.add(num);

        for(int num : nums2){
            if(st.contains(num)) {
                intersect.add(num);
            }
        }

        int[] result = new int[intersect.size()];
        int i=0;

        for(Integer it : intersect) {
            result[i++] = it;
        }

        return result;
    }

}


//Approach 2 : Two Pointer --> TC - O(nlogn) , SC - O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;
        int m = nums2.length;

        int i=0;
        int j=0;

        Set<Integer> st = new HashSet<>();

        while(i < n && j < m) {
            if(nums1[i] == nums2[j]){
                st.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else i++;
        }

        int[] result = new int[st.size()];
        int k=0;
        for(int it : st) {
            result[k++] = it;
        }
        return result;

    }
}


//Approach 3 : Binary Search --> TC - O(nlogn), SC - O(n)
class Solution {
    boolean binarySearch(int[] nums, int target) {
        int n = nums.length;

        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target) return true;
            else if(nums[mid] < target) low = mid+1;
            else high = mid - 1;
        }
        return false;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Set<Integer> st = new HashSet<>();

        if(n > m) return intersection(nums2, nums1); // n ko chota maan ke uspe binary search

        Arrays.sort(nums1);
        for(int num : nums2) {
            if(binarySearch(nums1, num)){
                st.add(num);
            }
        }

        int[] result= new int[st.size()];
        int idx = 0;

        for(int it : st) {
            result[idx++] = it;
        }
        return result;
    }
}
