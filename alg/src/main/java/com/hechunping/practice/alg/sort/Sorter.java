package com.hechunping.practice.alg.sort;

public interface Sorter {
    <T extends Comparable<T>> void sort(T[] data,boolean desc);

    default  <T extends Comparable<T>> void swap(T[] data,int left,int right) {
        if(left == right) return;
        T temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }
}
