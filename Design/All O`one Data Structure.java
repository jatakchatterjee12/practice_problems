/*      
    Company Tags  : Google
    Leetcode Link : https://leetcode.com/problems/all-oone-data-structure/
*/


/***************************************************************** C++ *****************************************************************/
//Approach (Using map + dll)
//T.C : O(1)
//S.C : O(n) , map stores n strings
class AllOne {
private:
    // Doubly Linked List node to store count and a set of strings with that count
    struct Node {
        int count;
        list<string> keys; //You should use an unordered_set<string> here because it will have Amortized O(1) time complexity for erase() function.
        Node *prev, *next;
        Node(int c) : count(c), prev(nullptr), next(nullptr) {}
    };
    
    // Hash map to store key -> count
    unordered_map<string, Node*> mp;

    // Head and tail pointers for the doubly linked list
    Node *head, *tail;

    // Add a new node with count `c` after node `prevNode`
    Node* addNodeAfter(Node *prevNode, int count) {
        Node *newNode = new Node(count);
        newNode->next = prevNode->next;
        newNode->prev = prevNode;
        if (prevNode->next) {
            prevNode->next->prev = newNode;
        }
        prevNode->next = newNode;
        if (tail == prevNode) {
            tail = newNode;
        }
        return newNode;
    }

    // Remove the node from the doubly linked list
    void removeNode(Node *node) {
        node->prev->next = node->next;
        if (node->next) {
            node->next->prev = node->prev;
        }
        if (tail == node) {
            tail = node->prev;
        }
        delete node;
    }

public:
    AllOne() {
        // Initialize head and tail dummy nodes for the doubly linked list
        head = new Node(0);
        tail = head;
    }

    void inc(string key) {
        if (mp.find(key) == mp.end()) {
            // Key doesn't exist, add it to the list after the head with count 1
            if (head->next == nullptr || head->next->count != 1) {
                addNodeAfter(head, 1);
            }
            head->next->keys.push_front(key);
            mp[key] = head->next;
        } else {
            // Key exists, move it to the next count
            Node *curNode = mp[key];
            int curCount = curNode->count;
            if (curNode->next == nullptr || curNode->next->count != curCount + 1) {
                addNodeAfter(curNode, curCount + 1);
            }
            curNode->next->keys.push_front(key);
            mp[key] = curNode->next;
            curNode->keys.remove(key);
            if (curNode->keys.empty()) {
                removeNode(curNode);
            }
        }
    }

    void dec(string key) {
        Node *curNode = mp[key];
        int curCount = curNode->count;
        
        // Remove the key if count becomes zero
        curNode->keys.remove(key);
        if (curCount == 1) {
            mp.erase(key);
        } else {
            // Move it to the previous count
            if (curNode->prev == head || curNode->prev->count != curCount - 1) {
                addNodeAfter(curNode->prev, curCount - 1);
            }
            curNode->prev->keys.push_front(key);
            mp[key] = curNode->prev;
        }
        
        // Remove the current node if it has no more keys
        if (curNode->keys.empty()) {
            removeNode(curNode);
        }
    }

    string getMaxKey() {
        return (tail == head) ? "" : tail->keys.front();
    }

    string getMinKey() {
        return (head->next == nullptr) ? "" : head->next->keys.front();
    }
};



/***************************************************************** JAVA *****************************************************************/
//Approach (Using map +  dll)
//T.C : O(1)
//S.C : O(n) , map stores n strings
class AllOne {

    class Node{
        int count;
        List<String> keys;
        Node prev;
        Node next;

        Node(int c){
            count = c;
            prev=null;
            next=null;
            keys = new ArrayList<>();
        }
    }

    Map<String, Node> mp = new HashMap<>();

    Node head; // this is our first.
    // Node first; // min key string
    Node last; //max key string


    void addNodeAfter(Node prevNode, int count){
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        if(newNode.next != null){
            newNode.next.prev = newNode;
        }
        
        prevNode.next = newNode;
        if(prevNode == last){
            last = newNode; // last node update
        }

    }

    void removeNode(Node node){
        node.prev.next = node.next;
        if(node.next != null){
            node.next.prev = node.prev;
        }

        if(last == node){
            last = node.prev;
        }
    }

    public AllOne() {

        head = new Node(0);
        last = head;
        
    }
    
    public void inc(String key) {
        if(!mp.containsKey(key)){
            //not exists
            // check if there is already a node with count = 1
            if(head.next == null || head.next.count != 1){
                addNodeAfter(head, 1);
            }

            head.next.keys.add(key);
            mp.put(key, head.next);
        }
        else{
            // key is already there in mp
            //increase its freq -> move to +1 freq node

            Node currNode = mp.get(key);
            int currCount = currNode.count;
            if(currNode.next == null || currNode.next.count != currCount+1){
                addNodeAfter(currNode, currCount+1);
            }

            currNode.next.keys.add(key);
            mp.put(key, currNode.next);

            currNode.keys.remove(key);
            if(currNode.keys.size() == 0) {
                removeNode(currNode);
            }
        }
    }
    
    public void dec(String key) {
        Node currNode = mp.get(key);
        int currCount = currNode.count;

        if(currCount == 1){
            mp.remove(key);
        }
        else{
            if(currNode.prev == null || currNode.prev.count != currCount - 1){
                addNodeAfter(currNode.prev, currCount-1);
            }

            currNode.prev.keys.add(key);
            mp.put(key, currNode.prev);
        }

        currNode.keys.remove(key);
        if(currNode.keys.size() == 0) {
            removeNode(currNode);
        }
    }
    
    public String getMaxKey() {
        if(last == head){
            return "";
        }
        
        return last.keys.get(0);
    }
    
    public String getMinKey() {
        if(head.next == null){
            return "";
        }
        
        return head.next.keys.get(0);
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */



//Approach (Using map +  dll)
//T.C : O(1)
//S.C : O(n) , map stores n strings
class AllOne {
    // Doubly Linked List node to store count and a set of strings with that count
    private class Node {
        int count;
        LinkedHashSet<String> keys; // LinkedHashSet maintains the order of insertion
        Node prev, next;
        
        Node(int c) {
            count = c;
            keys = new LinkedHashSet<>();
        }
    }
    
    // Hash map to store key -> count node
    private Map<String, Node> keyCountMap;
    
    // Head and tail pointers for the doubly linked list
    private Node head, tail;
    
    public AllOne() {
        keyCountMap = new HashMap<>();
        // Initialize head and tail dummy nodes for the doubly linked list
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    // Add a new node with count `c` after node `prevNode`
    private Node addNodeAfter(Node prevNode, int count) {
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        return newNode;
    }

    // Remove the node from the doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void inc(String key) {
        if (!keyCountMap.containsKey(key)) {
            // Key doesn't exist, add it to the list after the head with count 1
            if (head.next == tail || head.next.count != 1) {
                addNodeAfter(head, 1);
            }
            head.next.keys.add(key);
            keyCountMap.put(key, head.next);
        } else {
            // Key exists, move it to the next count
            Node curNode = keyCountMap.get(key);
            int curCount = curNode.count;
            if (curNode.next == tail || curNode.next.count != curCount + 1) {
                addNodeAfter(curNode, curCount + 1);
            }
            curNode.next.keys.add(key);
            keyCountMap.put(key, curNode.next);
            curNode.keys.remove(key);
            if (curNode.keys.isEmpty()) {
                removeNode(curNode);
            }
        }
    }

    public void dec(String key) {
        if (!keyCountMap.containsKey(key)) {
            return;
        }
        
        Node curNode = keyCountMap.get(key);
        int curCount = curNode.count;
        
        // Remove the key from the current node
        curNode.keys.remove(key);
        
        if (curCount == 1) {
            // Remove the key entirely if the count is 1
            keyCountMap.remove(key);
        } else {
            // Move the key to the previous count node
            if (curNode.prev == head || curNode.prev.count != curCount - 1) {
                addNodeAfter(curNode.prev, curCount - 1);
            }
            curNode.prev.keys.add(key);
            keyCountMap.put(key, curNode.prev);
        }
        
        // Remove the current node if it has no more keys
        if (curNode.keys.isEmpty()) {
            removeNode(curNode);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}
