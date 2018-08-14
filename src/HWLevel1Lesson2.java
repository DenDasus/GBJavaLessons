/**
*   Java Level 1. Lesson 2. Homework.
*
*   @author Denis Kuzovin
*   @version Aug 13, 2018
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
        
        /*
        *   
        *
        *
        *
        */
        
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
        makeShiftRing(arr7_4, -5);
        System.out.println("Modified:\t" + Arrays.toString(arr7_4));
        System.out.println();
        
        /*
        * Решил сделать врорую версию сдвига кольцом сразу на N. 
        * В первом варианте получается N сдвигов по 1 элементу.
        * Во втором варианте получается 1 сдвиг сразу на N элементов.
        * Первый вариант требует дополнительную переменную для хранения 
        * одного элемента массива. Второй вариант требует промежуточный
        * массив для хранения N элементов. Создание промежуточных массивов
        * было запрещено заданием, однако, такая реализация, по моему
        * мнению, ускоряет процесс сдвига.
        */
        
        System.out.println("Shift right by ring version 2");
        System.out.println("Original:\t" + Arrays.toString(arr7_5));
        makeShiftRingN(arr7_5, 3);
        System.out.println("Modified:\t" + Arrays.toString(arr7_5));
        System.out.println("Shift left by ring version 2");
        System.out.println("Original:\t" + Arrays.toString(arr7_6));
        makeShiftRingN(arr7_6, -5);
        System.out.println("Modified:\t" + Arrays.toString(arr7_6));
        System.out.println();


        int[] arr7_7 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Shift right by ring version 3");
        System.out.println("Original:\t" + Arrays.toString(arr7_7));
        makeShiftRingNoArray(arr7_7, 3);
        System.out.println("Modified:\t" + Arrays.toString(arr7_7));
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

    static void findMinAndMax(int[] arr, MinMax result) {
        result.min = arr[0];
        result.max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > result.max) result.max = arr[i];
            if(arr[i] < result.min) result.min = arr[i];
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

    static void makeShiftN(int[] arr, int n) {
        if(n > 0) {
            for(int i = arr.length - 1 - n; i >= 0; i--) {
                arr[i+n] = arr[i];
            }
            for(int i = 0; i < n; i++) {
                arr[i] = 0;
            }
        } else {
            for(int i = 0 - n; i < arr.length; i++) {
                arr[i+n] = arr[i];
            }
            for(int i = arr.length - 1; i > arr.length - 1 + n; i--) {
                arr[i] = 0;
            }
        }
    }

    static void makeShiftRingRight(int[] arr) {
        int temp = arr[arr.length - 1];
        makeShiftN(arr, 1);
        arr[0] = temp;
    }

    static void makeShiftRingLeft(int[] arr) {
        int temp = arr[0];
        makeShiftN(arr, -1);
        arr[arr.length - 1] = temp;
    }

    static void makeShiftRing(int[] arr, int n) {
        if(n > 0) {
            for(int i = 0; i < n; i++) {
                makeShiftRingRight(arr);
            }
        } else {
            for(int i = 0; i > n; i--) {
                makeShiftRingLeft(arr);
            }
        }
    }

    static void makeShiftRingN(int[] arr, int n) {
        int[] tmp = new int[Math.abs(n)];

        for(int i = 0; i < Math.abs(n); i++) {

        }

        if(n > 0) {
            for(int i = 0; i < n; i++) {
                tmp[i] = arr[arr.length - n + i];
            }
            for(int i = arr.length - 1 - n; i >= 0; i--) {
                arr[i+n] = arr[i];
            }
            for(int i = 0; i < n; i++) {
                arr[i] = tmp[i];
            }
        } else {
            for(int i = 0; i < -n; i++) {
                tmp[i] = arr[i];
            }
            for(int i = 0 - n; i < arr.length; i++) {
                arr[i+n] = arr[i];
            }
            for(int i = 0; i < -n; i++) {
                arr[arr.length + n + i] = tmp[i];
            }
        }
    }

    static void makeShiftRingNoArray(int[] arr, int n) {
        int tmp1 = 0, tmp2;
        int cnt = 0;
        int i = 0;
        boolean flag1 = false;

        if(n > arr.length) {
            n = n % arr.length;
        }

        if(n % arr.length == 0) {
            flag1 = true;
        }

        tmp2 = arr[0];

        while(true) {
            int k = (i + n) % arr.length;
            tmp1 = arr[k];
            arr[k] = tmp2;
            tmp2 = tmp1;

            i = k;

            cnt++;
            if(cnt == arr.length) break;
        }

    }
}
