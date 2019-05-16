package com.hechunping.practice.alg.sort.impl;

import com.hechunping.practice.alg.sort.Sorter;

public class InsertSorter implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] data, boolean desc) {
        int i =0;
        while(i < data.length - 1) {
            int j = i;
            T cur = data[j+1];
            while((!desc && data[j].compareTo(cur) > 0) || (desc && data[j].compareTo(cur) < 0)) {
                data[j+1] = data[j];
                j--;
                if(j<0) break;
            }
            data[j+1] = cur;
            i++;
        }
    }
}
