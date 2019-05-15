package com.hechunping.practice.alg.sort.impl;

import com.hechunping.practice.alg.sort.Sorter;

import java.util.Arrays;

public class QuickSorter implements Sorter {
    public <T extends Comparable<T>> void sort(T[] data,boolean desc) {
        if(data == null || data.length <= 1) return;
        qsort(data,0,data.length - 1,desc);
    }

    private <T extends Comparable<T>> int partition(T[] data,int begin,int end,boolean desc) {
        int i= begin,j=end;
        T  baseValue = data[begin];
        while (i < j) {
            if(desc) {
                while (i < j && data[j].compareTo(baseValue) <= 0) j--;
                while (i < j && data[i].compareTo(baseValue) >= 0) i++;
            }else{
                while (i < j && data[j].compareTo(baseValue) >= 0) j--;
                while (i < j && data[i].compareTo(baseValue) <= 0) i++;
            }
            swap(data,i,j);
            System.out.println("swap\t"+i+":"+j);
            System.out.println(Arrays.asList(data));
        }
        return j;
    }

    private <T extends Comparable<T>> void qsort(T[] data,int begin,int end,boolean desc) {
        System.out.println("-----------------qsort round ["+begin+","+end+"]");
        if(begin == end){
            System.out.println("-----------------qsort round end\n");
            return;
        }
        int base = partition(data,begin,end,desc);
        swap(data, begin, base);
        System.out.println(String.format("-----------------qsort round end with base(%s)\n",base));
        if(base > begin) {
            qsort(data, begin, base - 1,desc);
        }
        if(base < end) {
            qsort(data, base + 1, end,desc);
        }
    }
}
