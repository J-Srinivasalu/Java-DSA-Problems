import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {

        //5. largest number

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        if(a>b) System.out.println(a);
        else if(a<b) System.out.println(b);
        else System.out.println("equal "+ a);

        //6. Rs -> USD
        float rs = in.nextFloat();
        System.out.println("USD : "+rs*0.013448587 );
    }
}
