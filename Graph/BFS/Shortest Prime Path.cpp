// GFG link - > https://www.geeksforgeeks.org/problems/shortest-prime-path--141631/1


//User function Template for C++
vector<string> primes;
bool computed = 0;
class Solution{   
public:
    void seive(){
        int n = 9999;
        vector<bool> prime(n+1, 1);
        prime[0] = prime[1] = 0;
        
        for(int i=2; i*i <= n; i++){
            if(prime[i]){
                for(int j=i*i; j <= n; j += i){
                    prime[j] = 0;
                }
            }
        }
        for(int i = 1000; i < n+1; i++){
            if(prime[i]){
                primes.push_back(to_string(i));
            }
        }
        computed = 1;
    }
    
    int solve(int num1,int num2)
    {   
      if(num1 == num2) return 0;
      
      if(!computed) seive();
      
      const int inf = 1e9;
      
      map<string,int> d_map;
      for(auto i : primes){
          d_map[i] = inf;
      }
      
      string start = to_string(num1);
      string end = to_string(num2);
      
      d_map[start] = 0;
      queue<string> q;
      q.push(start);
      
      while(!q.empty()){
          string cur = q.front();
          q.pop();
          
          for(int i=0;i<4;i++){
              for(char j = (i == 0 ? '1' : '0'); j <= '9'; j++){
                  
                  if(j != cur[i]){
                      string next = cur;
                      next[i] = j;
                      
                      auto ptr = d_map.find(next);
                      if(ptr != d_map.end() && ptr->second > d_map[cur] + 1){
                        ptr->second = d_map[cur] + 1;
                        q.push(next);
                        
                        if(next == end) return d_map[next];
                         
                      }
                  }
              }
          }
      }
      return -1;
    }
};
