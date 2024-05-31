class Solution 
{
    
    static class Data{
        int start, end, pos;
        Data(int start, int end, int pos ) {
            this.start = start;
            this.end  = end;
            this.pos = pos;
        }
        Data(){
            
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        
        Data[] arr = new Data[n];
        
        for(int i = 0;  i <  n; i++) {
            
            arr[i] = new Data();
            
            arr[i].start = start[i];
            arr[i].end = end[i];
            arr[i].pos = i+1; // 1 based
        }
        
        Arrays.sort(arr, new Comparator<Data>(){
            
            public int compare(Data a, Data b) {
                
                return Integer.compare(a.end, b.end);
            }
        });
        
        
        int count = 1;
        int freeTime = arr[0].end;
        List<Integer> order = new ArrayList<>();
        order.add(arr[0].pos);
        
        for(int i = 1; i < n; i++) {
            
            if(arr[i].start > freeTime) {
                
                count += 1;
                order.add(arr[i].pos);
                freeTime = arr[i].end; 
                
            }
        }
        
        return count;
        
    }
}
