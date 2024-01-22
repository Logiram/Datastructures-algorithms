package org.example;
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

    static int jumpsearch(int arr[], int key){
      /* 1.jump search -by jumping through certain steps in the array.
      2. get square root (m)of length of an array n,
      3. starting from the index jumps m times until the value is > key
      4. then start doing the linear search
      */



        return -1;
    }

    public static void main(String args[])
    {

        String arr[] = {"apple", "ball","cat","dog","eagle","fox","gigs","hexa","isotope","jax","kuckoo","logo","meta","nexa","octa","penta","quantum","radix","src","tetra"};
        int array[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        int n = array.length;
        String x = "gigs";
        long startTime = System.nanoTime();
        //int result = ternarysearch(array,0,n-1,9);
        int result = binarysearch(arr, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println("Element is present at "
                    + "index " + result);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime)/1000000;
        System.out.println("time taken by the method--"+duration);
        //


    }

}
