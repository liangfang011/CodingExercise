package edu.nyu.liangfang.leetcode;
/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */

public class palindromeNumber {
    // reverse number and compare
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        long reverse = 0, orig = (long) x;      // Use long in case overflow
        while (orig > 0) {
            reverse = reverse * 10 + orig % 10;
            orig /= 10;
        }
        return x == reverse;
    }

    public boolean isPalindrome_iterative(int x) {
        if (x < 0)
            return false;
        int len = 1;
        while ((int) (x / Math.pow(10, len)) != 0) {
            len++;
        }
        int num = x;
        int powNum = len + 1;
        while (num > 0 && powNum > 0) {
            powNum -= 2;
            int right = num % 10;
            int left = (int) (num / Math.pow(10, powNum));
            if (left != right) {
                return false;
            }
            num = (num - (int) (left * Math.pow(10, powNum)) - right) / 10;
        }
        return true;
    }
}
