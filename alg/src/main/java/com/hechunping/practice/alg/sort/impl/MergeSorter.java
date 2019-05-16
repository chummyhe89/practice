package com.hechunping.practice.alg.sort.impl;

import com.hechunping.practice.alg.sort.Sorter;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 归并排序
 * max:nlogn
 * min:nlogn
 * avg:nlogn
 * space:n
 * stable:true
 */
public class MergeSorter implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] data, boolean desc) {
        sort(data, 0, data.length - 1, desc);
    }

    public <T extends Comparable<T>> void sort(T[] data, int begin, int end, boolean desc) {
        if (begin >= end) return;
        int mid = (begin + end) / 2;
        if (mid > begin) {
            sort(data, begin, mid, desc);
        }
        if (mid + 1 < end) {
            sort(data, mid + 1, end, desc);
        }
        merge(data, begin, mid, end, desc);
    }

    public <T extends Comparable<T>> void merge(T[] data, int begin, int mid, int end, boolean desc) {
        int i = begin;
        int j = mid + 1;
        T[] sorted = (T[]) Array.newInstance(data.getClass().getComponentType(), end - begin + 1);
        for (int k = 0; k < sorted.length; k++) {
            T left = data[i];
            T right = data[j];
            if ((!desc && left.compareTo(right) > 0) || (desc && left.compareTo(right) < 0)) {
                sorted[k] = right;
                if (j == end) {
                    System.arraycopy(data,i,sorted,k+1,mid - i + 1);
                    break;
                }
                j++;
            } else if ((!desc && left.compareTo(right) <= 0) || (desc && left.compareTo(right) >= 0)) {
                sorted[k] = left;
                if (i == mid) {
                    System.arraycopy(data,j,sorted,k+1,end - j + 1);
                    break;
                }
                i++;
            }
        }
        System.arraycopy(sorted, 0, data, begin, end - begin + 1);
    }

    public static void main(String[] args) {
        MergeSorter sorter = new MergeSorter();
        Integer[] data = new Integer[]{3, 1, 14, 2, 19, 4, 7, 1, 20};
        sorter.sort(data, true);
        System.out.println(Arrays.asList(data));
    }
}
