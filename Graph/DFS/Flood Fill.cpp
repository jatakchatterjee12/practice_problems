//************************************************* C++ &*********************************************************//
class Solution {
public:
    void dfs( int sr, int sc,int iniColor,vector<vector<int>> &ans,vector<vector<int>> &image,int newColor,int n,int m,  vector<pair<int,int>> &directions){
        
        ans[sr][sc] = newColor;
        
        for(auto &it : directions){
            
            int x_ = sr + it.first;
            int y_ = sc + it.second;
            
            if(x_ >= 0  && x_< n && y_>=0 && y_ <m && image[x_][y_] == iniColor && ans[x_][y_] != newColor){
                
                dfs(x_,y_,iniColor,ans,image,newColor,n,m,directions);
            }
        }

    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newC) {
        int n = image.size();
        int m = image[0].size();
        
        vector<vector<int>> ans = image;
        
        int iniColor = image[sr][sc];
        vector<pair<int,int>> directions ={{-1,0},{0,1},{1,0},{0,-1}};
        
        dfs(sr,sc,iniColor,ans,image,newC,n,m,directions);
        return ans;
    }
};


//***************************************************88 JAva*******************************************888//
class Solution {
    private void dfs( int sr, int sc,int[][] ans,int[][] image,int iniC, int newC, int n,int m, int[][] directions){

        ans[sr][sc] = newC;

        for(int[] dir : directions){

            int x = sr + dir[0];
            int y = sc + dir[1];

            if(x >= 0 && x <n && y >= 0 && y < m && image[x][y] == iniC && ans[x][y] != newC){

                dfs(x,y,ans,image,iniC,newC,n,m,directions);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newC) {
        int iniC = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        
        int[][] ans = image;
        
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        
        dfs(sr,sc,ans,image,iniC,newC,n,m,directions);
        return ans;
    }
}
