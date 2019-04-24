package PointAtOffer;

public class Q37_SequenceOfBST {

    public static boolean verifySequenceOfBST(int[] seq) {
        if (seq == null || seq.length == 0) return false;

        return verifySequenceOfBST(seq, 0, seq.length - 1);
    }

    private static boolean verifySequenceOfBST(int[] seq, int low, int high) {
        // BST with 0~1 element
        if (high - low <= 1) return true;

        int rootVal = seq[high], curr = low;
        while (curr < high && seq[curr] <= rootVal) curr++;
        for (int i = curr + 1; i < high; i++) {
            if (seq[i] < rootVal) {
                return false;
            }
        }
        return verifySequenceOfBST(seq, low, curr - 1) && verifySequenceOfBST(seq, curr, high - 1);
    }
}
