

// MArking baskets[j] = 0 (marked and cannot use for further fruits) 
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        
        int n = fruits.length;
        int ans = n;

        for(int i = 0; i < n; i++){

            for(int j = 0; j < n; j++){
                if(fruits[i] <= baskets[j]){
                    ans--;
                    baskets[j] = 0;
                    break;
                }
            }
        }
        return ans;
    }
}


//Using Set
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        
        int n = fruits.length;
        int ans = n;

        Set<Integer> st = new HashSet<>();

        for(int i = 0; i < n; i++){

            for(int j = 0; j < n; j++){
                if(fruits[i] <= baskets[j] && !st.contains(j)){
                    ans--;
                    st.add(j);
                    break;
                }
            }
        }
        return ans;
    }
}
