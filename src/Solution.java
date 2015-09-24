import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by anurags on 9/22/15.
 */
public class Solution {
    private static int findClosestSumDP(int[] a, int k) {
        int[][] m = new int[k + 1][a.length];
        int[] closestSum = new int[k + 1];

        closestSum[0] = 0;

        for (int j = 0; j < a.length; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i <= k; i++) {
            closestSum[i] = closestSum[i - 1];

            for (int j = 0; j < a.length; j++) {
                if (i - a[j] >= 0) {
                    int possibleClosestSum =
                            closestSum[i - a[j]] + a[j];
                    if (possibleClosestSum <= i &&
                            possibleClosestSum > closestSum[i]) {
                        closestSum[i] = possibleClosestSum;
                    }
                }
            }
        }

        return closestSum[k];
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                String[] nk = br.readLine().split(" ");
                int n = Integer.parseInt(nk[0]);
                int k = Integer.parseInt(nk[1]);
                int[] a = new int[n];
                String[] aStr = br.readLine().split(" ");

                for (int j = 0; j < n; j++) {
                    a[j] = Integer.parseInt(aStr[j]);
                }

                System.out.println(findClosestSumDP(a, k));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
