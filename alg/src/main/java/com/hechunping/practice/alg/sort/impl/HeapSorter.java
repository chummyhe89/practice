package com.hechunping.practice.alg.sort.impl;

import com.hechunping.practice.alg.sort.Sorter;


public class HeapSorter implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] data, boolean desc) {
        buildHeap(data, data.length - 1, desc);
        for (int i = data.length - 1; i > 0; i--) {
            swap(data, 0, i);
            adjustHeap(data, 0, i - 1, desc);
        }
    }

    private <T extends Comparable<T>> void buildHeap(T[] data, int end, boolean desc) {
        if (end == 0) return;
        boolean isRight = end % 2 == 0;
        int parentIdx = isRight ? ((end / 2) - 1) : ((end - 1) / 2);
        T parent = data[parentIdx];
        T cur = data[end];
        if ((!desc && cur.compareTo(parent) > 0) || (desc && cur.compareTo(parent) < 0)) {
            swap(data, parentIdx, end);
        }
        if (isRight) {
            T left = data[end - 1];
            parent = data[parentIdx];
            if ((!desc && left.compareTo(parent) > 0) || (desc && left.compareTo(parent) < 0)) {
                swap(data, parentIdx, end - 1);
            }
        }
        buildHeap(data, parentIdx, desc);
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
