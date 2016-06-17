package com.read.spring;

/**
 * Created by zwshao on 6/15/16.
 */
public class Main {
    private static String NEW_LINE = System.getProperty("line.separator");

    public static void printHashCodes(final Object object) {

        System.out.println(NEW_LINE + String.valueOf(object) + "/" + (object != null ? object.getClass().getName() : "null"));

        System.out.println("overridden hashcode: " + (object != null ? object.hashCode() : "N/A"));

        System.out.println("Identity hashcode: " + System.identityHashCode(object));
    }

    public static void main(String[] args) {
        final Integer int1 = 1;
        final int int2 = 1;
        final Long long1 = 1L;
        final long long2 = 1L;
        final String str = "some string";
        final String nullString = null;
        final SimpleData simpleData = new SimpleData("Another String");

        printHashCodes(int1);
        printHashCodes(int2);
        printHashCodes(long1);
        printHashCodes(long2);
        printHashCodes(str);
        printHashCodes(nullString);
        printHashCodes(simpleData);

        System.out.println(System.identityHashCode(new SimpleData("Another String")));
    }

    static class SimpleData {
        private String data;

        public SimpleData(String data) {
            this.data = data;
        }

        @Override
        public int hashCode() {
            return 100;
        }
    }

}
