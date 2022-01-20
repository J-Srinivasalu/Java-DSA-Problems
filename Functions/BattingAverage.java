public class BattingAverage {
    public static void main(String[] args) {
        int runs = 1000;
        int matches = 25;
        int notout = 6;

        double avg = averageRuns(runs, matches,
                notout);
        if (avg == -1)
            System.out.print("NA");
        else
            System.out.print(Math.round(avg * 100.0) / 100.0);
    }

    static double averageRuns(int runs, int matches, int notout) {
        // Calculate number of dismissals
        int out = matches - notout;
        // Check for 0 times out
        if (out == 0) return -1;
        // Calculate batting average

        return (double) (runs) / out;
    }
}
