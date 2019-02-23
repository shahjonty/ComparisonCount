import java.util.*;

/*
 *  Quicksort Implementation with Five Pivot Choice techniques
 *  and
 *  Input Sequence Data Generator
 * */


public class QuickSort
{
    private int compareA;
    private int compareB;
    private int compareC;
    private int compareD;
    private int compareE;
    public QuickSort(){
        compareA = 0;
        compareB = 0;
        compareC = 0;
        compareD = 0;
        compareE = 0;
    }
    public int QuickSortPivotA(int [] array)
    {
        /*
        Implement the quicksort with pivot as the last element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */


        return QuickSortPivotA(array, 0, array.length - 1);
    }

    private int QuickSortPivotA(int[]  array, int low, int high){
        int index = 0;
        if(low < high){
            compareB += high - low;
            // int pivot = array[high];
            int pivot = high;
            index = partitionA(array, low, high, pivot);
            if (high - low<= 5) {
                insertSort(array, low , high);
            }
            QuickSortPivotA(array, low, index - 1);
            QuickSortPivotA(array, index + 1, high);
        }
        return compareB;
    }


    private int partitionA(int[] array, int low, int high, int pivot) {
        int pivotValue = array[pivot];
        int temp = array[pivot];
        array[pivot] = array[high];
        array[high] = temp;
        int pivotFinal = low;
        for (int k = low; k < high; k++) {
            if (array[k] <= pivotValue) {
                int temp2 = array[k];
                array[k] = array[pivotFinal];
                array[pivotFinal] = temp2;
                pivotFinal++;
            }
        }
        int temp2 = array[pivotFinal];
        array[pivotFinal] = array[high];
        array[high] = temp2;
        return pivotFinal;
    }

    private int[] insertSort(int[] temp, int low, int high){
        for(int i = low; i < high; i++){
            for(int j = i; j > low; j--){
                compareB++;
                if(temp[j] < temp[j - 1]){
                    int x = temp[j];
                    temp[j] = temp[j - 1];
                    temp[j - 1] = x;
                } else {
                    break;
                }
            }
        }
        return temp;
    }

    public int QuickSortPivotB(int [] array)
    {
        /*
        Implement the quicksort with pivot as the first element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */

        return QuickSortPivotB(array, 0, array.length - 1);
    }

    private int QuickSortPivotB(int[]  array, int low, int high){
        int compare = 0;
        int index = 0;
        if(low < high){
            compareB += high - low;
            int pivot = low;
            index = partitionA(array, low, high, pivot);
            if (high - low + 1 <= 5) {
                insertSort(array, low , high);
            }
            QuickSortPivotB(array, low, index - 1);
            QuickSortPivotB(array, index + 1, high);
        }
        return compareB;
    }


    public int QuickSortPivotC(int [] array)
    {
        /*
        Implement the quicksort with pivot as the middle element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */

        return QuickSortPivotC(array, 0, array.length - 1);
    }

    private int QuickSortPivotC(int[]  array, int low, int high){
        int compare = 0;
        int index = 0;

        if(low < high){
            compareB += high - low;
            int pivot = (high - low + 1) / 2 + low;
            index = partitionA(array, low, high, pivot);
            if (high - low <= 5) {
                insertSort(array, low , high);
            }
            QuickSortPivotC(array, low, index - 1);
            QuickSortPivotC(array, index + 1,  high);
        }
        return compareB;
    }



    public int QuickSortPivotD(int [] array)
    {
        /*
        Implement the quicksort with pivot as the median of the first, middle and last elements of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */
        return QuickSortPivotD(array, 0, array.length - 1);
    }

    private int QuickSortPivotD(int[]  array, int low, int high){
        int compare = 0;
        int index = 0;
        if(low < high){
            compareB += high - low;
            int pivot = getMedian(array, low, high);
            index = partitionA(array, low, high, pivot);
            if (high - low  <= 5) {
                insertSort(array, low , high);
            }
            QuickSortPivotD(array, low, index - 1);
            QuickSortPivotD(array, index + 1 , high);
        }
        return compareB;
    }

    private int getMedian(int[] array, int low, int high){
        int median = (high - low + 1) / 2 + low;
        int[] temp = {array[low], array[median], array[high]};
        temp = insertSort(temp, 0, temp.length);
        if(temp[1] == array[low]){
            return low;
        } else if(temp[1] == array[median]){
            return median;
        } else {
            return high;
        }
    }

    public int QuickSortPivotE(int [] array)
    {
        /*
        Implement the quicksort with pivot as the median of five elements of the sequence, chosen to be roughly 10%,
         30%, 50%, 70% and 90% of the way through the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */

        return QuickSortPivotE(array, 0, array.length - 1);
    }


    private int QuickSortPivotE(int[]  array, int low, int high){
        if(low < high) {
            int pivot = getMedian5(array, high - low + 1, low);
            int index = partitionA(array, low, high, pivot);
            compareB += high - low;
            if (high - low + 1 <= 5) {
                insertSort(array, low , high);
            }
            QuickSortPivotE(array, low, index - 1);
            QuickSortPivotE(array, index + 1, high);
        }
        return compareB;
    }

    private int getMedian5(int[] array, int n, int low) {
        int num1 = n / 10 + low;
        int num2 = (3 * n ) / 10 + low;
        int num3 = (5 * n) / 10 + low;
        int num4 = (7 * n) / 10 + low;
        int num5 = (9 * n) / 10 + low;

        int[] temp = new int[5];
        temp[0] = array[num1];
        temp[1] = array[num2];
        temp[2] = array[num3];
        temp[3] = array[num4];
        temp[4] = array[num5];

        temp = insertSort(temp, 0, temp.length);
        if(temp[2] == array[num1]){
            return num1;
        } else if(temp[2] == array[num2]){
            return num2;
        } else if(temp[2] == array[num3]){
            return num3;
        } else if(temp[2] == array[num4]){
            return num4;
        } else {
            return num5;
        }
    }


