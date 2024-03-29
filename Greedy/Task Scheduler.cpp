//***************************************************** C++ *************************************************************************//

class Solution {
public:
    int leastInterval(vector<char>& tasks, int p) {
        int n = tasks.size();
        
        if(p == 0)
            return n;
        
        /*
        
        ["A","A","A","B","B","B"], k = 2
        A-3
        b-3
        A _ _ A _ _ A
        Number of chunks     = freq('A')-1 = 2
        Number of idol spots = (Number of chunks)*(p) = 2*2 = 4
            
        Now, we will try to fill these 4 idol spots
        If at the end idol spots is 0, it means all idol spots were enough
        to accomodate all other taks. So, out result will be tasks.size();
        
        If, idol spots are not empty, it means that we need more spaces (equal to idol spots)
        than the tasks.size() to accomodate all tasks.
        So, result = tasks.size() + idol_spots
        
        */
        
        int counter[26] = {0};
        for(char &ch : tasks) {
            counter[ch-'A']++;
        }
        
        sort(begin(counter), end(counter));
        
        int chunks      = counter[25]-1;
        int idolSpots   = chunks*p;
        
        for(int i = 24; i>=0 ; i--) {
            idolSpots -= min(chunks, counter[i]);
        }
        
        if(idolSpots > 0)
            return n + idolSpots;
        
        return n;
    }
};

//************************************************** JAVA ********************************************************************************************
class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int size = tasks.length;

        int[] mp = new int[26];
        Arrays.fill(mp, 0);

        for(char ch : tasks) {
            mp[ch - 'A']++;
        }

       Arrays.sort(mp);

        int maxFreq = mp[25];
        int gaddha  = maxFreq - 1;
        int idleSlots = (gaddha * n);

        for(int i = 24; i >= 0; i--) {

            idleSlots -= Math.min(gaddha, mp[i]);
        }

        if(idleSlots > 0){
            return idleSlots + size;
        }

        return size;
    }
}
