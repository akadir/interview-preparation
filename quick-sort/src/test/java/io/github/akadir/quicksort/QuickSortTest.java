package io.github.akadir.quicksort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author akadir
 * Date: 24.04.2020
 * Time: 22:49
 */
public class QuickSortTest {
    private QuickSort quickSort;

    @Before
    public void initialize() {
        quickSort = new QuickSort();
    }

    @Test
    public void quickSortTestAscDesc() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        Assert.assertArrayEquals(expected, quickSort.sort(arr, QuickSort.SortOrder.DESC));
    }

    @Test
    public void quickSortTestAscAsc() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, quickSort.sort(arr, QuickSort.SortOrder.ASC));
    }

    @Test
    public void quickSortTestDescAsc() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, quickSort.sort(arr, QuickSort.SortOrder.ASC));
    }

    @Test
    public void quickSortTestDescDesc() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {5, 4, 3, 2, 1};
        Assert.assertArrayEquals(expected, quickSort.sort(arr, QuickSort.SortOrder.DESC));
    }

    @Test
    public void quickSortTestEmptyDesc() {
        int[] arr = {};
        int[] expected = {};
        Assert.assertArrayEquals(expected, quickSort.sort(arr, QuickSort.SortOrder.DESC));
    }

    @Test
    public void quickSortTestEmptyAsc() {
        int[] arr = {};
        int[] expected = {};
        Assert.assertArrayEquals(expected, quickSort.sort(arr, QuickSort.SortOrder.ASC));
    }

    @Test
    public void quickSortTestNullAsc() {
        Assert.assertArrayEquals(null, quickSort.sort(null, QuickSort.SortOrder.ASC));
    }

    @Test
    public void quickSortTestNullDesc() {
        Assert.assertArrayEquals(null, quickSort.sort(null, QuickSort.SortOrder.DESC));
    }

}
