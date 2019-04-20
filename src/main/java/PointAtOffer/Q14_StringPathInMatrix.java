package PointAtOffer;

public class Q14_StringPathInMatrix {

    public static boolean hasPath(char[][] matrix, String str) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || str == null) return false;

        final int R = matrix.length, C = matrix[0].length;
        final boolean[][] marked = new boolean[R][C];
        final char[] s = str.toCharArray();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (hasPathCore(matrix, marked, r, c, s, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPathCore(final char[][] matrix, boolean[][] marked, int r, int c, final char[] str, int pathLength) {
        if (pathLength >= str.length) return true;
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) return false;

        if (!marked[r][c] && matrix[r][c] == str[pathLength]) {
            marked[r][c] = true;
            boolean found = hasPathCore(matrix, marked, r - 1, c, str, pathLength + 1)
                    || hasPathCore(matrix, marked, r + 1, c, str, pathLength + 1)
                    || hasPathCore(matrix, marked, r, c - 1, str, pathLength + 1)
                    || hasPathCore(matrix, marked, r, c + 1, str, pathLength + 1);
            if (found) return true;
            else marked[r][c] = false;
        }
        return false;
    }
}
