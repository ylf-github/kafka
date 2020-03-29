package com.ylf.demo.kafka;

import java.util.Arrays;

/**
 * @author: leifeng.ye
 * @date: 2020-03-27
 * @desc:
 */
public class Sort {
    static int[] array=new int[]{1,5,3,6,8};

    public static void main(String[] args) {
        new Sort().sort(array,0,array.length-1);
        Arrays.stream(array).forEach(System.out::println);
    }

    public int quick(int[] array,int low,int high){
        int temp=array[low];
        while (high>low){
            while (high>low&&array[high]>temp)
                high--;
            array[low]=high;
            while (high>low&&array[low]<=temp)
                low++;
            array[high]=array[low];
        }
        array[low]=temp;
        return low;
    }

    public void sort(int[] array,int low,int high){
        if(low<high){
            int mid=quick(array,low,high);
            sort(array,low,mid);
            sort(array,mid+1,high);
        }

    }
}
