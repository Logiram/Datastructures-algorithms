package org.example;
//easy problems
//[1,2,3,1,2,3]

/*leng of num =3
add the element after the array
a[3]=a[1] ---> until length of num

 create new A array with leng -2*nums array
         length of nums=3
i=0, A[i+leng]

 */
public class Arrays {
/*concatenation of an array(2 times)
eg:
i/p= [1,2,3]
o/p=[1,2,3,1,2,3]
 */
        public int[] getConcatenation(int[] nums) {
            int numslength=arraylength(nums);
            int arrnew[]= new int [2*numslength];
            if (numslength!= 0) {
                for(int i=0; i<numslength;i++) {
                    arrnew[i] = nums[i];
                    arrnew[i + numslength] = nums[i];
                }
                }
            return arrnew;
        }
 /* array permutation
eg:
i/p  num= [0,2,1]
o/p ans=[0,1,2]
ie., num[num[0]]
1. get length of an array
2.traverse the array and also the element should be within (<=)length
3. get element of array of array
 */
        public int[] buildpermutationarray(int [] nums){
            int numslength=arraylength(nums);

            int ans[]=new int[numslength];
            if (numslength!= 0) {
                for (int i = 0; (i < numslength && nums[i] < numslength); i++) {
                        ans[i] = nums[nums[i]];
                }
            }
            return ans;
        }



       int arraylength(int[] arr){
            int count=0;
           for (int i:arr) {
               count++;
           }
           return count;
    }


        public void printarray(int[] finalarr){
        for (int arr:finalarr) {
        System.out.print(arr+" ");
        }
        }


        public static void main(String a[]){
            Arrays arr= new Arrays();
            int[] ans= {5,0,1,2,3,6};
           // int[] finals= arr.getConcatenation(ans);
            int[] finalperarray=arr.buildpermutationarray(ans);
            arr.printarray(finalperarray);
        }



}

