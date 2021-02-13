package com.xym.datastructure.huawei;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int l = heights.length;
        if (l == 0) return 0;
        if (l == 1) return heights[0];
        int[] newHeights = new int[l + 2];
        for (int i = 0; i < l; i++) {
            newHeights[i + 1] = heights[i];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < l + 2; i++) {
            while (newHeights[stack.peek()] > newHeights[i]) {
                int height = newHeights[stack.pop()];
                int width = i - stack.peek() - 1;
                ans = Math.max(ans, height * width);
            }
            stack.push(i);
        }
        return ans;
    }

}
