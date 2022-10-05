package myleetcode.array;

public class Q1109CorpFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] c = new int[n + 1];
        for (int[] bo : bookings) {
            int l = bo[0] - 1;
            int r = bo[1] - 1;
            int v = bo[2];
            c[l] += v;
            c[r + 1] -= v;
        }

        int[] ans = new int[n];
        ans[0] = c[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + c[i];
        }
        return ans;
    }
}
