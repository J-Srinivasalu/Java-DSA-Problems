import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        //4. calculator
        Scanner in = new Scanner(System.in);
        System.out.print("enter two numbers followed by an operator: ");
        float a = in.nextFloat();
        float b = in.nextFloat();

        String op = in.next();

        if(op.equals("+")) System.out.println(a+b);
        else if(Objects.equals(op, "-")) System.out.println(a-b);
        else if(Objects.equals(op, "*")) System.out.println(a*b);
        else if(Objects.equals(op, "/")) System.out.println(a/b);
        else System.out.println("invalid operator "+"'"+op+"'");
    }
}
