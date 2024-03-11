class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        
        Arrays.sort(score, (a,b)-> b[k] - a[k]);
        return score;
    }
}

//

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        
        Arrays.sort(score, new Comparator<int[]>() {
            public int compare(int[] s1, int[] s2){
                if(s1[k] >= s2[k]) return -1;
                return 1;
            }
        });
        return score;
    }
}

//

class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        
        Comparator<int[]> myComp = new Comparator<int[]>() {

            public int compare(int[] s1, int[] s2) {
                if(s1[k] >= s2[k]) return -1;
                else return 1;
            }
        };
        Arrays.sort(score, myComp);
        return score;
    }
}
