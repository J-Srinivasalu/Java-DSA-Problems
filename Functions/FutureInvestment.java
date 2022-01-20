public class FutureInvestment {
    public static void main(String[] args)
    {
        float V1 = 200, R = 10, T = 2;

        System.out.print("Depreciation of value: "+ futureInvestmentValue(V1, R, T));
    }
    // function to return the future investment value
    static float futureInvestmentValue(float v, float r, float t)
    {
        return (float)(v * Math.pow((1 + r / 100), t));
    }
}
