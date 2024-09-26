package com.Data_Structures_byprayush.Algorithms.Recursion.BackTracking;

public class allPaths {
    public static void main(String[] args) {
        boolean[][] arr = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        char[][] a = new char[3][3];
        String s = "";
        allPath(arr, 0, 0, a,s );

    }

    private static void printMatrix(char[][] arr) {
        for (char[] chars : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

    private static void allPath(boolean[][] mat, int r, int c, char[][] ans, String path) {
        // Base case: reached the bottom-right corner
        if (r == mat.length - 1 && c == mat[0].length - 1) {
            ans[r][c] = 'E'; // Mark the end point
            System.out.println("Path: " + path);
            printMatrix(ans);
            ans[r][c] = '\0'; // Reset the end point -> backtrack for matrix
            return;
        }

        // Check boundaries and obstacles
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || !mat[r][c]) {
            return;
        }

        // Mark the cell as visited
        mat[r][c] = false;

        // Move down
        if (r < mat.length - 1) {
            ans[r][c] = 'D';
            allPath(mat, r + 1, c, ans, path + "D");
            ans[r][c] = '\0'; // Reset after backtracking
        }

        // Move right
        if (c < mat[0].length - 1) {
            ans[r][c] = 'R';
            allPath(mat, r, c + 1, ans, path + "R");
            ans[r][c] = '\0'; // Reset after backtracking
        }

        // Move up
        if (r > 0) {
            ans[r][c] = 'U';
            allPath(mat, r - 1, c, ans, path + "U");
            ans[r][c] = '\0'; // Reset after backtracking
        }

        // Move left
        if (c > 0) {
            ans[r][c] = 'L';
            allPath(mat, r, c - 1, ans, path + "L");
            ans[r][c] = '\0'; // Reset after backtracking
        }

        // Unmark the cell (backtrack)
        mat[r][c] = true;
    }
}
