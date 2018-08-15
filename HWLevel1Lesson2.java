/**
 * Java Level 1. Lesson 2. Homework.
 *
 * @author Denis Kuzovin
 * @version Aug 15, 2018
 */

import java.util.Arrays;


public class HWLevel1Lesson2 {
    
    public class MinMax {
        public int min;
        public int max;
    }
    
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
        for (int i = 0; i < arr4.length; i++) {
            System.out.println(Arrays.toString(arr4[i]));
        }
        fillDiagonals(arr4);
        System.out.println();
        System.out.println("Modified:");
        for (int i = 0; i < arr4.length; i++) {
            System.out.println(Arrays.toString(arr4[i]));
        }
        System.out.println();
        
        //Task 5
        System.out.println("*** Task 5 ***");
        int[] arr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        
        HWLevel1Lesson2 hw = new HWLevel1Lesson2();
        MinMax res = hw.new MinMax();
        
        findMinAndMax(arr5, res);
        
        System.out.println("Array: " + Arrays.toString(arr5));
        System.out.println("min = " + res.min + ", max = " + res.max);
        
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
        int[] arr7_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr7_2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr7_3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr7_4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr7_5 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr7_6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Shift right with loss");
        System.out.println("Original:\t" + Arrays.toString(arr7_1));
        makeShiftN(arr7_1, 5);
        System.out.println("Modified:\t" + Arrays.toString(arr7_1));
        System.out.println("Shift left with loss");
        System.out.println("Original:\t" + Arrays.toString(arr7_2));
        makeShiftN(arr7_2, -5);
        System.out.println("Modified:\t" + Arrays.toString(arr7_2));
        
        System.out.println("Shift right by ring");
        System.out.println("Original:\t" + Arrays.toString(arr7_3));
        makeShiftRing(arr7_3, 5);
        System.out.println("Modified:\t" + Arrays.toString(arr7_3));
        System.out.println("Shift left by ring");
        System.out.println("Original:\t" + Arrays.toString(arr7_4));
        makeShiftRing(arr7_4, -20);
        System.out.println("Modified:\t" + Arrays.toString(arr7_4));
        
        System.out.println("Shift right by ring version 2");
        System.out.println("Original:\t" + Arrays.toString(arr7_5));
        makeShiftRingNoArray(arr7_5, 3);
        System.out.println("Modified:\t" + Arrays.toString(arr7_5));
        System.out.println("Shift left by ring version 2");
        System.out.println("Original:\t" + Arrays.toString(arr7_6));
        makeShiftRingNoArray(arr7_6, -21);
        System.out.println("Modified:\t" + Arrays.toString(arr7_6));
    }
    
    // Task 1
    static void invertData(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                arr[i] = 1;
            else
                arr[i] = 0;
        }
    }
    
    //Task 2
    static void fillData(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
    }
    
    //Task 3
    static void multiplySmallNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] *= 2;
        }
    }
    
    //Task 4
    static void fillDiagonals(int[][] arr) {
        for (int i = 0, j = 0; i < arr.length && j < arr[i].length; i++, j++) {
            arr[i][j] = 1;
            arr[arr.length - i - 1][j] = 1;
        }
    }
    
    //Task 5
    static void findMinAndMax(int[] arr, MinMax result) {
        result.min = arr[0];
        result.max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > result.max) result.max = arr[i];
            if (arr[i] < result.min) result.min = arr[i];
        }
    }
    
    //Task 6
    static boolean checkBalance(int[] arr) {
        int sum1 = 0, sum2 = 0;
        
        for (int i : arr) {
            sum2 += i;
        }
        
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 -= arr[i];
            if (sum1 == sum2) return true;
        }
        return false;
    }
    
    //Task 7 (Shift with data loss)
    static void makeShiftN(int[] arr, int n) {
        if (n > 0) {
            for (int i = arr.length - 1 - n; i >= 0; i--) {
                arr[i + n] = arr[i];
            }
            for (int i = 0; i < n; i++) {
                arr[i] = 0;
            }
        } else {
            for (int i = 0 - n; i < arr.length; i++) {
                arr[i + n] = arr[i];
            }
            for (int i = arr.length - 1; i > arr.length - 1 + n; i--) {
                arr[i] = 0;
            }
        }
    }
    
    //Task 7 (Ring shift the entire array N times for one element)
    static void makeShiftRing(int[] arr, int n) {
        if (n == 0) return;
        if (Math.abs(n) >= arr.length) {
            n = n % arr.length;
        }
        
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int temp = arr[arr.length - 1];
                makeShiftN(arr, 1);
                arr[0] = temp;
            }
        } else {
            for (int i = 0; i > n; i--) {
                int temp = arr[0];
                makeShiftN(arr, -1);
                arr[arr.length - 1] = temp;
            }
        }
    }
    
    //Task 7 (Ring shift of the entire array 1 time by N elements)
    //Ring shift to the left by N elements is equivalent to shifting to the right by (arr.length - N) elements.
    static void makeShiftRingNoArray(int[] arr, int n) {
        if (Math.abs(n) >= arr.length) {
            n = n % arr.length;
        }
        
        if (n == 0) return;
        
        if (n < 0) {
            n = arr.length + n;
        }
        
        int tmp1, tmp2;
        int cnt = 0;
        int currElem = 0;
        
        tmp2 = arr[currElem];
        
        while (cnt < arr.length) {
            int nextElem = (currElem + n) % arr.length;
            
            // Handle the case of returning to a previously processed array element.
            if ((currElem + n) >= arr.length && ((cnt + 1) * n) % arr.length == 0) {
                tmp1 = arr[nextElem + 1];
                currElem = nextElem + 1;
            } else {
                tmp1 = arr[nextElem];
                currElem = nextElem;
            }
            
            arr[nextElem] = tmp2;
            tmp2 = tmp1;
            
            cnt++;
        }
    }
}
