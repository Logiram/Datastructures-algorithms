package org.example;

/*
Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8

Input: mat = [[5]]
Output: 5
*/
public class matrix {
    public int diagonalSum(int[][] mat) {

        int n= mat.length;
        System.out.println("length of matrix--"+n);
        int sum=0;
        if(n==1)
            sum= mat[0][0];
        else{

            for(int i=0;i<n;i++){
                for(int j=i;j<mat[i].length;j++){
                    System.out.println("ivalue=="+i+"  j value=="+j);
                    if((n%2==1)&& (n/2==1) ) {
                        if (i == j) {
                            sum += mat[i][j];
                        } else {
                            sum += mat[i][j] + mat[i][n - j - 1];
                        }
                    }
                    else{
                        sum+=mat[i][j]+mat[i][n-j-1];
                    }

                }
            }

        }
        return sum;
    }

    public static void main(String args[]){
        matrix Matrix= new matrix();
        //int[][] matarry= {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matarry= {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(Matrix.diagonalSum(matarry));
    }
}
