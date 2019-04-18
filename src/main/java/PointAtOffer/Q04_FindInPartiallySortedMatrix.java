package PointAtOffer;

public class Q04_FindInPartiallySortedMatrix {

    public static boolean findInPartiallySortedMatrix(int[][] data, int target) {
        if (data == null || data.length == 0 || data[0].length == 0) return false;

        // Start searching from top-right/down-left corner
        int R = data.length, C = data[0].length, r = R - 1, c = 0;

        while (r >= 0 && c < C) {
            if (data[r][c] == target) {
                return true;
            } else if (data[r][c] > target) {
                r--;
            } else {
                c++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};
        System.out.println(findInPartiallySortedMatrix(data, 10));
        System.out.println(findInPartiallySortedMatrix(data, 5));
    }
}
