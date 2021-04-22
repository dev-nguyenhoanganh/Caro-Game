/**
 * @Project_Name Caro Game
 */
package com.hoanganh.logic;

import com.hoanganh.common.Constant;

/**
 * @author Hoang Anh
 * @since 1 thg 2, 2021
 * @version 1.0
 */
public class CaroTable {
//	private static final int ROW    = 15;
//	private static final int COLUMN = 15;
	
	private String [][] table;
	private String [][] displayTable;
	
	
	private int undoCount;
	private int redoCount;
	
	
	/**
	 * 
	 */
	public CaroTable() {
		undoCount 	 = 0;
		redoCount    = 0;
		
	}

	
	public boolean checkWin(int x, int y, String name) {
		int k, j;
		int d = 0;
		
		// Kiểm tra chiều dọc
		for (k = -4; k <= 4; k++) {
			if (x + k >= 0 && x + k < Constant.ROW) {

			}
		}
		
		return false;
	}
	
	public boolean undo() {

		return false;
	}
	
//	public boolean redo() {
//		
//		return true;
//	}
}
