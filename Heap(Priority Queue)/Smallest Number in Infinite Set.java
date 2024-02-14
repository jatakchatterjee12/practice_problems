/*
      I saw a lot of top solutions pushing 1-> 1000 numbers in pq/set which I personally dont find good enough

      APPROACH
      maintain a variable which points to the current smallest element untill addBack is called
      when addBack() is called only add elements to the set which were popped earlier i.e. smaller than cur
      when popSmallest() is called return the top most element in the set if it exists else return cur
      
      I believe this approach uses less time and space as the set only holds elements that were added back
      
*/


//******************************** C++ ***********************************//
class SmallestInfiniteSet {
public:
    int cur_small;
    set<int> st;
    SmallestInfiniteSet() {
        cur_small = 1;
    }
    
    int popSmallest() {
        if(st.size() > 0){
            int res = *st.begin();
            st.erase(res);
            return res;
        }
        else{
            cur_small += 1;
            return cur_small - 1;
        }
    }
    
    void addBack(int num) {
        if(cur_small > num) st.insert(num);
    }
};


//******************************** JAVA *********************************//
class SmallestInfiniteSet {
    int cur;
    Set<Integer> s;
    
    public SmallestInfiniteSet() {
        cur = 1;
        s = new HashSet<>();
    }
    
    public int popSmallest() {
        if (!s.isEmpty()) {
            int res = Collections.min(s);
            s.remove(res);
            return res;
        } else {
            cur++;
            return cur - 1;
        }
    }
    
    public void addBack(int num) {
        if (cur > num) {
            s.add(num);
        }
    }
}
