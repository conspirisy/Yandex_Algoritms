package Sprint_6;

public class SolutionForTinkoff {

    public static void main(String[] args) {
        System.out.println(calculateDeposit(10));
    }

    public static int calculateDeposit(int days) {
        int result = 0;
        int[] week = new int[7];
        week[0] = 1;
        int i = 0;
        while (days > 0) {
            result += week[i];
            i++; days--;
            if (i >= week.length) {
                i = 0;
                week[i]++;
            } else {
                week[i] = week[i-1] + 1;
            }
        }
        return result;
    }
}
