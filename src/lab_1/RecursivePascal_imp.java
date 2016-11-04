package lab_1;

/**
 * Created by AlstonQiLee on 2016-11-03.
 * recurtion bionormial pascal triangle
 */

public class RecursivePascal_imp {
    static boolean inv;// invert the triangle or not
    static int save; //inver save value for n
    //ArrayList lastline = new ArrayList();
    static int[][] lastline;
    static int[][] memory;

    public static void main(String[] args) {
        RecursivePascal_imp b = new RecursivePascal_imp();
        int n = 51;
        save = n;
        inv = true;
        lastline = new int[n][n];
        memory = new int[n + 1][n + 1];

        b.printPascal(n);
    }

    // bionormial method
    public static int binom(int n, int k) {
        int ans = 0;
        //exception incase k is bigger than n
        if (k > n) {
            System.out.println("K can not bigger than N.");
            System.out.println("Terminated");
            return ans;
        }
        //nothing is wrong proceed bionormial calculation
        else {
            if (n == k || k == 0) {
                return 1;
            } else if (memory[n][n - k] != 0) {
                return memory[n][n - k];
            } else {
                ans = binom(n - 1, k - 1) + binom(n - 1, k);
                memory[n][n - k] = ans;
            }
            return ans;

        }
    }

    // print pascal triangle
    public void printPascal(int n) {

        if (n == 0) {
            for (int p = 0; p < save; p++) {
                for (int k = 0; k < save; k++) {
                    if (lastline[p][k] != 0) {
                        System.out.print(lastline[p][k]);
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            return;
        } else {
            //fill up ones
            lastline[save - n][save - n] = 1;//one in the end of each line
            lastline[save - n][0] = 1;//one in the begining
            for (int i = 0; i <= save - n; i++) {
                if (lastline[save - n][i] != 1) {
                    lastline[save - n][i] = binom(save - n, i);
                }

            }

            printPascal(n - 1);
        }
    }
}
