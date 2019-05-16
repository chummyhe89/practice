package com.hechunping.practice.alg.sort.impl;

import com.hechunping.practice.alg.sort.Sorter;

public class ShellSorter implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] data, boolean desc) {
        int delta = data.length / 2;
        while (delta > 0) {
            sortGroups(data,delta,desc);
            delta /= 2;
        }
    }

    public <T extends Comparable<T>> void sortGroups(T[] data,int delta,boolean desc) {
        for(int i=0;i<delta;i++) {
            sortGroup(data,i,delta,desc);
        }
    }

    public <T extends Comparable<T>> void sortGroup(T[] data,int begin,int delta,boolean desc) {
        int end = data.length - 1;
        for(int i = begin;i+delta <= end; i=i+delta) {
            T cur = data[i + delta];
            int j=i;
            for(; j>=0 ; j=j-delta) {
                T temp = data[j];
                if((!desc && temp.compareTo(cur) > 0) || (desc && temp.compareTo(cur) < 0)) {
                    data[j+delta] = data[j];
                    continue;
                }else{
                    break;
                }
            }
            data[j+delta] = cur;
        }
    }
}
