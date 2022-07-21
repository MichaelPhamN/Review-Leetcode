package sorting;
public class mergeSort {
    private static void merge_sort(int[] arr, int l, int r) {
        if(l < r) {
            int m = l + (r - l) / 2;
            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l , int m, int r) {
        int[] L = new int[m - l + 1];
        int[] R = new int[r - m];

        for(int i = 0; i < L.length; i++) L[i] = arr[l + i];
        for(int i = 0; i < R.length; i++) R[i] = arr[m + i + 1];
        
        int i = 0;
        int j = 0;
        int k = l;

        while(i < L.length && j < R.length) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < L.length) {            
            arr[k] = L[i];
            i++;            
            k++;
        }

        while (j < R.length) {
            arr[k] = R[j];
            j++;
            k++;
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
        merge_sort(arr, 0, arr.length - 1);
        printArray(arr);
    }
    
}
