package com.hechunping.practice.alg.sort;

public interface Sorter {
    <T extends Comparable<T>> void sort(T[] data,boolean desc);

}
