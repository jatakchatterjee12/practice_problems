/*
              GFG LINK      ->      https://www.geeksforgeeks.org/problems/lcs-of-three-strings0028/1
*/
//************************************************* JAVA ********************************************//
// Approach- Bottom-Up(Both  C++ & JAVA)

//User function Template for Java
class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        char[] A1 = A.toCharArray();
        char[] B1 = B.toCharArray();
        char[] C1 = C.toCharArray();
        int[][][] t = new int[n1+1][n2+1][n3+1];
           
           for(int i=0; i<n1+1; i++){
               for(int j=0; j<n2+1; j++){
                   for(int k=0; k<n3+1; k++){
                       
                       if(i == 0 || j == 0 || k == 0){
                           t[i][j][k] = 0;
                       }
                       else if(A1[i-1] == B1[j-1] && B1[j-1] == C1[k-1]){
                           t[i][j][k] = 1 + t[i-1][j-1][k-1];
                       }
                       else{
                           t[i][j][k] = Math.max(t[i-1][j][k], Math.max(t[i][j-1][k], t[i][j][k-1]));
                       }
                   }
               }
           }
           return t[n1][n2][n3];
        
    }
}

//************************************************** C++ ***************************************************8//
class Solution
{
    public:

        int LCSof3 (string A, string B, string C, int n1, int n2, int n3)
        {
           int t[21][21][21];
           
           for(int i=0; i<n1+1; i++){
               for(int j=0; j<n2+1; j++){
                   for(int k=0; k<n3+1; k++){
                       
                       if(i == 0 || j == 0 || k == 0){
                           t[i][j][k] = 0;
                       }
                       else if(A[i-1] == B[j-1] && B[j-1] == C[k-1]){
                           t[i][j][k] = 1 + t[i-1][j-1][k-1];
                       }
                       else{
                           t[i][j][k] = max({t[i-1][j][k], t[i][j-1][k], t[i][j][k-1]});
                       }
                   }
               }
           }
           return t[n1][n2][n3];
        }
};
