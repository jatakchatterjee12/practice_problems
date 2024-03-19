/*
    Company Tags  : Facebook
    Leetcode Link : https://leetcode.com/problems/task-scheduler/
    
    Greedy approach : https://github.com/jatakchatterjee12/practice_problems/blob/main/Greedy/Task%20Scheduler.cpp
*/

//********************************************************************* C++ ****************************************************8//
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        vector<int> mp(26, 0);

        for(char &ch : tasks){
            mp[ch - 'A']++;
        }

        int time = 0;

        priority_queue<int> pq; // max-heap;
        for(int i = 0; i < 26; i++) {
            if(mp[i] != 0) {
                pq.push(mp[i]);
            }
        }

        while(!pq.empty()) {

            vector<int> temp;

            for(int i = 1; i <= n+1; i++) {

                if(!pq.empty()){
                    int freq = pq.top();
                    pq.pop();

                    freq--;
                    temp.push_back(freq);

                }
            }

            for(int &f : temp){
                if(f > 0){
                    pq.push(f);
                }
            }

            if(pq.empty()) {
                time += temp.size();
            }
            else{
                time += (n+1); 
            }
        }
        return time;
    }
};


//********************************************************************8 JAVA ********************************************************//
class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] count = new int[26];
        for(char ch : tasks) {
            count[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a); //max-heap
        for(int f : count){
            if(f > 0){
                pq.add(f);
            }
        }

        int time = 0;

        while(!pq.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            for(int i = 1; i <= n+1; i++) {

                if(!pq.isEmpty()) {
                    int freq = pq.poll();

                    freq--;
                    temp.add(freq);
                }
            }


            for(int it : temp){
                if(it != 0){
                    pq.add(it);
                }
            }

            if(pq.isEmpty()) {
                time += temp.size();
            }
            else{
                time += n+1;
            }
            
        }
        return time;
    }
}
