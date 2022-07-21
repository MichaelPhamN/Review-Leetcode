package sorting;
public class selectionSort {
    private static void selection_sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
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
        selection_sort(arr);
        printArray(arr);
    }
}
