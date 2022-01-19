import java.util.Scanner;

public class BasicInputOutput {
    public static void main(String[] args) {

        // Input
        Scanner input = new Scanner(System.in);
        // Creating a new Scanner instance which points to the input stream passed as argument
        // we can scan the stream using this input variable and get integers ,
        // strings and do other stuff
        String name = input.nextLine(); //This method returns the String from the current position to the end of the line
        int age = input.nextInt(); // This method returns the Integer passed as input
        long number = input.nextLong(); // This method returns the Long passed as input
        float percentageMarks = input.nextFloat(); // This method returns the Float passed as input

        //Output
        System.out.print("Entered "); // This will print in same line
        System.out.print("Details: ");
        System.out.println("Name: "+name); // This will print in new line
        System.out.println("Age: "+age);
        System.out.println("Number: "+number);
        System.out.println("Marks Obtained(%): "+percentageMarks);

    }
}
