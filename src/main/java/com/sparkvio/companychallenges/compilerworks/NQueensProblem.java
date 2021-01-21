package com.sparkvio.companychallenges.compilerworks;

public class NQueensProblem {

	public static void main(String[] args) {

		placeQueens(8);
	}

	private static boolean[][] getBoard(int dimention) {

		boolean[][] board = new boolean[dimention][dimention];
		return board;
	}

	private static void printBoard(boolean[][] board) {
		for (boolean[] column : board) {
			for (boolean value : column) {
				if (value) {

					System.out.print(" Q");
				} else {
					System.out.print(" _");
				}
			}
			System.out.println("\n");
		}
	}

	private static void placeQueens(int dimention) {

		/* Get board. */
		boolean[][] board = getBoard(dimention);

		/* Start with 0, 0. */
		for (int rowCounter = 0; rowCounter < dimention - 1; rowCounter++) {
			for (int columnCounter = 0; columnCounter < dimention - 1; columnCounter++) {

				/* Check if any other queen exists on same column or row. */
				if (!isDnDirectionsSafe(board, columnCounter, rowCounter)) {
					continue;
				}

				/* Check if any other queen exists on LT direction. */
				if (!isLTDirectionSafe(board, columnCounter, rowCounter)) {
					continue;
				}

				/* Check if any other queen exists on RT direction. */
				if (!isRTDirectionSafe(board, columnCounter, rowCounter)) {
					continue;
				}

				/* Check if any other 3 queens exists . */

				/* Mark queen position. */
				board[rowCounter][columnCounter] = true;
				break; // Skip remaining columns.
			}
		}

		printBoard(board);
	}

	private static boolean isDnDirectionsSafe(boolean[][] board, int columnNum, int rowNum) {
		for (int rowNavigator = 0; rowNavigator < rowNum; rowNavigator++) {
			if (board[rowNavigator][columnNum]) {
				return false;
			}
		}
		return true;
	}

	private static boolean isRTDirectionSafe(boolean[][] board, int columnNum, int rowNum) {

		for (int columnNavigator = columnNum + 1; columnNavigator < board.length; columnNavigator++) {
			int rowOffset = columnNavigator - columnNum;
			int rowDn = (rowNum - rowOffset) >= 0 ? rowNum - rowOffset : -1;

			if (board[rowNum][columnNavigator]) {
				return false;
			} else if (rowDn != -1 && board[rowDn][columnNavigator]) {
				return false;
			}
		}
		return true;
	}

	private static boolean isLTDirectionSafe(boolean[][] board, int columnNum, int rowNum) {
		for (int columnNavigator = 0; columnNavigator < columnNum; columnNavigator++) {
			int rowOffset = columnNum - columnNavigator;
			int rowDn = (rowNum - rowOffset) >= 0 ? rowNum - rowOffset : -1;

			if (board[rowNum][columnNavigator]) {
				return false;
			} else if (rowDn != -1 && board[rowDn][columnNavigator]) {
				return false;
			}
		}
		return true;
	}
}
