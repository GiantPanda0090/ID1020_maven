package lab3_backup;

/**
 * Created by AlstonQiLee on 2016-11-16.
 */
public class linkedlist {
    static int length;
    static Node first;
    //static int offset;
    public linkedlist(){
        this.length=0;
        this.first = new Node();
    }
public static void add(int item){
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    length++;
}
    public int delete() {
        int item = first.item;
        first = first.next;
        length--;
        return item;
    }
    public boolean isEmpty()
    { return first == null; }

public int printLength(){
    return length;
}
    public static void Swap(Node item1,Node item2){
        Node old =item2;
        item1.next = old.next;
        item2.next=item1;

    }
    private static class Node {
        int item;
        Node next;
    }
}
