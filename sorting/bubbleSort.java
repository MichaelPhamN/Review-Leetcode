package sorting;
public class bubbleSort {
    private static void bubble_sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) 
            for(int j = 0; j < arr.length - i - 1; j++) 
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
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
        bubble_sort(arr);
        printArray(arr);
    }
}
