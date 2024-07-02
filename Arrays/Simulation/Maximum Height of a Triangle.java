class Solution {
    int solve(int a, int b){
        int c = 0; // max height it can form
        int l = 1; // row number
        int fl = 0; // 0 -> a's  turn , 1 -> b's turn... start with a 

        while(a > 0 || b > 0) {
            if(fl == 0) {
                if(a >= l){
                    a = a-l;
                }
                else{
                    break;
                }
            }
            else{
                if(b >= l){
                    b = b-l;
                }
                else{
                    break;
                }
            }

            c++;
            l++;
            fl = 1 - fl;
        }
        return c;
    }
    public int maxHeightOfTriangle(int red, int blue) {
        int k1 = solve(red, blue); //start with red 
        int k2 = solve(blue, red); // start with blue
        return Math.max(k1, k2); // return  the max form them
    }
}
