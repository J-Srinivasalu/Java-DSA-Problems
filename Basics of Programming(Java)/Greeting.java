import java.util.Scanner;
//Take name as input and print a greeting message for that name.
public class Greeting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        System.out.println("Hey "+name+", Happy coding");
    }
}
