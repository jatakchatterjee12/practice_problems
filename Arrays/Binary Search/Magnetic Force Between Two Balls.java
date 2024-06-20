class Solution {
    private boolean possible(int[] position, int m, int force) {

        int lastPos = position[0];
        int cnt = 1;

        for(int i = 1; i < position.length; i++) {
            if(position[i] - lastPos >= force){
                cnt++;
                lastPos = position[i];
            }
            if(cnt >= m){
                return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int minForce = 0;
        int maxForce = position[n-1];

        int result = 0;

        while(minForce <= maxForce) {

            int mid = minForce + (maxForce- minForce)/2;

            if(possible(position, m, mid)){
                result = mid;
                minForce = mid+1;
            }
            else{
                maxForce = mid-1;
            }
        }
        return result;
    }
}
