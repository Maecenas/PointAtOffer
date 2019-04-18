package PointAtOffer;

/**
 * 1. Add {@code final} keyword to arguments
 * 2. Early return when input is equal to this
 */
public class Q01_AssignmentOperator {

    public static class MyString {

        private String data;

        public MyString(String data) {
            this.data = data;
        }

        public MyString assign(final MyString that) {
            if (that == null || this == that || this.data.equals(that.data)) return this;

            this.data = that.data;
            return this;
        }

        @Override
        public String toString() {
            return data;
        }
    }

    public static void main(String[] args) {
        MyString s1 = new MyString("a");
        MyString s2 = new MyString("b");
        MyString s3 = new MyString("c");
        System.out.println(s1.assign(s2).assign(s3));
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);
    }
}
