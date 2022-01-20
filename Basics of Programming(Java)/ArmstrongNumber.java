import java.util.Scanner;

public class ArmstrongNumber{
    public static void main(String[] args) {
        //Armstrong numbers between two numbers
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        for(int i=a;i<=b;i++){
            int temp = i;
            int sum = 0;
            while(temp != 0){
                int r = temp%10;
                sum += r*r*r;
                temp = temp/10;
            }
            if(sum == i){
                System.out.print(i+" ");
            }
        }
    }
}
