/**
*   Java Level 1. Lesson 2. Homework.
*
*   @author Denis Kuzovin
*   @version Aug 13, 2018
*/

import java.util.Arrays;

public class HWLevel1Lesson2 {
    public static void main(String[] args) {
        // Task 1
        System.out.println("*** Task 1 ***");
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Original:\t" + Arrays.toString(arr1));
        invertData(arr1);
        System.out.println("Modified:\t" + Arrays.toString(arr1));
        System.out.println();
        
        // Task 2
        System.out.println("*** Task 2 ***");
        int[] arr2 = new int[8];
        System.out.println("Original:\t" + Arrays.toString(arr2));
        fillData(arr2);
        System.out.println("Modified:\t" + Arrays.toString(arr2));
        System.out.println();
        
        // Task 3
        System.out.println("*** Task 3 ***");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Original:\t" + Arrays.toString(arr3));
        multiplySmallNumbers(arr3);
        System.out.println("Modified:\t" + Arrays.toString(arr3));
        System.out.println();
        
        // Task 4
        System.out.println("*** Task 4 ***");
        int[][] arr4 = new int[10][10];
        System.out.println("Original:");
        for(int i = 0; i < arr4.length; i++) {
            System.out.println(Arrays.toString(arr4[i]));
        }
        fillDiagonals(arr4);
        System.out.println();
        System.out.println("Modified:");
        for(int i = 0; i < arr4.length; i++) {
            System.out.println(Arrays.toString(arr4[i]));
        }
        System.out.println();
        
        //Task 5
        System.out.println("*** Task 5 ***");
        int[] arr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        Integer min = new Integer(0);
        Integer max = new Integer(0);
        findMinAndMax(arr5, min, max);
        
        System.out.println("Array: " + Arrays.toString(arr5));
        System.out.println("min = " + min + ", max = " + max);
        
        System.out.println();
        
        //Task 6
        System.out.println("*** Task 6 ***");
        int[] arr6_1 = {1, 1, 1, 2, 1};
        int[] arr6_2 = {2, 1, 1, 2, 1};
        int[] arr6_3 = {10, 10};
        System.out.println(Arrays.toString(arr6_1) + " result: " + checkBalance(arr6_1));
        System.out.println(Arrays.toString(arr6_2) + " result: " + checkBalance(arr6_2));
        System.out.println(Arrays.toString(arr6_3) + " result: " + checkBalance(arr6_3));
        System.out.println();
        
        //Task 7
        System.out.println("*** Task 7 ***");
        
        System.out.println();
    }
    
    static void invertData(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                arr[i] = 1;
            else
                arr[i] = 0;
        }
    }
    
    static void fillData(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            arr[i] = i * 3;
        }
    }
    
    static void multiplySmallNumbers(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 6)
                arr[i] *= 2;
        }
    }
    
    static void fillDiagonals(int[][] arr) {
        for(int i = 0, j = 0; i < arr.length && j < arr[i].length; i++, j++) {
            arr[i][j] = 1;
            arr[arr.length - i - 1][j] = 1;
        }
    }
    
    static void findMinAndMax(int[] arr, Integer min, Integer max) {
        min = arr[0];
        max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];
        }
    }
    
    static boolean checkBalance(int[] arr) {
        int sum1 = 0, sum2 = 0;
        
        for(int i : arr) {
             sum2 += i;
        }
        
        for(int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 -= arr[i];
            if(sum1 == sum2) return true;
        }
        return false;
    }
    
    static void makeShift(int arr, int n) {
        
    }
    
    static void makeShiftRing(int arr, int n) {
        
    }
}
