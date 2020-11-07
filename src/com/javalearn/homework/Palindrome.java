package com.javalearn.homework;

public class Palindrome {
    public static void main(String args[]) {
        String a = "топот";
        System.out.println(isPalindrome(a, 0));
    }

    public static boolean isPalindrome(String st, int pos) {
        if (pos == st.length()) {
            return true;
        }
        if (st.charAt(pos) == st.charAt(st.length() - pos - 1)) {
            return isPalindrome(st, pos + 1);
        } else {
            return false;
        }


    }

}
