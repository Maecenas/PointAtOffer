package PointAtOffer;

public class Q19_Print1ToMaxOfNDigits {

    public static void print1ToMaxOfDigits(int num) {
        if (num <= 0) return;

        StringBuilder number = new StringBuilder(num);
        number.append("0".repeat(num));
        while (increment(number)) {
            printNumber(number);
        }
    }

    private static boolean increment(StringBuilder num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) < '9' && num.charAt(i) >= '0') {
                num.setCharAt(i, (char) (num.charAt(i) + 1));
                return true;
            } else if (num.charAt(i) == '9') {
                num.setCharAt(i, '0');
            }
        }
        return false;
    }

    private static void printNumber(StringBuilder num) {
        boolean isBeginning = false;
        for (int i = 0; i < num.length(); i++) {
            if (isBeginning) {
                System.out.print(num.charAt(i));
            } else if (num.charAt(i) != '0') {
                isBeginning = true;
                System.out.print(num.charAt(i));
            }
        }
        System.out.println();
    }
}
