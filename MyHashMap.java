import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhao on 2018/9/10.
 */
public class MyHashMap implements MyMap{
    static class Node implements Map.Entry{
        int hash;
        Object key;
        Object value;
        Node next;
        Node(int hash,Object key,Object value,Node next) {
            this.hash=hash;
            this.key=key;
            this.value=value;
            this.next=next;

        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public Object setValue(Object value) {
            this.value=value;
            return value;
        }
    }
    private final int DEFALUT_CAPACITY=16;
    Node[] table=new Node[DEFALUT_CAPACITY];
    private int size=0;
    public static void main(String[] args)
    {
        HashMap hashMap=new HashMap();
        hashMap.put("aaa","1111");
        hashMap.put("bbb","222");
        hashMap.put("ccc","3333");
        hashMap.put("bbb","456");
        System.out.println(hashMap.get("bbb"));

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public Object get(Object key) {
        int hashValue=hash(key);
        int i=indexFor(hashValue,table.length);
        for(Node node=table[i];node!=null;node=node.next){
            if(node.key.equals(key)&&hashValue==node.hash){//？？？
                return node.value;
            }
        }
        return null;
    }

    public Object put(Object key, Object value) {
        //通过key,求hash值
        int hashValue=hash(key);
        int i=indexFor(hashValue,table.length);
        for(Node node=table[i];node!=null;node=node.next)
        {
            Object k;
            if(node.hash==hashValue && ((k=node.key)==key || key.equals(k))){
                Object oldValue=node.value;
                node.value=value;
                return oldValue;

            }
        }
        //如果i位置没有数据，或者i位置有数据，但是key是新的key，则新增节点
        addEntry(key,value,hashValue,i);
        return null;
    }
    public void addEntry(Object key,Object value,int hashValue,int i){
        //V如果超过了数组原始的大小，则扩大数组
        if(++size==table.length){
            Node[] newTable=new Node[table.length*2];
            System.arraycopy(table,0,newTable,0,table.length);
            table=newTable;
        }
        //得到i位置的数据
        Node eNode=table[i];
        //新增节点，将该节点的next值指向前一个节点
        table[i]=new Node(hashValue,key,value,eNode);
    }
    public int indexFor(int hashValue,int length){
        return hashValue%length;
    }
    public int hash(Object key){
        return key.hashCode();
    }
}
