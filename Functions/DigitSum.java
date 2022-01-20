import java.util.Scanner;

//Sum Of A Digits Of Number
public class DigitSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = in.nextInt();
        int num = n;
        int sum = 0;
        while(num!=0){
            sum += num%10;
            num /=10;
        }
        System.out.println("Digit sum of "+n+" is : "+ sum);
    }
}
