public class Function {
    static double pi = 3.14159; // Global Variable, it can be used anywhere inside the class BasicJavaPrograms
    public static void main(String[] args) {
        circle(5); // function call
    }
    // function declaration
    public static void circle(int radius){
        double area = pi*radius*radius; // local variable, which can only be accessed inside function circle();
        double perimeter = 2*pi*radius;
        System.out.println("Area: "+area+" Perimeter: "+perimeter);
    }
}
