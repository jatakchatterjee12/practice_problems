/*
From the beginning I used a Map<Integer, Set<Integer>> to represent reserved seats as a graph.
But then I realized that we can use a bit vector instead of Set<Integer>.

Also, seats 2,3,4,5 can be represented as (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) = 60, for example.
So, I use this value to check whether the seats 2,3,4,5 are available when traversing the graph (together with 6,7,8,9 and 4,5,6,7).
*/ 

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> graph = new HashMap<>();
        for (int[] reserved : reservedSeats) {
            int row = reserved[0];
            int col = reserved[1];
            graph.put(row, graph.getOrDefault(row, 0) | (1 << col)); // create a bit vector of reserved seats
        }
        int max = 0;
        for (int row : graph.keySet()) {
            int reserved = graph.get(row);
            int cnt = 0;
            if ((reserved &  60) == 0) cnt += 1; // check if seats 2,3,4,5 are available
            if ((reserved & 960) == 0) cnt += 1; // check if seats 6,7,8,9 are available
            if ((reserved & 240) == 0 && cnt == 0) cnt = 1; // check if seats 4,5,6,7 are available
            max += cnt;
        }
        return max + 2 * (n - graph.size());
    }
}
