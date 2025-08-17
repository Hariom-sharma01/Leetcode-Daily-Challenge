class LRUCache {
    int cap;
    HashMap<Integer,Node> map;
    Node head=new Node(0,0);
    Node tail=new Node(0,0);

    public LRUCache(int capacity) {
        cap=capacity;
        map=new HashMap<>();
        head.next=tail;
        tail.prev=head;
        
    }
    public void insert(Node n){
        map.put(n.key,n);
        n.next=head.next;
        head.next=n;
        n.prev=head;
        n.next.prev=n;
    }
    public void remove(Node n){
        map.remove(n.key);
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node nn=map.get(key);
            remove(nn);
            insert(nn);
            return nn.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==cap){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
}
class Node{
        int key;
        int val;
        Node prev,next;
         Node(int k,int v){
            key=k;
            val=v;
            prev=null;
            next=null;
         }
        
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */