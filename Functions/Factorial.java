import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = in.nextInt();
        if(n<0) System.out.println("no real factorial value");
        else if(n == 0) System.out.println(1);
        else{
            int fact=1;
            while(n!=0){
                fact *=n;
                n--;
            }
            System.out.println(fact);
        }
    }
}
