import java.util.Scanner;

//Calculate Discounted price of product
public class Discount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter price: ");
        double price = in.nextDouble();
        System.out.print("Enter discount percentage: ");
        double discount = in.nextDouble();
        System.out.println("Discounted price: "+(price*(1-(discount/100))));
    }
}
