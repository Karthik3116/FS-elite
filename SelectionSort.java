import java.util.Scanner;
import java.util.Arrays;

public class SelectionSort {

    public static void selc_sort(int[]arr){

        for(int i = 0 ; i < arr.length - 1; i++){

            int local_min = arr[i] , idx = i;

            for(int j = i+1 ; j < arr.length; j++){

                if(arr[j] < local_min  ){
                    local_min = arr[j];
                    idx = j;
                }
            }

            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[]arr = new int[size];

        for(int i = 0 ; i < size ; i++){
            arr[i] = sc.nextInt();
        }

        selc_sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
