package com.hechunping.practice.alg.sort;

import com.hechunping.practice.alg.sort.impl.HeapSorter;
import com.hechunping.practice.alg.sort.impl.InsertSorter;
import org.junit.Test;

import java.util.Arrays;

public class SorterTest {
    private static final Integer[] DATA = new Integer[]{3, 1, 14, 2, 19, 4, 7, 1, 20};

    @Test
    public void testHeapSorter(){
        HeapSorter.INSTANCE.sort(DATA,false);
        System.out.println(Arrays.asList(DATA));
    }

    @Test
    public void testInertSorter(){
        InsertSorter sorter = new InsertSorter();
        sorter.sort(DATA,true);
        System.out.println(Arrays.asList(DATA));
    }
}
