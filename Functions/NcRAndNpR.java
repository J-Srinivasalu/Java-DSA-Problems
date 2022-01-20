import java.util.Scanner;

//Find Ncr & Npr

public class NcRAndNpR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n and r: ");
        int n = in.nextInt();
        int r = in.nextInt();
        System.out.println("nPr: "+(factorial(n)/factorial(n-r)));// n!/(n-r)!
        System.out.println("nCr: "+(factorial(n) / (factorial(r) *factorial(n-r))));//n!/(r!(n-r)!)
    }

    public static long factorial(int n) {
        long fact = 1;
        if (n == 0) return 1;
        while (n != 0) {
            fact *= n;
            n--;
        }
        return fact;
    }
}
