import java.util.Scanner;

public class q2 {
    public static int gcd(int a, int b) {
        if (b == 0){
            return a;
        } else{
            return gcd(b, a % b);
         }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bigger number: ");
        int x = sc.nextInt();
        System.out.println("Enter smaller number");
        int y = sc.nextInt();
        if (x < y){
           int temp = x;
           x = y;
           y = temp; 
        }
       
        System.out.println("GCD IS : " + gcd(x, y));
        sc.close();
    }
}
