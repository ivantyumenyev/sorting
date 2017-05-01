package my.projects;

import java.util.Random;

public class Main {

    private static final int NUM_COUNT = 50;

    public static void main(String[] args) {
        int[] array = new int[NUM_COUNT];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

//        lineSort(array);
//        quickSort(array, 0, (array.length - 1));
        mergeSort(array);

        for (int num : array) {
            System.out.println(num);
        }

    }

    public static void lineSort(int[] array){

        for (int i = 0; i < array.length - 1; i++){
            for (int j = i + 1; j < array.length; j++){
                if (array[i] > array[j]){
                    int change = array[i];
                    array[i] = array[j];
                    array[j] = change;
                }
            }
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        int i = start;
        int j = end;

        Random random = new Random();
        int pivot = array[start + random.nextInt(end - start + 1)];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (start < j){
            quickSort(array, start, j);
        }
        if(i < end){
            quickSort(array, i, end);
        }
    }

    public static int[] mergeSort(int[] array){
        if (array.length <= 1) {
            return array;
        }

        int[] leftHalf = new int[array.length / 2];
        System.arraycopy(array, 0, leftHalf, 0, leftHalf.length);
        mergeSort(leftHalf);

        int[] rightHalf = new int[array.length - leftHalf.length];
        System.arraycopy(array, leftHalf.length, rightHalf, 0, rightHalf.length);
        mergeSort(rightHalf);

        merge(leftHalf, rightHalf, array);
        return array;
    }

    public static void merge(int[] leftHalf, int[] rightHalf, int[] result){
        int leftPos = 0;
        int rightPos = 0;
        int mergedPos = 0;

        while (leftPos < leftHalf.length && rightPos < rightHalf.length){
            if (leftHalf[leftPos] < rightHalf[rightPos]){
                result[mergedPos] = leftHalf[leftPos];
                leftPos++;
            } else {
                result[mergedPos] = rightHalf[rightPos];
                rightPos++;
            }
            mergedPos++;
        }

        System.arraycopy(leftHalf, leftPos, result, mergedPos, leftHalf.length - leftPos);
        System.arraycopy(rightHalf, rightPos, result, mergedPos, rightHalf.length - rightPos);

    }

}
