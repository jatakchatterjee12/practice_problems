// class Pt{
//     int x; int y;
//     Pt(int x,int y){
//         this.x = x;
//         this.y = y;

//     }
// } . This will give TLE . use record
class Solution {
    record Pt(int x, int y) {}
    Map<Pt, Integer> costs = new HashMap<>();

    int getDistance(Pt from, Pt to){
        return Math.abs(from.x() - to.x()) + Math.abs(from.y() - to.y());
    }
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        Pt targetPt = new Pt(target[0], target[1]);
        Pt startPt = new Pt(start[0], start[1]);

        Queue<Object[]> que = new LinkedList<>();
        costs.put(startPt, 0);
        que.add(new Object[]{startPt, 0});

        int shortestPath = Integer.MAX_VALUE;

        while(!que.isEmpty()){
            Object[] ob = que.poll();
            Pt point = (Pt)ob[0];
            int costToThisPoint = (int)ob[1];

            if(costToThisPoint > costs.get(point)) continue;

            costs.put(point, costToThisPoint);
            shortestPath = Math.min(shortestPath, costToThisPoint + getDistance(point, targetPt));


            for(int[] road : specialRoads){
               
                Pt startOfRoad = new Pt(road[0], road[1]);
                Pt endOfRoad = new Pt(road[2], road[3]);
                int roadCost = road[4];
                int costToEndOfRoad = costToThisPoint + getDistance(point, startOfRoad) + roadCost;
                
                if(costToEndOfRoad >= costs.getOrDefault(endOfRoad, Integer.MAX_VALUE)){
                    continue;
                } 
            

                costs.put(endOfRoad, costToEndOfRoad);
                que.add(new Object[]{endOfRoad, costToEndOfRoad});
            }
        }
        return shortestPath;
    }
}
