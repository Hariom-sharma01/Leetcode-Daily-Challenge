class LRUCache {
    int cap;
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    HashMap<Integer,Node> map=new HashMap<>();
    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node nn=map.get(key);
            remove(nn);
            insert(nn);
            return nn.value;
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
    public void remove(Node nn){
        map.remove(nn.key);
        nn.prev.next=nn.next;
        nn.next.prev=nn.prev;
    }
    public void insert(Node nn){
        map.put(nn.key,nn);
        nn.next=head.next;
        head.next.prev=nn;
        head.next=nn;
        nn.prev=head;
    }
}
class Node{
    int key,value;
    Node next,prev;
    Node(int k,int v){
        key=k;
        value=v;
        next=null;
        prev=null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */