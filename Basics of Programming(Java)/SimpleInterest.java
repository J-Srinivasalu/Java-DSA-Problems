import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        //simple interest
        Scanner in =new Scanner(System.in);
        float p,r,t;
        p = in.nextFloat(); //Principle
        r = in.nextFloat(); //Annual interest rate
        t = in.nextFloat(); //Time (in years)

        float si = p*r*t;
        System.out.println(si);
    }
}
