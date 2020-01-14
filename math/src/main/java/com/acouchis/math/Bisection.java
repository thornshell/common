package com.acouchis.math;

import java.util.Arrays;

/**
 * Created by gaopeng09 on 2020-01-13
 */
public class Bisection {
    /**
     * return indexes of target in source
     * -1 for not exist
     * null for target == null or 0 == target.length
     *
     * @param source
     * @param target
     * @return
     */
    public static int findInLinearArray(int[] source, int target) {

        int length = source.length;
        boolean asc = source[0] < source[length - 1];
        int l = 0;
        int r = length;

        for (int index = (l + r) / 2; ; index = (l + r) / 2) {
            if (l >= r - 1) {
                if (source[l] == target) {
                    return l;
                } else {
                    return -1;
                }
            }

            if (target > source[index]) {
                if (asc) {
                    l = index;
                } else {
                    r = index;
                }
            } else if (target < source[index]) {
                if (asc) {
                    r = index;
                } else {
                    l = index;
                }
            } else {
                return index;
            }
        }
    }


    public static int[] findInMountainsArray(int[] source, int target) {
        int maxIndex;
        int length = source.length;
        for (int l = 0, r = length; ; ) {
            int index = (l + r) / 2;


            int i = source[index];
            int i1 = source[Math.min(index + 1, length)];
            int i2 = source[Math.max(index - 1, 0)];
            if (i > i1 && i > i2) {
                maxIndex = index;

                break;
            }
            if (i > i1) {
                r = index;
            } else {
                l = index;
            }
        }

        int[] lefts = Arrays.copyOfRange(source, 0, maxIndex);
        int[] rights = Arrays.copyOfRange(source, maxIndex, length);
        int leftResult = findInLinearArray(lefts, target);
        int rightResult = findInLinearArray(rights, target);
        return new int[]{leftResult, rightResult};
    }
}
