class Solution {
    boolean possibleToDistribute(int x, int[] quantities, int shops){

        for(int product : quantities){

            shops -= (product+x-1)/x; // Math.ceil(product/x);
            
            if(shops < 0){
                return false;
            }
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        
        int m = quantities.length;
        int maxEl = Integer.MIN_VALUE;
        for(int q : quantities){
            maxEl = Math.max(q,maxEl);
        }

        int l = 1;
        int r = maxEl;

        int result = 0;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(possibleToDistribute(mid, quantities, n)){
                result = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return result;
    }
}
