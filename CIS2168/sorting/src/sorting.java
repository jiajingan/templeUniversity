import java.util.Arrays;



public class sorting {
    //https://stackabuse.com/insertion-sort-in-java/
    //https://stackoverflow.com/questions/24073503/why-cant-we-change-the-order-of-statements-in-insertion-sorts-while-loop

    public static void insert(int array[]){
        for (int i = 0; i <array.length ; i++) {
            int current  = array[i];
            int j = i-1;
            while ((j > -1) && (array[j] > current)){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        //return 0;
    }

    public static int partition(int array[], int start, int end){
        int pivot = end;
        int counter  = start;
        for (int i = start; i < end; i++) {
            if (array[i] < array[pivot]){
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
    }

    public static void quick(int array[], int start, int end){
        if (end <= start){
            return;
        }
        int pivot = partition(array, start, end);
        quick(array, start , pivot-1);
        quick(array, pivot+1, end);
    }



    //https://stackabuse.com/merge-sort-in-java/
    public static void third(int array[]){

        int n = array.length;
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {

                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int reference[] = {2, 4, 8, 16 , 32 ,64 , 128};
        int array[] = {128, 4 , 16, 8 , 32 , 2 , 64};

//        insert(array);
//        System.out.println(Arrays.toString(array));

//        quick(array, 0 ,array.length-1);
//        System.out.println(Arrays.toString(array));

        third(array);
        System.out.println(Arrays.toString(array));

        System.out.print("time in nanoseconds = ");
        System.out.println(System.nanoTime());
        System.out.print("time in milliseconds = ");
        System.out.println(System.currentTimeMillis());
    }
}
