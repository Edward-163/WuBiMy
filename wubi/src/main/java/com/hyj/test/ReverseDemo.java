package com.hyj.test;

public class ReverseDemo {
    public static void main(String[] args) {
        System.out.println(strReverse("qwertyu"));
        System.out.println(reverse(-210));
        System.out.println(reverse(123));
        System.out.println(reverse(-321));
        System.out.println(reverse((long) Math.pow(2,32)));
    }

    public static long reverse(long t) {
        if (t >= 0) {
            String s = String.valueOf(t);
            return verify(Long.valueOf(strReverse(s)));
        } else {
            String s = String.valueOf(-t);
            Long aLong = Long.valueOf(strReverse(s));
            return verify(-aLong);
        }
    }

    public static long verify(long t) {
        if ((-Math.pow(2, 31)) < t && t < (Math.pow(2, 31) - 1)) {
            return t;
        } else {
            return 0;
        }
    }

    public static String strReverse(String s) {
        if (s.length() > 1) {
            String headStr = s.substring(0, 1);
            String substring = s.substring(1);
            substring = strReverse(substring);
            return substring + headStr;
        } else {
            return s;
        }
    }
}
