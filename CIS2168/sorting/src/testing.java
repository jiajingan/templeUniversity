import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class testing {
    //all sorting came from google

    //this program will keep tracks of number of comparisons, exchanges, and total runtimes
    public static int[] InsertionSort(int[] arr) {
        int comparsions = 0;
        int exchanges = 0;
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                comparsions++;
                exchanges++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            exchanges++;
            arr[j + 1] = key;
        }
        //System.out.println(Arrays.toString(arr));
        return new int[]{exchanges, comparsions};
    }

    public static int[] partition(int[] arr, int first, int last, int comparisons, int exchanges){ // https://www.geeksforgeeks.org/quick-sort/ i used this to learn about the algorithm for partition

        int[] ret = new int[3]; // change

        // System.out.println("num exchange: " + exchanges);
        int bigger = first;

        for (int i = first + 1; i <= last; i++){ // i will be the smaller item that you switch with the bigger item
            comparisons++;
            comparisons++;
            if(arr[i] < arr[first]){ // if i is less than pivot then do the switch
                bigger++; // increment bigger into the non sorted zone of bigger nums
                exchanges++;
                int temp = arr[i];
                arr[i] = arr[bigger];
                arr[bigger] = temp;
            }
        }
        comparisons++;
        exchanges++;
        int temp = arr[first]; // switch the pivot with the number that is next to the numbers that are bigger than the pivots
        arr[first] = arr[bigger];
        arr[bigger] = temp;


        ret[2] = exchanges;
        ret[1] = comparisons;
        ret[0] = bigger;

        return ret; // return bigger;
    }


    public static int[] quickSort(int[] arr, int first, int last, int comparisons, int exchanges){
        int[] info = new int[3];
        info[1] = comparisons;
        info[2] = exchanges;

        info[1]++; // info[1] = comparisons
        if(first < last){

            info = partition(arr, first, last, info[1], info[2]);
            int bound = info[0];

            info = quickSort(arr, first, bound - 1, info[1], info[2]);
            info = quickSort(arr, bound + 1, last, info[1], info[2]);
        }


        return info;
    }

    public static int[] partition1(int array[], int start, int end){
//        int pivot = end;
        //int counter  = start;
        int comparsions = 0;
        int exchanges = 0;

        int pivot = array[end];
        int i = (start-1);

        for (int j=start; j < end; j++) {
            comparsions++;
            if (array[j] < pivot)
            {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                exchanges += 2;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;
        exchanges += 2;

        return new int[]{i + 1, comparsions, exchanges};
    }

    public static int[] quick1(int array[], int start, int end){

        int compares = 0;
        int exchanges = 0;
        compares++;
        if (end > start) {
            int[] a = partition1(array, start, end);
            int pi = a[0];
            compares += a[1];
            exchanges += a[2];
            int[] x = quick1(array, start, pi-1);
            compares += x[0];
            exchanges += x[1];
            int[] y = quick1(array, pi+1, end);
            compares += y[0];
            exchanges += y[1];
        }
        return new int[]{compares, exchanges};
    }


    public static int[] shell(int array[]){
        int comparsions = 0;
        int exchanges = 0;
        //this is shell sort
        int n = array.length;
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                    exchanges++;
                    comparsions++;
                }
                exchanges++;
                array[j] = temp;
            }
        }
        //System.out.println(Arrays.toString(array));
        return new int[]{exchanges, comparsions};
    }

    public static int[] randomArray(int size){
        Random random = new Random();
        int [] array =  new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);

        }
        return array;
    }


    public static void main(String[] args) throws IOException {
        int reference[] = {2, 4, 8, 16 , 32 ,64 , 128};
        int array[] = {128, 64, 32, 16, 8, 4, 2};

        String path = "/home/jackie/IdeaProjects/CIS2168/sorting/sorting.csv";
        String path1 = "/home/jackie/IdeaProjects/CIS2168/sorting/sorting1.csv";
        String path2 = "/home/jackie/IdeaProjects/CIS2168/sorting/sorting2.csv";

        FileWriter csvWriter = new FileWriter(path,true);
        FileWriter csvWriter1 = new FileWriter(path1,true);
        FileWriter csvWriter2 = new FileWriter(path2,true);

        csvWriter.append("type,size,time,comparisons,exchanges");
        csvWriter1.append("type,size,time,comparisons,exchanges");
        csvWriter2.append("type,size,time,comparisons,exchanges");

        for (int i = 4; i < 1050 ; i*=2) {
            for (int j = 0; j < 10; j++) {
                int[] a, b, c;
                a = randomArray(i);
                b = randomArray(i);
                c = randomArray(i);
                System.out.println("run:" + j);
                if (i % 2 == 0) {
                    //int[] a, b, c  = randomArray(i);
                    System.out.println(i);
                    long startTime = System.nanoTime();
                    int[] insert = InsertionSort(a);
                    long InsertEnd = System.nanoTime() - startTime;
                    int[] quick = quickSort(b, 0, b.length - 1, 0 , 0);
                    long quickEnd = System.nanoTime() - startTime;
                    int[] shell = shell(c);
                    long shellEnd = System.nanoTime() - startTime;
                    csvWriter.append("\n" + "insertion" + ",");
                    csvWriter.append(i + ",");
                    csvWriter.append(InsertEnd + ",");
                    csvWriter.append(insert[0] + ",");
                    csvWriter.append(insert[1] + ",");

                    csvWriter1.append("\n" + "quick" + ",");
                    csvWriter1.append(i + ",");
                    csvWriter1.append(quickEnd + ",");
                    csvWriter1.append(quick[1] + ",");
                    csvWriter1.append(quick[2] + ",");

                    csvWriter2.append("\n" + "shell" + ",");
                    csvWriter2.append(i + ",");
                    csvWriter2.append(shellEnd + ",");
                    csvWriter2.append(shell[0] + ",");
                    csvWriter2.append(shell[1] + ",");
                }
            }
            csvWriter.append("\n");
            csvWriter1.append("\n");
            csvWriter2.append("\n");

            csvWriter.append("\n");
            csvWriter1.append("\n");
            csvWriter2.append("\n");

        }
        csvWriter.close();
        csvWriter1.close();
        csvWriter2.close();




        System.out.print("time in nanoseconds = ");
        System.out.println(System.nanoTime());
        System.out.print("time in milliseconds = ");
        System.out.println(System.currentTimeMillis());
    }
}
