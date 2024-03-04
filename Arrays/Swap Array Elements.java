// swap ith element with i+2th element
class Solution
{
    public void swapElements(int[] arr, int n)
    {
       for(int i = 0; i < n-2; i++) {
           
           int t = arr[i];
           arr[i] = arr[i+2];
           arr[i+2] = t;
       }
    }
}
