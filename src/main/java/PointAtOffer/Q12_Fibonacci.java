package PointAtOffer;

public class Q12_Fibonacci {

    /**
     * Recursive calls, O(n^2), O(1)
     */
    public static int fibonacci1(int n) {
        if (n <= 0) return 0;
        else if (n <= 2) return 1;
        else return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    /**
     * Iterative calls and lazily evaluation, O(n), O(1)
     */
    public static int fibonacci2(int n) {
        if (n <= 0) return 0;
        else if (n <= 2) return 1;

        int a = 0, b = 1, res = 1;

        for (int i = 3; i <= n; i++) {
            a = b;
            b = res;
            res = a + b;
        }
        return res;
    }

    /**
     * Matrix multiplication, O(logn), O(1)
     */
    public static int fibonacci3(int n) {
        int[][] start = {
                {1, 1},
                {1, 0}
        };
        return matrixPow(start, n - 1)[0][0];
    }

    private static int[][] matrixPow(int[][] start, int n) {
        if ((n & 1) == 0) {
            int[][] temp = matrixPow(start, n >> 1);
            return matMul(temp, temp);
        } else if (n == 1) {
            return start;
        } else {
            return matMul(start, matrixPow(start, n - 1));
        }
    }

    private static int[][] matMul(int[][] x, int[][] y) {
        int[][] res = new int[x.length][y.length];
        int sum;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                sum = 0;
                for (int k = 0; k < x[0].length; k++) {
                    sum += x[i][k] * y[k][j];
                }
                res[i][j] = sum;
            }
        }
        return res;
    }

    /**
     * Math formula, O(1), O(1)
     */
    public static int fibonacci4(int n) {
        double sqrt5 = Math.sqrt(5);
        return (int) ((1 / sqrt5) * (Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n)));
    }
}
