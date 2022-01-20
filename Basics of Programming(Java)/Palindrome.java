import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        // palindrome
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = "";
        for(int i = a.length()-1;i>=0;i--){
            b= b+a.charAt(i);
        }
        if(a.equals(b)){
            System.out.println("a is palindrome");
        }
        else System.out.println("a is not palindrome");
    }
}
