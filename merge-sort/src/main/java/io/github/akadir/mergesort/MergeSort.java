package io.github.akadir.mergesort;

/**
 * @author akadir
 * Date: 24.04.2020
 * Time: 14:59
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] sort = {1, 2, 3, 4, 5};

        MergeSort mergeSort = new MergeSort();

        mergeSort.sort(sort, SortOrder.DESC);
    }

    public enum SortOrder {
        ASC, DESC;
    }

    public int[] sort(int[] arr, SortOrder order) {
        if (arr == null) {
            return null;
        }

        mergeSort(arr, 0, arr.length - 1, order);
        return arr;
    }

    public void mergeSort(int[] arr, int start, int end, SortOrder order) {
        if (start < end) {
            int middle = (start + end) / 2;

            mergeSort(arr, start, middle, order);
            mergeSort(arr, middle + 1, end, order);

            merge(arr, start, middle, end, order);
        }
    }

    private void merge(int[] arr, int start, int middle, int end, SortOrder order) {
        int[] left = new int[middle - start + 1];
        int[] right = new int[end - middle];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[start + i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[middle + 1 + i];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int index = start;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (SortOrder.ASC == order) {
                if (left[leftIndex] < right[rightIndex]) {
                    arr[index] = left[leftIndex];
                    leftIndex++;
                } else {
                    arr[index] = right[rightIndex];
                    rightIndex++;
                }
            } else if (SortOrder.DESC == order) {
                if (left[leftIndex] > right[rightIndex]) {
                    arr[index] = left[leftIndex];
                    leftIndex++;
                } else {
                    arr[index] = right[rightIndex];
                    rightIndex++;
                }
            } else {
                throw new RuntimeException("Unknown order: " + order);
            }
            index++;
        }

        while (leftIndex < left.length) {
            arr[index] = left[leftIndex];
            leftIndex++;
            index++;
        }

        while (rightIndex < right.length) {
            arr[index] = right[rightIndex];
            rightIndex++;
            index++;
        }
    }
}
