import java.util.Arrays;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements in the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Sort the array in ascending order
        Arrays.sort(array);

        System.out.print("Enter the search key: ");
        int key = scanner.nextInt();

        long linearSearchStartTime = System.nanoTime();
        int linearSearchResult = linearSearch(array, key);
        long linearSearchEndTime = System.nanoTime();
        long linearSearchTime = linearSearchEndTime - linearSearchStartTime;

        long improvedLinearStartTime = System.nanoTime();
        int improvedLinearSearch = improvedLinearSearch(array, key);
        long improvedLinearEndTime = System.nanoTime();
        long improvedLinearSearchTime = improvedLinearEndTime - improvedLinearStartTime;

        long interpolationSearchStartTime = System.nanoTime();
        int interpolationSearchResult = interpolationSearch(array, key);
        long interpolationSearchEndTime = System.nanoTime();
        long interpolationSearchTime = interpolationSearchEndTime - interpolationSearchStartTime;

        System.out.println("Using Linear Search:");
        if (linearSearchResult != -1) {
            System.out.println("Search key FOUND at index " + linearSearchResult + ".");
        } else {
            System.out.println(""
            		+ "Search key NOT FOUND.");
        }
        System.out.println("Linear Search Time: " + linearSearchTime + " nanoseconds");

        System.out.println("Using Hybrid Search:");
        if (improvedLinearSearch != -1) {
            System.out.println("Search key FOUND at index " + improvedLinearSearch + ".");
        } else {
            System.out.println("Search key NOT FOUND.");
        }
        System.out.println("Improved Linear Search Time: " + improvedLinearSearchTime + " nanoseconds");

        System.out.println("Using Interpolation Search:");
        if (interpolationSearchResult != -1) {
            System.out.println("Search key FOUND at index " + interpolationSearchResult + ".");
        } else {
            System.out.println("Search key NOT FOUND.");
        }
        System.out.println("Interpolation Search Time: " + interpolationSearchTime + " nanoseconds");
    }

    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return i;
        }
        return -1;
    }

    public static int improvedLinearSearch(int[] array, int key) {
        int low = 0, high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == key)
                return mid;
            else if (array[mid] < key)
                low = mid + 1;
            else {
                // Perform linear search in the smaller segment
                for (int i = low; i < mid; i++) {
                    if (array[i] == key)
                        return i;
                }
                return -1;
            }
        }
        return -1;
    }

    public static int interpolationSearch(int[] array, int key) {
        int low = 0, high = array.length - 1;

        while (low <= high && key >= array[low] && key <= array[high]) {
            if (low == high) {
                if (array[low] == key)
                    return low;
                return -1;
            }

            int pos = low + ((key - array[low]) * (high - low)) / (array[high] - array[low]);
            int mid = low + (pos - low) * (high - low) / (array[high] - array[low]);

            if (key < array[mid])
                high = mid - 1;
            else if (array[mid] < key)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
