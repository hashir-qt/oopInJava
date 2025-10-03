import java.util.Scanner;

public class BisectionMethod {

    // Function definition: f(x) = x^3 - 3x^2 - 3x + 3
    public static double f(double x) {
        return Math.pow(x, 3) - 3 * Math.pow(x, 2) - 3 * x + 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input values
        System.out.print("Enter lower bound a: ");
        double a = sc.nextDouble();

        System.out.print("Enter upper bound b: ");
        double b = sc.nextDouble();

        System.out.print("Enter tolerance (te): ");
        double te = sc.nextDouble();

        double ya = f(a);
        double yb = f(b);
         sc.close();
        // Check if a or b is already a solution
        if (ya == 0) {
            System.out.println("Solution of the given equation is: " + a);
            return;
        }
        if (yb == 0) {
            System.out.println("Solution of the given equation is: " + b);
            return;
        }

        // Check if solution lies in interval
        if (ya * yb > 0) {
            System.out.println("Solution does not lie between the given values.");
            return;
        }

        double c = 0, yc;

        while (true) {
            c = (a + b) / 2;   // Midpoint
            yc = f(c);

            if (Math.abs(yc) < te) {   // Stopping condition
                System.out.println("Solution is: " + c);
                break;
            }

            // Update interval
            if (ya * yc < 0) {
                b = c;
                yb = yc;
            } else {
                a = c;
                ya = yc;
            }
        }

        sc.close();
    }
}
