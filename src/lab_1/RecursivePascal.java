package lab_1;

/**
 * Created by AlstonQiLee on 2016-11-03.
 * recurtion bionormial pascal triangle
 */
public class RecursivePascal {
    static boolean inv;// invert the triangle or not
     static int save; //inver save value for n


    public static void main(String[] args) {
//System.out.println(binom(2,3));
        // main method- pascal method call with out static
        RecursivePascal a = new RecursivePascal();
        int n =4;
        save =n;
        inv =true;
        //if invert is false reset the direction of the triangle( from 0 to max)
        if (!inv){
            n=0;
        }
        //otherwise do inverse( from max to 0)
        a.printPascal(n);
    }


    // print pascal triangle
    public void printPascal(int n){
// non invert triangle
        int star = ((save+1)-n)/2;
        if (!inv ) {
if ( n > save){
    System.out.println();
    return;
}
else{
    for (int i =0; i <=star;i++){
        System.out.print(" ");
    }
    for (int k = n; k >= 0; k--) {
        // System.out.print ("this is K :"+k);
        System.out.print(binom(n, k));
    }
    for (int i =0; i <=star;i++){
        System.out.print(" ");
    }
    System.out.println();//change line
    printPascal(n + 1);
}
        }

        // invert triangle
        else if (inv) {
            //System.out.print(star);
            //System.out.print(n);
            if (n < 0) {
                System.out.println();
                return;
            } else {
                for (int i =0; i <=star;i++){
                    System.out.print(" ");
                }
                for (int k = n; k >= 0; k--) {
                    // System.out.print ("this is K :"+k);
                    System.out.print(binom(n, k));
                }
                for (int i =0; i <=star;i++){
                    System.out.print(" ");
                }
                System.out.println();//change line
                printPascal(n - 1);
            }

        }

    }
    // bionormial method
    public static int binom(int n, int k){
        int ans =0;
        //exception incase k is bigger than n
        if (k>n){
            System. out. println("K can not bigger than N.");
            System.out.println("Terminated");
            return ans;
        }
        //nothing is wrong proceed bionormial calculation
        else {
            if (n == k || k == 0) {
                return 1;
            } else {
                ans = binom(n - 1, k - 1) + binom(n - 1, k);
            }
            return ans;
        }
    }
}
