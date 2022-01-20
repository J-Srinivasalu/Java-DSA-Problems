//As in Compound Interest, interest is regularly added to the principal at the end of the agreed intervals
// of time to generate a new and fresh principal. Similarly, Depreciated value is the decreased value from
// the amount at the end of agreed intervals of time to generate a new Value.
//Source https://www.geeksforgeeks.org/program-to-find-the-depreciation-of-value/
public class Depreciation {
    public static void main(String[] args)
    {
        float V1 = 200, R = 10, T = 2;

        System.out.print("Depreciation of value: "+depreciation(V1, R, T));
    }
    // function to return the depreciation of value
    static float depreciation(float v, float r, float t)
    {
        return (float)(v * Math.pow((1 - r / 100), t));
    }
}
