//Approach 1: Using Max Heap

//Tc- O(M * N * logK)
//SC- O(k)
class Solution { 
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length; // For general, the matrix need not be a square
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                maxHeap.offer(matrix[r][c]);
                if (maxHeap.size() > k) maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }
}



//Approach 2: Using Min-Heap (More Efficient)

//TC - (k logk)
//SC - O(k)

class Solution {
    public int kthSmallest(int[][] m, int k) {
        int n = m.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]- b[0]); // min heap
        
        for(int r = 0; r < Math.min(n, k); r++) {
            pq.add(new int[]{m[r][0], r, 0});
        }

        int ans = -1;

        for(int i = 1; i <= k; i++) {

            int[] vec = pq.poll();
            int r = vec[1];
            int c = vec[2];

            ans = vec[0];

            if(c + 1 < n){
                pq.add(new int[]{ m[r][c+1], r, c+1});
            }
        }

        return ans;

    }
}


//Approach 3: Binary Search
//TC - O((M+N) * logD) ( D = max diff betwwen two elements)
//SC - O(1)

class Solution { // 0 ms, faster than 100%
    int m, n;
    public int kthSmallest(int[][] matrix, int k) {
        m = matrix.length; n = matrix[0].length; // For general, the matrix need not be a square
        int left = matrix[0][0], right = matrix[m-1][n-1], ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (countLessOrEqual(matrix, mid) >= k) {
                ans = mid;
                right = mid - 1; // try to looking for a smaller value in the left side
            } else left = mid + 1; // try to looking for a bigger value in the right side
        }
        return ans;
    }
    int countLessOrEqual(int[][] matrix, int x) {
        int cnt = 0, c = n - 1; // start with the rightmost column
        for (int r = 0; r < m; ++r) {
            while (c >= 0 && matrix[r][c] > x) --c;  // decrease column until matrix[r][c] <= x
            cnt += (c + 1);
        }
        return cnt;
    }
}
