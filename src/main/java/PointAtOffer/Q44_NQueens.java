package PointAtOffer;

import java.lang.reflect.Method;

public class Q44_NQueens {

    private static final int N = 15;
    private static int count = 0;

    /**
     * DFS that enumerate, stored position using int[]
     * finding collision takes at most O(N) time
     */
    public static void DFS1() {
        int[] queens = new int[N];
        count = 0;
        DFS1(0, queens);
    }

    private static void DFS1(int row, final int[] queens) {
        for (int col = 0; col < N; col++) {
            boolean isValid = true;
            for (int r = 0; r < row; r++) {
                if (queens[r] == col || queens[r] == col + r - row || queens[r] == col - r + row) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                queens[row] = col;
                if (row == N - 1) {
                    count++;
                } else {
                    DFS1(row + 1, queens);
                }
            }
        }
    }

    /**
     * DFS that keeps three boolean[] to check if each vertical and diagonal
     * line can be set, reduce collision finding to O(1)
     */
    public static void DFS2() {
        boolean[] down = new boolean[N], dl = new boolean[2 * N - 1], dr = new boolean[2 * N - 1];
        count = 0;

        DFS2(0, down, dl, dr);
    }

    private static void DFS2(int row, boolean[] down, boolean[] dl, boolean[] dr) {
        for (int col = 0; col < N; col++) {
            final int i = row + col, j = N - 1 + col - row;
            if (down[col] || dl[i] || dr[j]) {
                continue;
            }
            if (row == N - 1) {
                count++;
            } else {
                down[col] = dl[i] = dr[j] = true;
                DFS2(row + 1, down, dl, dr);
                down[col] = dl[i] = dr[j] = false;
            }
        }
    }

    /**
     * Bitmap implementation of boolean[], faster with bitwise manipulation
     */
    public static void DFS3() {
        int down = 0, dl = 0, dr = 0;
        count = 0;

        DFS3(0, down, dl, dr);
    }

    private static void DFS3(int row, int down, int dl, int dr) {
        for (int col = 0; col < N; col++) {
            int i = row + col, j = N - 1 + col - row;
            if ((((down >> col) | (dl >> i) | (dr >> j)) & 1) != 0) {
                continue;
            }
            if (row == N - 1) {
                count++;
            } else {
                down ^= (1 << col);
                dl ^= (1 << i);
                dr ^= (1 << j);
                DFS3(row + 1, down, dl, dr);
                down ^= (1 << col);
                dl ^= (1 << i);
                dr ^= (1 << j);
            }
        }
    }

    /**
     * Enumerate only those spots that would not collide
     */
    public static void DFS4() {
        int down = 0, dl = 0, dr = 0;
        count = 0;

        DFS4(0, down, dl, dr);
    }

    private static void DFS4(int row, int down, int dl, int dr) {
        int p, available = ((1 << N) - 1) & ~(down | (dl >> row) | (dr >> (N - 1 - row)));
        while (available != 0) {
            p = available & -available;
            available ^= p;
            if (row == N - 1) {
                count++;
            } else {
                down ^= p;
                dl ^= (p << row);
                dr ^= (p << (N - 1 - row));
                DFS4(row + 1, down, dl, dr);
                down ^= p;
                dl ^= (p << row);
                dr ^= (p << (N - 1 - row));
            }
        }
    }

    /**
     * Change global variable to function argument, reduce local variable
     */
    public static void DFS5() {
        count = 0;

        DFS5(0, 0, 0, 0);
    }

    private static void DFS5(int row, int down, int dl, int dr) {
        int p, available = ((1 << N) - 1) & ~(down | dl | dr);
        while (available != 0) {
            p = available & -available;
            available ^= p;
            if (row == N - 1) {
                ++count;
            } else {
                DFS5(row + 1, down ^ p, (dl ^ p) >> 1, (dr ^ p) << 1);
            }
        }
    }

    private static void test(String method) {
        System.out.println("\nTesting: " + method);
        long tic = System.currentTimeMillis();
        try {
            Method m = Q44_NQueens.class.getDeclaredMethod(method);
            m.invoke(null);

            long toc = System.currentTimeMillis();
            System.out.println("Total solutions: " + count);
            System.out.println("Time: " + (toc - tic) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            test("DFS" + i);
        }
    }
}
