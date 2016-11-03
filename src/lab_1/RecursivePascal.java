package lab_1;

/**
 * Created by AlstonQiLee on 2016-11-03.
 */
public class RecursivePascal {
    public static void main(String[] args) {
//System.out.println(binom(2,3));
        RecursivePascal a = new RecursivePascal();
        a.printPascal(4);
    }
    public void printPascal(int n){
        if (n<0){
            System.out.println();
            return;
        }
        else {
            for (int k = n; k >= 0; k--) {
               // System.out.print ("this is K :"+k);
                System.out.print(binom(n, k));
            }
            System.out.println();
            printPascal(n-1);
        }

    }
    public static int binom(int n, int k){
        int ans =0;
        if (k>n){
            System. out. println("K can not bigger than N.");
            System.out.println("Terminated");
            return ans;
        }
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
