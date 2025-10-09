package com.sourceallies.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ConwayTest {
    @Test
    void testUnderPopulationOneLiveCell() {
        // Setup
        int[][] initialBoard = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        int[][] expected = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        // Execution
        var board = new Conway(initialBoard);
        board.tick();

        // Assertion
        int[][] cells = board.getCells();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                assertEquals(cells[i][j], expected[i][j]);
            }
        }
    }
    
    @Test
    void testTwoOrThreeNeighborsSurvives() {
        // Setup
        int[][] initialBoard = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 0}
        };
        int[][] expected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 0}
        };

        // Execution
        var board = new Conway(initialBoard);
        board.tick();

        // Assertion
        int[][] cells = board.getCells();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                assertEquals(cells[i][j], expected[i][j], String.format("Cell at row %d, col %d was incorrect", i, j));
            }
        }
    }

    @Test
    void testDeadCellBecomesAlive() {
        // Setup
        int[][] initialBoard = {
            {1, 1, 0},
            {1, 0, 0},
            {0, 0, 0}
        };
        int[][] expected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 0}
        };

        // Execution
        var board = new Conway(initialBoard);
        board.tick();

        // Assertion
        int[][] cells = board.getCells();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                assertEquals(cells[i][j], expected[i][j], String.format("Cell at row %d, col %d was incorrect", i, j));
            }
        }
    }
    
    @Test
    void testLine() {
        // Setup
        int[][] initialBoard = {
            {0, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        };
        int[][] expected = {
            {0, 0, 0},
            {1, 1, 1},
            {0, 0, 0}
        };

        // Execution
        var board = new Conway(initialBoard);
        board.tick();

        // Assertion
        int[][] cells = board.getCells();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                assertEquals(cells[i][j], expected[i][j], String.format("Cell at row %d, col %d was incorrect", i, j));
            }
        }
    }
}
