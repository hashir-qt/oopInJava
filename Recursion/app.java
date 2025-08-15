import java.util.Scanner;

public class app {
    public static int fn(int a, int b) {
        if (b == 0)
         return 1;
         else{
            return a*fn(a, b-1);
         }
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("ENTER FIRST NUM: ");
        int x = sc.nextInt();
        System.out.println("ENTER SECOND NUM: ");
        int y = sc.nextInt();
        int n = fn(x, y);
        System.out.println(n);
        sc.close();
    }
}