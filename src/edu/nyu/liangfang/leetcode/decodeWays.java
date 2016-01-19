package edu.nyu.liangfang.leetcode;

public class decodeWays {
	// DP - Iterative, most efficient
	public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        else if (s.charAt(0) == '0') return 0;
        
        int[] mem = new int[s.length()];
        mem[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            mem[i] += s.charAt(i) == '0' ? 0 : mem[i - 1];
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                if (i == 1) mem[i] += 1;
                else mem[i] += mem[i - 2];
            }
        }
        return mem[s.length() - 1];
    }
}
