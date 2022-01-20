public class areaPerimeterVolumes {

    static double pi = 3.14159;
    public static void main(String[] args) {

    }
    public static double areaOfCircle(int radius){
        return pi*radius*radius;
    }
    public static double areaOfTriangle(int base, int height){
        return 0.5*base*height;
    }
    //Area of Triangle if all sides are given
    public static double areaOfTriangle(int a,int b, int c){
        double s = (a+b+c)/2.0;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    public static  int areaOfRectangle(int length, int breadth){
        return length*breadth;
    }
    public static double areaOfIsoscelesTriangle(int base, int height){
        return 0.5*base*height;
    }
    public static int areaOfParallelogram(int base, int height){
        return base*height;
    }
    public static double areaOfRhombus(int p,int q){
        return 0.5*p*q; //p and q are diagonals of rhombus
    }
    public static double areaOfEquilateralTriangle(int side){
        return (Math.sqrt(3)/4)*Math.pow(side,2);
    }
    public static double perimeterOfCircle(int radius){
        return 2*pi*radius;
    }
    public static int perimeterOfEquilateralTriangle(int side){
        return  3*side;
    }
    public static int perimeterOfParallelogram(int side,int base){
        return 2*(side+base);
    }
    public static int perimeterOfRectangle(int length,int breadth){
        return 2*(length+breadth);
    }
    public static int perimeterOfSquare(int side){
        return 4*side;
    }
    public static int perimeterOfRhombus(int side){
        return 4*side;
    }
    public static double volumeOfCone(int radius,int height){
        return pi*radius*radius*height/3;
    }
    public static double volumeOfTriangularPrism(int a,int b,int c, int height){
        return areaOfTriangle(a,b,c)*height;
    }
    public static double volumeOfCylinder(int radius, int height){
        return pi*radius*radius*height;
    }
    public static double volumeOfSphere(int radius){
        return 4*pi*Math.pow(radius,3)/3;
    }
    public static double volumeOfPyramid(int length,int width, int height){
        return length*width*height/3.0;
    }
    public static double curvedSurfaceAreaOfCylinder(int radius,int height){
        return 2*pi*radius*height;
    }
    public static double totalSurfaceAreaOfCylinder(int radius,int height){
        return (2*pi*radius*height)+(2*pi*radius*radius);
    }
    public static int totalSurfaceAreaOfCube(int side){
        return 6*side*side;
    }
    public static double surfaceAreaOfSphere(int radius){
        return 4*pi*radius*radius;
    }
}
