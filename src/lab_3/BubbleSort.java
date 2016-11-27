package lab_3;

//import lab2.linkedlist;

/**
 * Created by AlstonQiLee on 2016-11-16.
 * bubblesort lunch psvm
 */
public class BubbleSort {
    public static void main(String[] args) {
        linkedlist sortlist = new linkedlist();
        int arr[] = {1,2,3,4,5,0};//input value
        //linked list input
        for (int i = 0; i < arr.length; i++) {
            sortlist.add(arr[i]);
        }
        System.out.println("  ");
        System.out.println(" ---------------------- ");
        System.out.println(" Origianl linked list ");
        System.out.println( " ---------------------- ");
        System.out.println("  ");

        sortlist.printlist();//before sorted PRINT
        sortlist.printindex();//before sorted index
        sortlist.checkinv(sortlist.first,sortlist.printLength());
        System.out.println("list has "+ sortlist.invcounter+" inversion.");
       sortlist.bubblesort();//bubble sort activated
       sortlist.printlist();//after sorted PRINT
        sortlist.printindex();//after sorted index!!
        System.out.print("bubble sort has swap it "+ sortlist.swapcounter()+" times.");//print out result for testing
        //System.out.println(sortlist.printLength());//debug
    }
}
/**
 * answer for 2.2 3)
 * answer found from stack overflow
 * In an unstable algorithm, straw or spork may be interchanged, but in stable sort, they stay in the same
 * relative positions (that is, since 'straw' appears before 'spork' in the input, it also appears before 'spork' in the output).
 *
 * summerize in my own words
 * unstable sort will destroy the first come first serve rule. it swap in both > and >=. might cause trouble in for example
 * ticket selling system. apartment queing system. etc
 * stable sort only compare >. it wont swap in =
 */
/*
*answer for 2.3
* swap is double than the orignial list inversion
* no idea why? remember to ask on friday labatory
 */
