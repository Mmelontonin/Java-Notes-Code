import java.util.*;

public class sortingTest {

    // swap adjacent elements if they're in wrong order
    static void bubbleSort(int[] arr){
        for (int i : arr) {  // Iterates through each element (but we don't use the value)
        // Inner loop: Compare adjacent elements
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {  // If elements are out of order
                    // swap elements
                    int tmp = arr[j];      // Store current element
                    arr[j] = arr[j + 1];   // Move smaller element left
                    arr[j + 1] = tmp;      // Move larger element right

                    // print arary after each swap
                    System.out.println("Swapped " + arr[j+1] + " and " + arr[j] + ": " + Arrays.toString(arr));
                }
            }
        }
    }
    // 1 elem @ a time by inserting ea elem into its correct position for small or nearly sorted datasets
    //  Start from 2nd element (index 1)
    static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {  
            int key = arr[i];  // Current element to insert
            int j = i - 1;     // Start comparing with previous element
            
            // Shift elements greater than 'key' rightwards
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // Move larger element right
                j--;                  // Check next left element
            }
            
            // Insert key in correct position
            arr[j + 1] = key;

            //print array after each insertion
            System.out.println("Inserted " + key + " at position " + (j+1) + ": " + Arrays.toString(arr));
            }
        }

    // divide & conque alg that split the array into halves, sorts them
    // & merges them for large datasets where stability is important
    static void mergeSort(int[] arr){
        if (arr.length <=1) return;
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);

        System.out.println("Split into left: " + Arrays.toString(left) + " and right: " + Arrays.toString(right));

        mergeSort(left);
        mergeSort(right);
        merge(arr,left,right);

        System.out.println("Merged: " + Arrays.toString(arr));

    }

    // merge helper function for mergeSort
    static void merge(int[] arr,int[] left,int[] right){
        int i = 0, j=0,k=0;

        //merge while both arrays have elements
        while (i< left.length && j<right.length){
            if (left[i] <= right[j]){
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
            System.out.println("Merging step: " + Arrays.toString(arr));
        }

        // Copy remaining elements from left array
        while(i < left.length){
            arr[k++] = left[i++];
            System.out.println("Copying remaining from left: " + Arrays.toString(arr));
        }

        // Copy remaining elements from right array
        while (j< right.length){
            arr[k++] = right[j++];
            System.out.println("Copying remaining from right: " + Arrays.toString(arr));
        }
    }

    // divide & conqure using pivot element to partition the array
    // use for large datasets
    static void quickSort(int[] arr, int low, int high){
        if (low < high){
            int pivot = partition(arr,low,high);
            System.out.println("After partitioning (pivot at " + pivot + "): " + Arrays.toString(arr));

            // recursively sort elements before and after pivot
            quickSort(arr, low,pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    // partition method - choses poivot & rearrages the array
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high]; //right most elem as pivot
        System.out.println("\nPartitioning subarray from position " + low + " to " + high + " with pivot " + pivot);
        int i = low-1; // index of smaller element

        for (int j=low; j<high; j++){
            // if curr element < pivot
            if (arr[j] < pivot){
                i++;
                // swap arr[i] and arr[j]
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                System.out.println("Swapped " + arr[j] + " and " + arr[i] + ": " + Arrays.toString(arr));
            }
        }
        // Swap arr[i+1] and pivot (arr[high])
        int tmp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = tmp;

        System.out.println("Final pivot placement: " + Arrays.toString(arr));
        return i+1; //returns pivot index
    }
     

    public static void main(String[] args){
        int[] original = {1, 9, 0, 5, 7, 6};
        System.out.println(Arrays.toString(original));
        
        // Bubble Sort
        int[] bubbleArr = Arrays.copyOf(original, original.length);
        System.out.println("Bubble Sort:");
        bubbleSort(bubbleArr);
        
        // Insertion Sort
        int[] insertionArr = Arrays.copyOf(original, original.length);
        System.out.println("\nInsertion Sort:");
        insertionSort(insertionArr);
        
        // Merge Sort
        int[] mergeArr = Arrays.copyOf(original, original.length);
        System.out.println("\nMerge Sort:");
        mergeSort(mergeArr);
        
        // Quick Sort
        int[] quickArr = Arrays.copyOf(original, original.length);
        System.out.println("\nQuick Sort:");
        quickSort(quickArr, 0, quickArr.length - 1);
    }
}
