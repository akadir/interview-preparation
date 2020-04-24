package io.github.akadir.quicksort;

/**
 * @author akadir
 * Date: 24.04.2020
 * Time: 21:45
 */
public class QuickSort {
    public enum SortOrder {
        ASC, DESC;
    }

    public int[] sort(int[] arr, SortOrder order) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        quickSort(arr, 0, arr.length - 1, order);
        return arr;
    }

    private void quickSort(int[] arr, int start, int end, SortOrder order) {
        if (start < end) {
            int partition = partition(arr, start, end, order);

            quickSort(arr, start, partition - 1, order);
            quickSort(arr, partition + 1, end, order);
        }
    }

    private int partition(int[] arr, int start, int end, SortOrder order) {
        int partition = arr[end];

        int lowIndex = start - 1;

        for (int i = start; i < end; i++) {
            if (SortOrder.ASC == order) {
                if (arr[i] < partition) {
                    lowIndex++;
                    int tmp = arr[i];
                    arr[i] = arr[lowIndex];
                    arr[lowIndex] = tmp;
                }
            } else {
                if (arr[i] > partition) {
                    lowIndex++;
                    int tmp = arr[i];
                    arr[i] = arr[lowIndex];
                    arr[lowIndex] = tmp;
                }
            }

        }

        int tmp = arr[lowIndex + 1];
        arr[lowIndex + 1] = arr[end];
        arr[end] = tmp;
        return lowIndex + 1;
    }
}
