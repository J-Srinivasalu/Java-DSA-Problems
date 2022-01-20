import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        //Fibonacci series
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int a = 0;
        int b = 1;
        int next = a + b;
        System.out.print(a + " " + b + " ");
        for (int i = 3; i <= n; i++) {
            System.out.print(next + " ");
            a = b;
            b = next;
            next = a + b;
        }
    }
}
