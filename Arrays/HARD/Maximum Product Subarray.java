//Brute force: O(n^3) 
public class Main
{
	static int maxProductSubArray(int arr[]) {
	    int result = Integer.MIN_VALUE;
	    for(int i=0;i<arr.length-1;i++) 
	        for(int j=i+1;j<arr.length;j++) {
	            int prod = 1;
	            for(int k=i;k<=j;k++) 
	                prod *= arr[k];
	            result = Math.max(result,prod);
	        }
	   return result;     
	}
}


//Better Approach : O(n^2)
public class Main
{
	static int maxProductSubArray(int arr[]) {
	    int result = arr[0];
	    for(int i=0;i<arr.length-1;i++) {
	        int p = arr[i];
	        for(int j=i+1;j<arr.length;j++) {
	            result = Math.max(result,p);
	            p *= arr[j];
	        }
	        result = Math.max(result,p);
	    }
	   return result;     
	}
}


//optimal Approach : 
class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;

        int maxi = Integer.MIN_VALUE;
        int prod = 1;

        for(int i = 0; i < n; i++){

            prod *= nums[i];

            maxi = Math.max(maxi, prod);

            if(prod == 0)
                prod = 1;

        }

        prod = 1;

        for(int  i = n-1; i >= 0; i--){

            prod *= nums[i];

            maxi = Math.max(maxi, prod);

            if(prod == 0)
                prod = 1;
        }

        return maxi;
        
    }
}


//Optimal Solution : Better Style to do it
class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        
        int prefixProd = 1;
        int suffixProd = 1;

        for(int i=0; i<n; i++) {

            if(prefixProd == 0) prefixProd = 1;
            if(suffixProd == 0) suffixProd = 1;

            prefixProd = prefixProd * nums[i];
            suffixProd = suffixProd * nums[n-i-1];

            ans = Math.max(ans, Math.max(prefixProd, suffixProd));

        }
        return ans;
    }
}
