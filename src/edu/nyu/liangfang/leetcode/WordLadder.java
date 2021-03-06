package edu.nyu.liangfang.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        Queue<Integer> step = new LinkedList<Integer>();
        queue.add(start);
        step.add(1);
        dict.add(end);      // need this unless we assume end is in the dictionary

        while (!queue.isEmpty()) {
            String s = queue.poll();
            int num = step.poll();
            if (s.equals(end)) {
                return num;
            }

            for (int i = 0; i < s.length(); i++) {
                char[] strArr = s.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != s.charAt(i)) {        // ignore itself
                        strArr[i] = ch;
                        String newStr = String.valueOf(strArr);
                        if (dict.contains(newStr)) {
                            queue.add(newStr);
                            step.add(num + 1);
                            dict.remove(newStr);    // must delete it, avoid infinite loop and also we don't
                        }                            // need this newStr anymore because we only care about shortest path
                    }
                }
            }
        }
        return 0;
    }

    // method with visited set
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start == null || end == null || start.length() == 0 || end.length() == 0 || start.length() != end.length())
            return 0;
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        int level = 1;
        int lastNum = 1;
        int curNum = 0;
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            lastNum--;
            for (int i = 0; i < cur.length(); i++) {
                char[] charCur = cur.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    charCur[i] = c;
                    String temp = new String(charCur);
                    if (temp.equals(end))
                        return level + 1;
                    if (dict.contains(temp) && !visited.contains(temp)) {
                        curNum++;
                        queue.offer(temp);
                        visited.add(temp);
                    }
                }
            }
            if (lastNum == 0) {
                lastNum = curNum;
                curNum = 0;
                level++;
            }
        }
        return 0;
    }


    // DFS method - TLE
    // To find shortest path, you need BFS
    public int ladderLength_DFS(String start, String end, Set<String> dict) {
        int[] min = {Integer.MAX_VALUE};
        dict.add(end);
        find(start, end, dict, 1, min);
        return min[0];
    }

    public void find(String start, String end, Set<String> dict, int step, int[] min) {
        if (start.equals(end)) {
            min[0] = Math.min(min[0], step);
            return;
        }

        for (int i = 0; i < start.length(); i++) {
            char[] arr = start.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String newStr = new String(arr);
                if (dict.contains(newStr)) {
                    dict.remove(newStr);
                    find(newStr, end, dict, step + 1, min);
                    dict.add(newStr);
                }
            }
        }
    }
}
