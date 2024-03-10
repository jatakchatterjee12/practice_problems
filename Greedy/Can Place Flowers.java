// 
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}

//
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int m = flowerbed.length;
        if(m == 1 && flowerbed[0] == 0 && n == 1)return true;
        int i = 0;
        int cnt = 0;

        while(i < m) {

            if(i == 0 && i < m-1 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                 cnt++;
                 i+=2;
                 continue;
            }
            else if(i == m-1 && i > 0 && flowerbed[i] == 0 && flowerbed[i-1] == 0) {
                 cnt++;
                 i+=2;
                 continue;
            }
            else {
                if( i > 0 &&  i < m-1 && flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                    cnt++;
                    i+=2;
                    continue;
                }
            }
            i++;
        }
        return cnt >= n;
    }
}
