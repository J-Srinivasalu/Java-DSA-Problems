import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(reverse(str));
    }
    public static String reverse(String s){
        String ans = "";
        for(int i = s.length()-1;i>=0;i--){
            ans= ans+s.charAt(i);
        }
        return ans;
    }
}
