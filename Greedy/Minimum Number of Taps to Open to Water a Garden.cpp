class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
        
        vector<int> StartEnd(n+1, 0);

        for(int i = 0; i <= n; i++){

            int left = max(0, i-ranges[i]);
            int right = min(n, i+ranges[i]);

            StartEnd[left] = max(StartEnd[left] , right);
        }

        int taps = 0 , maxEnd = 0, curEnd = 0;

        for(int i = 0; i <= n; i++){

            if(i > maxEnd) return -1;

            if(i > curEnd){
                taps++;
                curEnd = maxEnd;
            }

            maxEnd = max(maxEnd, StartEnd[i]);
        }

        return taps;
    }
};
