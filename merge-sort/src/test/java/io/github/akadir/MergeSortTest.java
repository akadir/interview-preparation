package io.github.akadir;

import io.github.akadir.mergesort.MergeSort;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author akadir
 * Date: 24.04.2020
 * Time: 21:32
 */
public class MergeSortTest {
    private final MergeSort mergeSort = new MergeSort();

    @Test
    public void mergeSortTest() {
        int[] ascOrdered = {1, 2, 3, 4, 5};
        int[] descOrdered = {5, 4, 3, 2, 1};
        int[] sameElements = {1, 1, 1, 1, 1};
        int[] empty = {};

        Assert.assertArrayEquals(ascOrdered, mergeSort.sort(descOrdered, MergeSort.SortOrder.ASC));
        Assert.assertArrayEquals(descOrdered, mergeSort.sort(descOrdered, MergeSort.SortOrder.DESC));
        Assert.assertArrayEquals(descOrdered, mergeSort.sort(ascOrdered, MergeSort.SortOrder.DESC));
        Assert.assertArrayEquals(ascOrdered, mergeSort.sort(ascOrdered, MergeSort.SortOrder.ASC));
        Assert.assertArrayEquals(sameElements, mergeSort.sort(sameElements, MergeSort.SortOrder.ASC));
        Assert.assertArrayEquals(sameElements, mergeSort.sort(sameElements, MergeSort.SortOrder.DESC));
        Assert.assertArrayEquals(empty, mergeSort.sort(empty, MergeSort.SortOrder.ASC));
        Assert.assertArrayEquals(empty, mergeSort.sort(empty, MergeSort.SortOrder.DESC));
        Assert.assertArrayEquals(null, mergeSort.sort(null, MergeSort.SortOrder.DESC));
        Assert.assertArrayEquals(null, mergeSort.sort(null, MergeSort.SortOrder.ASC));
    }
}
