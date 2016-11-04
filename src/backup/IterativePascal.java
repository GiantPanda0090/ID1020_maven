package backup;


//import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by AlstonQiLee on 2016-11-04.
 */
public class IterativePascal implements Pascal{
    public static int[][] save;
    public static int[][] memory;

    public static void main(String[] args) {
        IterativePascal a = new IterativePascal();
        int n=51;
        save =new int[n+1][n+1];
        memory =new int [n][n];
//       System.out.print( a.binom(21,1));

        a.printPascal(n);
    }
    public int binom(int n, int k) {
//exception
        if (k > n) {
            System.out.println("K can not bigger than N.");
            System.out.println("Terminated");
            return 0;
        }

        if(n==k||k==0){
            return 1;
        }
/*        if(memory[n][k]!=0){
            return memory[n][k];
        }
        */
        //factorial nominator
        long nom=1;
        //factorial
        for (int i =1; i <=n ;i++) {
            nom = nom *i;
        }
        //denominator
        long denom=1;
        //factorial
        for (int i =1; i <=k ;i++) {
            denom = denom *i;
        }
        //n-k
        long nmk=1;
        for (int i =1; i <=n-k ;i++) {
            nmk = nmk *i;
        }
        denom = denom * nmk;
        /*
        int ans=0;
        ans = (int)(nom/ denom);
        */
        //memory[n][k]=ans;
return (int)(nom/ denom);
    }

    public void printPascal(int n) {
for(int i=0;i<3;i++){
    for(int k =0;k<=i;k++) {
        save[i][k]=binom(i, k);
    }
}

for(int i=3;i<n;i++){
    for(int k =0;k<=i;k++) {
        if (k==0){
            save[i][k]= 0+save[i-1][k];
        }
        else {
            save[i][k] = save[i - 1][k - 1] + save[i - 1][k];
        }
    }
}
        for(int i=0;i<n;i++){
            for(int k =0;k<=i;k++) {
                System.out.print(save[i][k]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
return;
    }
}
