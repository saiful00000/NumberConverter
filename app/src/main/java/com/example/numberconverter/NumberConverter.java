package com.example.numberconverter;

public class NumberConverter {

    static String sign = "";

    public static int ifDecimal(String inputString) {
        int n = 0;
        if (inputString != null && isDecimal(inputString)) {
            n = Integer.parseInt(getIntNumber(inputString));
        }

        return n;
    }

    public static String ifBinary(String input) {

        return null;
    }

    public static String ifOctal(String input) {

        return null;
    }

    public static String ifHex(String input) {

        return null;
    }




    private static String getIntNumber(String inputNumber) {
        String intNumber = "";
        char[] array = inputNumber.toCharArray();
        int i = 0;
        if (array[0] == '-') {
            i = 1;
            sign = "-";
        }

        for (; i < array.length; i++) {
            if ((array[i] >= '0' && array[i] <= '9')) {
                intNumber += array[i];
            } else {
                return intNumber;
            }
        }
        return intNumber;
    }

    // is Numeric
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // is decimal number
    private static boolean isDecimal(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && c == '-')
                continue;
            if ((c >= '0' && c <= '9') || c == '.') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
