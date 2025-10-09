package com.sourceallies.interview;

public class Conway {
    private int[][] cells;

    public Conway(int[][] initialBoard) {
        this.cells = initialBoard;
    }

    // 1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    // 2. Any live cell with two or three live neighbours lives on to the next generation.
    // 3. Any live cell with more than three live neighbours dies, as if by overpopulation.
    // 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    public void tick() {
        int[][] initial = cells.clone();
        for(int i = 0; i < this.cells.length; i++) {
            for (int j = 0; j < this.cells[0].length; j++) {
                // check alive neighbors
                int live = countAliveNeighbors(i, j, initial);
                
                // 1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                if (live < 2) {
                    cells[i][j] = 0;
                }
                // 2. Any live cell with two or three live neighbours lives on to the next generation.

                // 3. Any live cell with more than three live neighbours dies, as if by overpopulation.
                if (live > 3) {
                    cells[i][j] = 0;
                }
                // 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
                if (live == 3) {
                    cells[i][j] = 1;
                }
            }
        }

        System.out.println("Hello");
    }

    private int countAliveNeighbors(int row, int col, int[][] initial) {
        int count = 0;
        // top
        if (row > 0 && initial[row - 1][col] == 1) {
            count++;
        }
        // right
        if (col + 1 < initial[0].length && initial[row][col + 1] == 1) {
            count++;
        }
        // bottom
        if (row + 1 < initial.length && initial[row + 1][col] == 1) {
            count++;
        }
        // left
        if (col > 0 && initial[row][col - 1] == 1) {
            count++;
        }
        // right top
        if (row > 0 && col + 1 < initial[0].length && initial[row - 1][col + 1] == 1) {
            count++;
        }
        // right bottom
        if (col + 1 < initial[0].length && row + 1 < initial.length && initial[row + 1][col + 1] == 1) {
            count++;
        }
        // left bottom
        if (row + 1 < initial.length && col > 0 && initial[row + 1][col - 1] == 1) {
            count++;
        }
        // left top
        if (row > 0 && col > 0 && initial[row - 1][col - 1] == 1) {
            count++;
        }
        return count;
    }

    public int[][] getCells() {
        return this.cells;
    }
}
