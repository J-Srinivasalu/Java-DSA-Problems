import java.util.Scanner;
//Take integer inputs till the user enters 0 and print the largest number from all.
public class LargestNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Numbers: ");
        int n = in.nextInt();
        int max = n;
        while(n!=0){
            n = in.nextInt();
            if(max<n){
                max = n;
            }
        }
        System.out.println("max value enter: "+ max);
    }
}
