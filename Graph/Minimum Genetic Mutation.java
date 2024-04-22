// Same Pattern like ---> Open The Lock, Word ladder, Sequencial Digits

class Solution {
    void fillGenes(Queue<String> que, StringBuilder curr, Set<String> st, Set<String> vis) {

        char[] charSet = new char[] {'A', 'C', 'G', 'T'};

        for(int i = 0; i < 8; i++) {

            char ch = curr.charAt(i);

            for(char c : charSet) {
                curr.setCharAt(i, c);
                String next = curr.toString();
                if(!vis.contains(next) && st.contains(next)) {
                    que.add(next);
                    vis.add(next);
                }
            }

            curr.setCharAt(i, ch);

        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> st = new HashSet<>();
        for(String gene : bank){
            st.add(gene);
        }

        Queue<String> que = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        que.add(startGene);
        vis.add(startGene);

        int level = 0;
        while(!que.isEmpty()){
            int n = que.size();

            while(n-- > 0) {

                String curr = que.poll();

                if(curr.equals(endGene)){
                    return level;
                }

                StringBuilder currSb = new StringBuilder(curr);
                fillGenes(que, currSb, st, vis);
            }
            level++;
        }
        return -1;
    }
}



//Without visited Set... directly remove from the allowed genes set

class Solution {
    void fillGenes(Queue<String> que, StringBuilder curr, Set<String> st) {

        char[] charSet = new char[] {'A', 'C', 'G', 'T'};

        for(int i = 0; i < 8; i++) {

            char ch = curr.charAt(i);

            for(char c : charSet) {
                curr.setCharAt(i, c);
                String next = curr.toString();
                if(st.contains(next)) {
                    que.add(next);
                    st.remove(next);
                }
            }

            curr.setCharAt(i, ch);

        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> st = new HashSet<>();
        for(String gene : bank){
            st.add(gene);
        }

        Queue<String> que = new LinkedList<>();
        

        que.add(startGene);
        

        int level = 0;
        while(!que.isEmpty()){
            int n = que.size();

            while(n-- > 0) {

                String curr = que.poll();

                if(curr.equals(endGene)){
                    return level;
                }

                StringBuilder currSb = new StringBuilder(curr);
                fillGenes(que, currSb, st);
            }
            level++;
        }
        return -1;
    }
}
