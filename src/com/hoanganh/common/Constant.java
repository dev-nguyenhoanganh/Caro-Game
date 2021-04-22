/**
 * 
 */
package com.hoanganh.common;

import java.awt.Font;

/**
 * 
 * @Description
 *
 * @Author Nguyễn Hoàng Anh
 * @Version 1.0
 */
public class Constant {
	// Kích thước của panel và frame
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;

	// Kích thước của mảng button
	public static final int COLUMN = 15;
	public static final int ROW = 15;
	public static final int SIZE = 20;


	// Kích thước của từng button bên trong mảng
	public static final int CELL_HIGHT = 30;
	public static final int CELL_WIDTH = 30;
	public static final int MARGIN = 30;

	// Font chữ mặc định
	public static Font fontNormal = new Font("Calibri", Font.BOLD, 30);
	public static Font fontHeader = new Font("Calibri", Font.BOLD, 40);

	// Logic constant
	public static final int LENGTH_WIN = 20;

	// Xác định người đánh trước hoặc máy đánh trước
	public static final int USER_FIRST = -1;
	public static final int COMPUTER_FIRST = 1;
}
