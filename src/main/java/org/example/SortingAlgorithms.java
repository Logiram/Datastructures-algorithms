package org.example;

public class SortingAlgorithms {
//selection sort
 void Selectionsort(int arr[], int n){
        /* arr=[12,3,2,45,31]
        comparing the each element with the smallest / min element by traversing the array
        3,5,2,4,33,44,1,12,0,22,13
        T(n)=O(n^2)
         */

     for (int i = 0; i < n-1; i++)
     {
         // Find the minimum element in unsorted array
         int min_idx = i;
         for (int j = i+1; j < n; j++)
             if (arr[j] < arr[min_idx])
                 min_idx = j;

         // Swap the found minimum element with the first
         // element
         int temp = arr[min_idx];
         arr[min_idx] = arr[i];
         arr[i] = temp;
     }
 }

 //bubble sort

    void bubblesort(int arr[], int n){
/*
traverse from left and compare adjacent elements and the higher one is placed at right side.
In this way, the largest element is moved to the rightmost end at first.
This process is then continued to find the second largest and place it and so on until the data is sorted.
*/
     int i,j,temp;
     boolean swapped;
     for( i=0;i<n-1;i++){
         swapped = false;
         for( j=0;j<n-i-1;j++){
             if(arr[j]>arr[j+1]) {
                 // swap the larger element to right
                 temp = arr[j];
                 arr[j] = arr[j + 1];
                 arr[j + 1] = temp;
                 swapped = true;
             }
         }
         if(!swapped)
             break;
     }
    }

    void printarray(int arr[]){
     for(int i=0;i<arr.length;i++){
         System.out.print(arr[i]+",");
        }
    }

    public static void main(String a[]){
        SortingAlgorithms ob=new SortingAlgorithms();
        int array[]={3,5,2,4,33,44,1,12,0,22,13};
        int n = array.length;
        long startTime = System.nanoTime();
       // ob.Selectionsort(array,n);
        ob.bubblesort(array,n);
        System.out.print("[");
        ob.printarray(array);
        System.out.print("]");
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        System.out.println("time taken by the method--"+duration);


    }

}
