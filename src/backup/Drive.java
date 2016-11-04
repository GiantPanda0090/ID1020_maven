package backup;

/**
 * Created by AlstonQiLee on 2016-11-04.
 */
public class Drive {
    public static void main(String[] args) {

        ErrorPascal a = new IterativePascal(false);
        a.printPascal(20);
        System.out.print(a.binom(1,6));
        System.out.println(" ");
        System.out.println("Change test object");
        System.out.println(" ");

        ErrorPascal b = new RecursivePascal(true);
        b.printPascal(20);
        System.out.print(b.binom(1,1));
    }
}
