import java.util.Scanner;

public class q1 {
    public static int fib(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        else{
            return  fib(n-1) + fib(n-2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers do you want to print: ");
        int x = sc.nextInt();
       
        for (int i = 0; i < x; i++) {
            System.out.print(fib(i) + " ");
        }
        sc.close();
    }
}
