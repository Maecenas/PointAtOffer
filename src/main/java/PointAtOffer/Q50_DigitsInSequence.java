package PointAtOffer;

public class Q50_DigitsInSequence {

    public static int digitAtIndex(int index) {
        if (index < 0) return -1;
        int place = 0;  // number of digits
        int amount, totalAmount = 0;
        while (index >= totalAmount) {
            index -= totalAmount;
            place++;

            amount = getAmountOfPlace(place);
            totalAmount = amount * place;
        }
        return findDigitAtIndex(index, place);
    }

    /**
     * The amount of place by a fixed digit length
     * e.g., 10, 90, 900, ...
     */
    private static int getAmountOfPlace(int place) {
        if (place == 1) return 10;
        return (int) Math.pow(10, place - 1) * 9;
    }

    /**
     * The beginning index of place by a fixed digit length
     * e.g., 0, 10, 100, ...
     */
    private static int getBeginNumberOfPlace(int place) {
        if (place == 1) return 0;
        return (int) Math.pow(10, place - 1);
    }

    /**
     * For a sequence of fixed digit length, find exact digit
     */
    private static int findDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        String number = String.valueOf(beginNumber + shiftNumber);
        int count = index % place;
        return number.charAt(count) - '0';
    }
}
