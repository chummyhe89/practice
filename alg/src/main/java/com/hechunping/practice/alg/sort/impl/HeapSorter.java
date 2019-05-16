package com.hechunping.practice.alg.sort.impl;

import com.hechunping.practice.alg.sort.Sorter;

import java.util.Arrays;

/**
 * 堆排序
 * max:nlogn
 * min:nlogn
 * avg:nlogn
 * space:1
 * stable:false
 */
public class HeapSorter implements Sorter {
    public static final Sorter INSTANCE = new HeapSorter();
    @Override
    public <T extends Comparable<T>> void sort(T[] data, boolean desc) {
        buildHeap(data,desc);
        System.out.println("-------------------构建堆");
        System.out.println(Arrays.asList(data));
        for (int i = data.length - 1; i > 0; i--) {
            swap(data, 0, i);
            adjustHeap(data, 0, i - 1, desc);
            System.out.println("------------------- 第"+(data.length - i)+"次调整堆");
            System.out.println(Arrays.asList(data));
        }
    }

    private <T extends Comparable<T>> void buildHeap(T[] data,boolean desc) {
        int i = data.length-1;
        while (i > 0){
            boolean isRight = i % 2 == 0;
            int parentIdx = isRight ? ((i / 2) - 1) : ((i - 1) / 2);
            T parent = data[parentIdx];
            T cur = data[i];
            if ((!desc && cur.compareTo(parent) > 0) || (desc && cur.compareTo(parent) < 0)) {
                swap(data, parentIdx, i);
                adjustHeap(data,i,data.length-1,desc);
            }
            i--;
        }
    }

    private <T extends Comparable<T>> void adjustHeap(T[] data, int begin, int end, boolean desc) {
        if (begin >= end) return;
        int leftIdx = begin * 2 + 1;
        int rightIdx = begin * 2 + 2;
        adjustIfNeed(data,begin,leftIdx,end,desc);
        adjustIfNeed(data,begin,rightIdx,end,desc);
    }

    private <T extends Comparable<T>> void adjustIfNeed(T[] data, int parentIdx, int childIdx, int end, boolean desc) {
        if (childIdx <= end) {
            T child = data[childIdx];
            T parent = data[parentIdx];
            if ((!desc && child.compareTo(parent) > 0) || (desc && child.compareTo(parent) < 0)) {
                swap(data, parentIdx, childIdx);
                adjustHeap(data, childIdx, end, desc);
            }
        }
    }
}
