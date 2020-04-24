package io.github.akadir;

import io.github.akadir.mergesort.MergeSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author akadir
 * Date: 24.04.2020
 * Time: 21:32
 */
public class MergeSortTest {
    private MergeSort mergeSort;

    @Before
    public void initialize() {
        mergeSort = new MergeSort();
    }

    @Test
    public void mergeSortTestAscDesc() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        Assert.assertArrayEquals(expected, mergeSort.sort(arr, MergeSort.SortOrder.DESC));
    }

    @Test
    public void mergeSortTestAscAsc() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, mergeSort.sort(arr, MergeSort.SortOrder.ASC));
    }

    @Test
    public void mergeSortTestDescAsc() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, mergeSort.sort(arr, MergeSort.SortOrder.ASC));
    }

    @Test
    public void mergeSortTestDescDesc() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {5, 4, 3, 2, 1};
        Assert.assertArrayEquals(expected, mergeSort.sort(arr, MergeSort.SortOrder.DESC));
    }

    @Test
    public void mergeSortTestEmptyDesc() {
        int[] arr = {};
        int[] expected = {};
        Assert.assertArrayEquals(expected, mergeSort.sort(arr, MergeSort.SortOrder.DESC));
    }

    @Test
    public void mergeSortTestEmptyAsc() {
        int[] arr = {};
        int[] expected = {};
        Assert.assertArrayEquals(expected, mergeSort.sort(arr, MergeSort.SortOrder.ASC));
    }

    @Test
    public void mergeSortTestNullAsc() {
        Assert.assertArrayEquals(null, mergeSort.sort(null, MergeSort.SortOrder.ASC));
    }

    @Test
    public void mergeSortTestNullDesc() {
        Assert.assertArrayEquals(null, mergeSort.sort(null, MergeSort.SortOrder.DESC));
    }


}
