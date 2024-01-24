//****************************** JAVA ****************************//
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        int n = g.length;
        int m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int i=0,j=0;
        while(i<n && j<m){

            if(g[i] <= s[j]){ // satisfiable
                i++;
            }
            j++;
        }
        return i;
    }
}

//************************************* C++ ***********************************//
class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        int i=0,j=0;
        while(i < g.size() && j < s.size()){
            if(g[i] <= s[j]){
                i++; // SATISFIABLE
            }
            j++;   
        }
        return i;
    }
};
