class Solution {
    public boolean checkRecord(String s) {
        
        int n = s.length();
        int A = 0;
        int consec_L = 0;

        for(char ch : s.toCharArray()) {

            if(ch == 'L'){
                consec_L++;
                if(consec_L >= 3) return false;
            }

            else {
                if(ch == 'A'){
                    A++;
                    if(A >= 2) return false;
                }   

                consec_L = 0;                      

            }
  
            
        }
        return true;
    }
}
