package org.example;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] unsortedList = {3, 10, 5, 4, 1, 8};
        int n = unsortedList.length;
        /* merge sort */
        System.out.println(Arrays.toString(unsortedList));
        mergeSort(unsortedList, n);
        System.out.println(Arrays.toString(unsortedList) + "\n");

        /* remove even */
        System.out.println(removeEven(makeRandomList()) + "\n");

        /* find min max and even*/
        findMinMax(makeRandomList());
    }

    /** Реализовать алгоритм сортировки слиянием */
    public static void mergeSort(int[] src, int n) {
        if (n < 2) return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        System.arraycopy(src, 0, left, 0, mid);
        System.arraycopy(src, mid, right, 0, n - mid);

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(src, left, right, mid, n - mid);
    }
    public static void merge(int[] src, int[] left, int[] right, int leftLength, int rightLength) {
        int k = 0, i = 0, j = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) src[k++] = left[i++];
            else src[k++] = right[j++];
        }

        while (i < leftLength) {
            src[k++] = left[i++];
        }

        while (j < rightLength) {
            src[k++] = right[j++];
        }
    }

    /**Пусть дан произвольный список целых чисел, удалить из него четные числа */

    public static ArrayList makeRandomList() {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Random random = new Random();
            int num = random.nextInt(100);
            array.add(num);
        }
        System.out.println(array);
        return array;
    }
    public static ArrayList removeEven(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                array.remove(i);
                i--;
            }
        }
        return array;
    }

    /** Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка. */
    public static void findMinMax(ArrayList<Integer> array) {
        Collections.sort(array);
        System.out.println("Минимальное число: " + array.get(0));
        System.out.println("Максимальное число: " + array.get(array.size() - 1));
        System.out.println("Среднее число: " + array.get((array.size() - 1) / 2));
    }
}