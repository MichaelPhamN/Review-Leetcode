package sorting;
public class insertionSort {
    private static void insertion_sort(int[] arr) {
        int size = arr.length;
        for(int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;
            // Compare key with each element on the left of it until an element smaller than it is found
            // For descending order, change key < arr[i] to key > arr[j]
            while(j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Place key at after the element just smaller than it
            arr[j + 1] = key;
        }
    }

    private static void printArray(int[] arr) {
        for(int element : arr) {
            System.out.print(element + "  ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        printArray(arr);
        insertion_sort(arr);
        printArray(arr);
    }
}
