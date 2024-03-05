/*
    Company Tags   : Flipkart, Amazon, Microsoft, MakeMyTrip, Adobe, BankBazaar, Myntra
    GFG  Link      : https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
*/

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long merge(long arr[], long l , long mid, long r) {
        ArrayList<Long> tmp = new ArrayList<>();
        
        long cnt = 0;
        
        long i = l;
        long j = mid+1;
        
        while(i <= mid && j <= r) {
            if(arr[(int)i] <= arr[(int)j]) {
                tmp.add(arr[(int)i]);
                i++;
            }
            else{
                tmp.add(arr[(int)j]);
                
                cnt += (mid - i + 1); // arr[j] < arr[i]
                
                j++;
            }
            
        }
        
        while(i <= mid){
            tmp.add(arr[(int)i]);
            i++;
          
        }
        
        while(j <= r) {
           tmp.add(arr[(int)j]);
            j++;
           
        }
        
        //copy the data from tmp to original array
        for(long it = l; it<= r; it++) {
            arr[(int)it] = tmp.get((int)(it-l));
        }
        
        return cnt;
        
    }
    static long mergeSort(long arr[], long l, long r) {
        long cnt = 0;
        if(l >= r) return cnt;
        
        long mid  = l + (r-l)/2;
        cnt += mergeSort(arr, l, mid);
        cnt += mergeSort(arr, mid+1, r);
            
        cnt += merge(arr, l, mid, r);
            
        return cnt;
    }
    static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr, 0, N-1);
        
    }
}

// Code Studio Link  : https://www.codingninjas.com/studio/problems/number-of-inversions_6840276
import java.io.*;
import java.util.*;
public class Solution {
    static int cnt = 0;

    static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> tmp = new ArrayList<>();

        int left = low; 
        int right = mid+1;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]) {
                tmp.add(arr[left]);
                left++;
            }
            else{
                tmp.add(arr[right]);
                cnt += (mid-left+1);
                right++;
            }
        }

        while(left <= mid){
            tmp.add(arr[left]);
            left++;
        }

        while(right <= high){
            tmp.add(arr[right]);
            right++;
        }

        //copy the data to original array
        for(int i=low; i<=high; i++) {
            arr[i] = tmp.get(i-low);
        }
    }
    static void mergeSort(int[] arr, int low, int high){
        if(low >= high) return;

        int mid = low + (high- low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        merge(arr, low, mid, high);
    }
    
    public static int numberOfInversions(int []a, int n) {
        mergeSort(a, 0, n-1);
        return cnt;
    }
}
