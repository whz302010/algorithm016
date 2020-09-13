package AlgorithmExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @description
 * @author:wuhaizhong
 * @date:2020/9/6
 * 将数组中0移到末尾，且保持其他元素相对位置
 * 双指针算法
 */
public class RemoveZero {

    /**
     * 时间复杂度O(n)
     * 空间复杂度（arr.length*2)
     * @param arr
     * @return
     */
    private static int[] removeZero1(int[] arr){
        int[] copyArray = new int[arr.length];
        int copyIndex=0;
        int zeroCount =0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i]!=0){
                copyArray[copyIndex++] = arr[i];
            }else {
                copyArray[arr.length-1-zeroCount] =0;
                zeroCount++;
            }
        }
        return copyArray;
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度arr.length
     * @param arr
     * @return
     */
    private static int[] removeZero2(int[] arr){
        for (int i=0,j=0;i<arr.length;i++) {
            if (arr[i]!=0){
                arr[j] = arr[i];
                if (i!=j){
                    arr[i] = 0;
                }
                j++;
            }
        }

        return arr;
    }

    /**
     * 思路：j為0所在index
     * @param arr
     * @return
     */
    private static int[] removeZero3(int[] arr){
        int j=0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i]!=0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,0,4,-1,0,3,0,11,321,44,0,-30};
        System.out.println(Arrays.toString(removeZero3(arr)));
    }
}
