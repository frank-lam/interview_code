package leetcode.code435_non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Created By Frank
 * @date 2018-08-05 16:40
 */

/**
 * 无重叠区间 (Non-overlapping Intervals) - 领扣 (LeetCode)
 * https://leetcode-cn.com/problems/non-overlapping-intervals/description/
 */
public class Solution1 {
    public static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start)
                    return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });

        // memo[i]表示以intervals[i]为结尾的区间能构成的最长不重叠区间序列
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < intervals.length; i++)
            // memo[i]
            for (int j = 0; j < i; j++)
                if (intervals[i].start >= intervals[j].end)
                    memo[i] = Math.max(memo[i], 1 + memo[j]);

        int res = 0;
        for (int i = 0; i < memo.length; i++)
            res = Math.max(res, memo[i]);

        return intervals.length - res;
    }

    public static void main(String[] args) {
        Interval[] interval1 = {new Interval(1, 2),
                new Interval(2, 3),
                new Interval(3, 4),
                new Interval(1, 3)};
        System.out.println((new Solution1()).eraseOverlapIntervals(interval1));


//        Interval[] interval2 = {new Interval(1, 2),
//                new Interval(1, 2),
//                new Interval(1, 2)};
//        System.out.println((new Solution1_递归方法()).eraseOverlapIntervals(interval2));
//
//        Interval[] interval3 = {new Interval(1, 2),
//                new Interval(2, 3)};
//        System.out.println((new Solution1_递归方法()).eraseOverlapIntervals(interval3));
    }
}
