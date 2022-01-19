import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if (num % 2 == 0) System.out.println("even"); //if the numbers is divisible by 2 then it is even.
        else System.out.println("odd");            //else odd
    }
}
