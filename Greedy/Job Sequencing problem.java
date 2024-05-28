/*
    Company Tags      :    Flipkart, Accolite, Microsoft
    GFG Link          :    https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

*/

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
       
       Arrays.sort(arr, new Comparator<Job>() {
           
           public int compare(Job a, Job b) {
               
               return Integer.compare(b.profit, a.profit);
           }
       });
       
       
       int maxDeadline = -1;
       for(int i = 0; i  < n; i++){
           maxDeadline = Math.max(maxDeadline, arr[i].deadline);
       }
       
       int hash[] = new int[maxDeadline+1];
       Arrays.fill(hash, -1);
       
       int totalProfit = 0;
       int count = 0;
       
       for(int i = 0; i  < n; i++) {
           
           for(int j = arr[i].deadline; j >= 1; j--) {
               
               if(hash[j] == -1) { // no job done on this day or deadline time
                   
                   count += 1;
                   totalProfit += arr[i].profit;
                   hash[j] = arr[i].id;
                   break;
               }
           }
       }
       
       return new int[] {count, totalProfit};
    }
}
