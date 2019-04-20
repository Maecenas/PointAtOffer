package PointAtOffer;

public class Q15_RobotMove {

    private int threshold, rows, cols;
    private boolean[][] marked;

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) return 0;

        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        marked = new boolean[rows][cols];
        return movingCountCore(0, 0);
    }

    private int movingCountCore(int r, int c) {
        int count = 0;
        if (check(r, c)) {
            marked[r][c] = true;
            count = 1
                    + movingCountCore(r - 1, c)
                    + movingCountCore(r + 1, c)
                    + movingCountCore(r, c - 1)
                    + movingCountCore(r, c + 1);
        }
        return count;
    }

    private boolean check(int r, int c) {
        return r >= 0 && r < rows
                && c >= 0 && c < cols
                && !marked[r][c]
                && getDigitSum(r) + getDigitSum(c) <= threshold;
    }

    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
