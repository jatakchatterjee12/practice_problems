class Solution {
    long solve(int ri, int fi, List<Integer> robot, List<Integer> position, long[][] dp) {

        if(ri >= robot.size()) return 0;
        if(fi >= position.size()) return (long)1e12;

        if(dp[ri][fi] != -1){
            return dp[ri][fi];
        }

        long take_curr_factory = Math.abs(robot.get(ri) - position.get(fi)) + solve(ri+1, fi+1, robot, position, dp);
        long skip              = solve(ri, fi+1, robot, position, dp);

        return dp[ri][fi] =  Math.min(take_curr_factory, skip);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

      //Step:1
        Collections.sort(robot);
        Arrays.sort(factory, (a,b) -> a[0] - b[0]);

        //step 2 : expand factory to operate them easily for recursion
        List<Integer> position = new ArrayList<>();
        for(int i = 0; i < factory.length; i++){
            int pos = factory[i][0];
            int limit = factory[i][1];

            for(int j = 0; j < limit; j++){
                position.add(pos);
            }
        }

        int n = position.size();
        int m = robot.size();

        long[][] dp = new long[m+1][n+1];
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }

       // step :3
        return solve(0, 0, robot, position, dp);
    }
}
