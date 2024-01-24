package org.example;

import java.util.Arrays;

import static java.lang.Math.*;

//iterative approach , recursive approach
//binary>jump>linear
public class Binarysearch {
//divide the array into 2 halves and perform recursion/iteration to find the key.
    // t(n)=O(logn)
    static int binarysearch(String arr[],String key){

        int l=0;
        int h= arr.length-1;

        while (l <= h) {

            // Calculatiing mid
            int m = l + (h - l) / 2;

            int res = key.compareTo(arr[m]);

            // Check if x is present at mid
            if (res == 0)
                return m;

            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                h = m - 1;
        }

        return -1;

    }

    static int ternarysearch(int arr[], int l, int r, int key){

        if(r>=1){

            //find the 2 mid values by splitting array into 3 parts
            //check if the key lies btw (l-mid1) or (mid1-mid2) or (mid2 - r)
            //T(n)=O(2 logbase3 n)

            int mid1=l+(r-l)/3;
            int mid2=r-(r-l)/3;


                if (key==arr[mid1]) {
                    return mid1;
                }
                if(key==arr[mid2]) {
                    return mid2;
                }
                if(key<arr[mid1]) {
                    return ternarysearch(arr, l, mid1 - 1, key);
                }

                else if (key>arr[mid2]) {
                    return ternarysearch(arr, mid2 + 1, r, key);
                }
                else  {
                    return ternarysearch(arr, mid1 + 1, mid2 - 1, key);
                }

            }

       return -1;
    }

    static int jumpsearch(int arr[], int key,int len){
      /* 1.jump search -by jumping through certain steps in the array.
      2. get square root (m)of length of an array n,
      3. starting from the index jumps m times until the value is > key
      4. then start doing the linear search

      */
        if (len!=0){
            Double lenth=Double.valueOf(len);
            Double sq=Math.sqrt(lenth);
        int  sqrlen= Math.toIntExact(Math.round(sq));
            int prev=0;
            for(int i=0;i<len;i+=sqrlen){

                if(arr[i]==key)
                    return i;
                if(arr[i]>key){
                    prev=i-sqrlen;
                    while(arr[prev]<=key){
                      if(arr[i]==key)
                          return i;
                      else {prev++;}

                    }
                }
            }
            return -1;
        }
        return -1;
    }

    static int interpolationsearch(int arr[], int key,int low, int high){
        /* interpolation search will be executed based on the linear interpolation formula
        y=y1+(x-x1)(y2-y1)/x2-x1
        where y=postion to find
        x1,x2 are the values of an array (arr[low],arr[high])
        y1,y2 are the index of the array (low,high)
        substituting formula,
        pos= low+(x-arr[low])(high-low)/(arr[high]-arr[low])
         T(n)=O(2log2n(log2n))
         */
        int pos;
        if(low<=high && key >=arr[low] && key<=arr[high]){ //check if the key is present within the range of an sorted array

            pos=low+(high-low)/(arr[high]-arr[low])*(key-arr[low]); //interpolation formula
            if(arr[pos]==key)
                return pos;
            if(arr[pos]>key)
                return interpolationsearch(arr,key,low,pos-1);
            if(arr[pos]<key)
                return interpolationsearch(arr,key,pos+1,high);

        }
return -1;
    }

    static int exponentialsearch(int arr[],int n, int x){
         /*
         1. find the range where the element is present
         2. do binary search in that range.
         The idea is to start with subarray size 1, compare its last element with x, then try size 2, then 4 and so on until last element of a subarray is not greater.
Once we find an index i (after repeated doubling of i), we know that the element must be present between i/2 and i (Why i/2? because we could not find a greater value in previous iteration)
      T(n)=O(logn)
         */

        if (arr[0] == x)
            return 0;

        // Find range for binary search by
        // repeated doubling
        int i = 1;
        while (i < n && arr[i] <= x)
            i = i*2;

        // Call binary search for the found range.
        return Arrays.binarySearch(arr, i/2,
                Math.min(i, n-1), x);
    }

    static int fibonaccisearch(int arr[],int key,int len){
        /* comparison based technique that use fibonacci numbers
        very useful when the input array is big
        1. find the smallest index by perform fibonacci operations
        c=a+b, until c>length and offset value=-1
        2. if c>length find the index range
        i=min(offset+fib2,len-1)
        3. if (arr[i]<key)
        fib=fib1,
        fib1=fib2
        fib2=fib-fib1
        offset=i;
        4. if (arr[i]>key)
        fib=fib2,
        fib1=fib1-fib2;
        fib2=fib-fib1
        offset=no change;
        5.arr[i]==key, return i;
        T(n)=O(logn)

        */


        int fib2=0;
        int fib1=1;
        int fib=fib2+fib1;

        while(fib<len){
            fib2=fib1;
            fib1=fib;
            fib=fib2+fib1;
        }
        int offset=0;

        while(fib>1){

             int i=min(offset+fib2,len-1);

            System.out.println("i value"+i);

            if(arr[i]<key) {
                System.out.println("inside <");
                fib = fib1;
                fib1 = fib1 - fib2;
                fib2 = fib - fib1;
                offset = i;

            }
             else if(arr[i]>key){
                System.out.println("inside > ");
                 fib=fib2;
                 fib1=fib1-fib2;
                 fib2=fib-fib1;
             }


             else //if(arr[i]==key)
                 return i;
        }
        if(fib1==1 && arr[len-1]==key) {
            return len - 1;
        }
        return -1;
    }

    public static void main(String args[])
    {

        //String arr[] = {"apple", "ball","cat","dog","eagle","fox","gigs","hexa","isotope","jax","kuckoo","logo","meta","nexa","octa","penta","quantum","radix","src","tetra"};
        int array[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        int n = array.length;
        String x = "gigs";
        long startTime = System.nanoTime();
        //int result = ternarysearch(array,0,n-1,9);
       // int result = binarysearch(arr, x);
       // int result=interpolationsearch(array,18,0,n-1);
       // int result=jumpsearch(array,0,n);
        //int result=exponentialsearch(array,n,9);
        int result=fibonaccisearch(array,11,n);
        if (result<0)
            System.out.println( "Element is not present in array");
        else
            System.out.println("Element is present at " + "index " + result);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime)/1000000;
        System.out.println("time taken by the method--"+duration);
        //


    }

}
