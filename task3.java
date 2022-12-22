import java.util.Random;
import java.util.Arrays;

/* Реализовать алгоритм пирамидальной сортировки (HeapSort). */

public class task3 {
    public static void main(String[] args) {
        Random random = new Random();
        int length = 15;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(150);
        }
        System.out.println("Сгенерированный массив:\n" + Arrays.toString(array));
        HeapSort(array);
        System.out.println("Сортированный массив: \n" + Arrays.toString(array));
    }

    public static void HeapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int j = n - 1; j >= 0; j--) {
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            heapify(arr, j, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[max]) {
            max = left;
        }
        if (right < n && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, n, max);
        }

    }
}
