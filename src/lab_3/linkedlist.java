package lab_3;


/**
 * Created by AlstonQiLee on 2016-11-16.
 * linkedlist modified for bubblesort
 */
public class linkedlist {
    /* public variable*/
    static int length;
    static Node first = null;
    static Node head = new Node();
    static int listindex;
    static int invcounter;
    static int swapcounter;
    // constructor
    public linkedlist() {
        this.length = 0;
        head.head = "head";//signature of a head
        head.next = first;
        listindex=0;
        invcounter=0;
        swapcounter=0;
    }

    //add node into linked list
    public static void add(int item) {
        Node oldfirst;
        oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        first.index=listindex;
        head.next = first;
        length++;
        listindex++;
       // System.out.print(first.index);
    }

    //check inverstion (recursive way) O(N)? ASK!!
    public static void checkinv(Node check,int l){

        Node com;
        com = check.next;
        if(com.next ==null){
            return ;
        }
        else {
            for (int i = 0; i < l - 1; i++) {
                //System.out.println(check.item+ " "+com.item);
                //System.out.println(check.index+ " "+com.index);
                //System.out.println("     ");
                if (check.item < com.item) {
                   // System.out.print("11111111");
                    if (check.index > com.index) {
                        invcounter++;

                    }
                }
                com = com.next;
            }
            checkinv(check.next, l - 1);
        }
        return ;
    }
//bubble sort swap counter
    public static int swapcounter(){
        return swapcounter;
    }
    public static void bubblesort() {
//initialize nessasary variable
        boolean swapped;
        int R;
        int n = length;
        R = n - 2;
        swapped = true;

        while (R >= 0 && swapped == true) {
            swapped = false;

            Node pre = head;
            Node p1 = first;
            Node p2 = first.next;
            for (int i = 0; i <= R; i++) {

                //debug
                /*
                System.out.println( R +" "+ i);
                System.out.println("pre is  "+pre.item);
                System.out.println("p1 is  "+p1.item);
                System.out.println("p2 is  "+p2.item);
                */

                //check order
                if (p2.item < p1.item) {
                    swapped = true;
                    swap(pre, p1, p2);//swap
                }//if end
                //move the curser to next one
                pre = pre.next;
                p1 = pre.next;
                p2 = p1.next;
//System.out.print( R +" "+ i);
                // printlist();
            }//for end
            R = R - 1;
        }//while end
        System.out.println("  ");
        System.out.println(" ---------------------- ");
        System.out.println(" Bubble sort done!! ");
        System.out.println( " ---------------------- ");
                System.out.println("  ");
    }

    /* swap method modified for bubble sort. idea from homework 2 */
    public static void swap(Node pre, Node p1, Node p2) {

        if (p1 == null || p2 == null) {
            return;
        }
        if (pre.head == "head") {
            first = p2;
            //head.next = p2;
        }
        pre.next = p2;
        Node t = p2.next;
        p2.next = p1;
        pre = p1;
        p1.next = t;

        swapcounter++;
    }

    // print out the linked list
    public static void printlist() {
        Node save;
        save = head.next;
        System.out.println("Linked printed:");
        for (int i = 0; i < length; i++) {

            if (save != null) {
                System.out.print(save.item + " , ");
                save = save.next;
            }
        }
        System.out.println(" ");
    }
    //print the index for inversion debuging only
    public static void printindex() {
        Node save;
        save = head.next;
        System.out.println("Index printed:");
        for (int i = 0; i < length; i++) {

            if (save != null) {
                System.out.print(save.index + " , ");
                save = save.next;
            }
        }
        System.out.println(" ");
    }
    /*NOT IMPLEMENTED!! linkedlist delet item. debug only*/
    public int delete() {
        int item = first.item;
        first = first.next;
        length--;
        return item;
    }

    /*NOT IMPLEMENTED!! DEBUG ONLY CHECK IF LINKED LIST IS EMPTY*/
    public boolean isEmpty() {
        return first == null;
    }

    // out put the length of the linked list used for getting value of n NOT IMPLEMENTED!!
    public int printLength() {
        return length;
    }

    /* inner class node*/
    private static class Node {
        int item;
        String head;
        Node next;
        int index;
    }
}
