package com.Data_Structures_byprayush.problems;
// Approach to rotate a matrix 90 degree, by first taking the transpose of the matrix and then reversing each row.
public class IMPORTANT_Rotate_matrix {
    public void rotate(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)//For rows
        {
            //matrix[0].length - The number of columns on row 0 - [Another way of saying how many columns are there in this 2D matrix]
            for (int j = i; j <matrix.length ; j++)//For columns
            {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix [j][i];
                matrix[j][i]=temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++)//As we only
                // have to interchange the index at even positions
                // we can run the condition matrix.length/2
            {
               int temp = 0;
               temp = matrix[i][j];
               matrix[i][j]=matrix[i][matrix.length-1-j];//matix.length-1 will
                // give last element in column, -j is for when we get to
                // second iteration, we have to move the j pointer to
                // the second last element in the column.
                matrix[i][matrix.length-1-j]=temp;
            }
        }
    }
}
