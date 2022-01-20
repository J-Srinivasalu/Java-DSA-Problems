import java.util.Scanner;
//Input currency in rupees and output in USD.
public class INR2USD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter in INR: ");
        float inr = in.nextFloat();
        System.out.println("In USD: "+(inr*0.013));
    }
}