    /*
     *
     * Implement the rest of the functions required to do the quicksort for every variation.
     * */


    public int[] GenerateInputSequence1(int N)
    {
        /*
         * return an array with the sequence 1, 2, 3, ..., N (in increasing order).
         * For example, if N = 1000, then the sequence would be: 1, 2, 3, 4, 5, ..., 1000
         * */
        int[] array = new int[N];
        for(int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }
        return array;

    }

    public int[] GenerateInputSequence2(int N)
    {
        /*
         * return an array with The sequence N, N-1, ..., 2, 1 (in decreasing order).
         * For example, if N = 1000, then the sequence would be: 1000, 999, ..., 2, 1
         * */
        int[] array = new int[N];
        int count = 0;
        for (int i = array.length; i >= 1; i-- ){
            array[count] = i;
            count++;
        }
        return array;
    }

    public int[] GenerateInputSequence3(int N)
    {
        /*
         * return an array with The sequence 1, 3, 5, ..., N-1, 2, 4, 6, ..., N.
         * For example,  if N = 1000, then the sequence would be: 1, 3, 5, ..., 999, 2, 4, 6, ..., 1000
         * */
        int[] array = new int[N];
        int count = 0;
        for(int i = 1; i <= N; i+=2){
            array[count] = i;
            count++;
        }

        for(int i = 2; i <= N; i += 2){
            array[count] = i;
            count++;
        }
        return array;
    }

    public int[] GenerateInputSequence4(int N)
    {
        /*
         * return an array with the sequence 1, 3, 5, ..., N-3, N-1, N, N-2, N-4, ..., 4, 2.
         * For example,  if N = 1000, then the sequence would be: 1,3,5 ...,997,999,1000,998,996, ..., 4,2
         * */
        int[] array = new int[N];
        int count = 0;
        for(int i = 1; i <= N; i += 2){
            array[count] = i;
            count++;
        }
        for(int i = N; i >= 2; i -= 2){
            array[count] = i;
            count++;
        }

        return array;
    }

    public int[] GenerateInputSequence5(int N)
    {
        /*
         * return an array with sequence 1, N, 2, N-1, 3, N-2, 4, N-3, ..., N/2, (N/2)+1.
         * For example,  if N = 1000, then the sequence would be: 1, 1000, 2, 999, 3, 998, 4, 997, ..., 500, 501
         * */
        int[] array = new int[N];
        int count  = 0;
        int num1 = 1;
        int num2 = N;
        while(count < N){
            array[count] = num1;
            array[++count] = num2;
            num1++;
            num2--;
            count++;
        }
        return array;
    }


    public int[] GenerateInputSequence6(int N)
    {
        /*
         * return an array with the sequence: Each number is (7 + the previous number) mod N.
         * That is, a(i) = (7 + a(i-1)) mod N, a(0)=0
         * For example,  if N = 1000, then the sequence would be: 0, 7, 14, ..., 994, 1, 8, ..., 993
         */
        int[] array = new int[N];
        int count = 1;
        array[0] = 0;
        while(count < N){
            array[count] = (7 + array[count - 1]) % N;
            count++;
        }
        return array;

    }


    public int[] GenerateInputSequence7(int N)
    {
        /*
         * return an array with The sequence: The first N Fibonacci numbers modulo N:
         * a(0) = 0; a(1) = 1; a(i) = (a(i-1) + a(i-2)) mod N for 1 < i < N.         *
         * */
        int[] array = new int[N];
        int count = 2;
        array[0] = 0;
        array[1] = 1;
        while(count < N){
            array[count] = (array[count - 1] + array[count - 2]) % N;
            count++;
        }



        return array;
    }


    public int[] GenerateInputSequence8(int N)
    {
        /*
         * return an array with The sequence The first N powers of 2 modulo N:
         * a(0) = 1; a(i) = (2*a(i-1)) mod N for 0 < i < N.
         * */
        int[] array = new int[N];
        int count = 1;
        array[0] = 1;
        while(count < N){
            array[count] = (2 * array[count - 1]) % N;
            count++;
        }
        return array;
    }


    public int[] GenerateInputSequence9(int N)
    {
        /*
         * return an array with The sequence: The first N powers of 3 modulo N:
         * a(0) = 1; a(i) = (3*a(i-1)) mod N for 0 < i < N.
         * */

        int[] array = new int[N];
        int count = 1;
        array[0] = 1;
        while(count < N){
            array[count] = (3 * array[count - 1]) % N;
            count++;
        }
        return array;
    }


    public int[] GenerateInputSequence10(int N, int RNG_Seed)
    {
        /*
         * return an array with The sequence N, N-1, ..., 2, 1 (in decreasing order).
         * A random sequence using the methods in java.util.Random: Use setSeed(long seed) to set the seed using
         * a nine-digit which will be an input to your method. Use nextInt()%10000 N times to get N random integers
         * between -9999 and 9999.  Use these in the order generated as the sequence.
         * Example:Random generator = new Random();
         * generator.setSeed(123456789);   // 123456789 is example, seed will be input
         * int num = generator.nextInt()%10000; // will be called N times to complete the sequence
         * */
        Random generator = new Random();
        generator.setSeed(RNG_Seed);
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = generator.nextInt() % 10000;
        }
        return array;
    }


    public static void main(String[] args)
    {

        QuickSort ob = new QuickSort();
        int arr[] = ob.GenerateInputSequence3(40);



        ob.QuickSortPivotA(arr, 0, arr.length - 1);

        System.out.println("sorted array");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
        System.out.println(ob.compareB);

    }
}