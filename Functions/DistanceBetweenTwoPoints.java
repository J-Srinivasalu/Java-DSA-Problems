import java.util.Scanner;


public class DistanceBetweenTwoPoints {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1,x2,y1,y2;
        System.out.println("Enter first point coordinates(x1, y1): ");
        x1 = in.nextInt();
        y1 = in.nextInt();
        System.out.println("Enter second point coordinates(x1, y1): ");
        x2 = in.nextInt();
        y2 = in.nextInt();
        double distance = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        System.out.println("distance between points : "+distance);
    }
}
