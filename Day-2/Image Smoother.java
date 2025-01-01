class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;

        // Apply the average function to each pixel in the image matrix
        int[][] result = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result[r][c] = calculateAverage(img, r, c, rows, cols);
            }
        }

        return result;        
    }

    private int calculateAverage(int[][] img, int r, int c, int rows, int cols) {
        int total = 0;
        int count = 0;

        // Define the boundaries for the neighboring pixels
        int top = Math.max(0, r - 1);
        int bottom = Math.min(rows, r + 2);
        int left = Math.max(0, c - 1);
        int right = Math.min(cols, c + 2);

        // Iterate over the neighboring pixels and calculate the sum and count
        for (int row = top; row < bottom; row++) {
            for (int col = left; col < right; col++) {
                total += img[row][col];
                count += 1;
            }
        }

        // Calculate and return the average value for the pixel
        return total / count;
    }    
}