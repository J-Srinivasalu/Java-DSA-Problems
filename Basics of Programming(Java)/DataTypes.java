package practice;

public class DataTypes {
    public static void main(String[] args) {
        //Primitive datatype

        byte myByte = 100;//  byte	size= 1 byte Stores Integer numbers from -128 to 127
        short myShort = 1001;//  short	size= 2 bytes	Stores Integer numbers from -32,768 to 32,767
        int myInt = 25000;//  int	size= 4 bytes	Stores Integer numbers from -2,147,483,648 to 2,147,483,647
        long myLong = -21474836486L;//  long	size= 8 bytes	Stores Integer numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        float myFloat = 23.4738f;//  float	size= 4 bytes	Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
        double myDouble = -34.345726495d;//  double	size= 8 bytes	Stores fractional numbers. Sufficient for storing 15 decimal digits
        boolean myBoolean = true;//  boolean	size= 1 bit	Stores true or false values
        char myChar = 'm';//  char	size= 2 bytes	Stores a single character/letter or ASCII values

        System.out.println(myByte + " is of type " + ((Object)myByte).getClass().getSimpleName());
        System.out.println(myShort + " is of type " + ((Object)myShort).getClass().getSimpleName());
        System.out.println(myInt + " is of type " + ((Object)myInt).getClass().getSimpleName());
        System.out.println(myLong + " is of type " + ((Object)myLong).getClass().getSimpleName());
        System.out.println(myFloat + " is of type " + ((Object)myFloat).getClass().getSimpleName());
        System.out.println(myDouble + " is of type " + ((Object)myDouble).getClass().getSimpleName());
        System.out.println(myBoolean + " is of type " + ((Object)myBoolean).getClass().getSimpleName());
        System.out.println(myChar + " is of type " + ((Object)myChar).getClass().getSimpleName());
    }
}
