/**
 * @Project_Name Caro Game
 */
package com.hoanganh.logic;

import java.util.Random;

import com.hoanganh.common.Constant;

/**
 * @author Hoang Anh
 * @since 1 thg 2, 2021
 * @version 1.0
 */
public class Computer {
	private static int nextMoveX;
	private static int nextMoveY;
	private static int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	private static int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
	
	private static Random rand = new Random();
	
	/**
	 * Phương thức sinh số nguyên ngẫu nhiên nhỏ hơn N
	 * 
	 * @param n - giá trị biên
	 * @return [int] - luôn nhỏ hơn hoặc bằng n
	 */
	public static int RandomInt(int n) {
		return rand.nextInt(n);
	}

	/**
	 * Phương thức lấy ra tọa độ X của nước đi tiếp theo
	 * 
	 * @return [int] - Tọa độ X của nước đi tiếp theo
	 */
	public static int getNextMoveX() {
		return nextMoveX;
	}

	/**
	 * Phương thức lấy ra tọa độ Y của nước đi tiếp theo
	 * 
	 * @return [int] - Tọa độ Y của nước đi tiếp theo
	 */
	public static int getNextMoveY() {
		return nextMoveY;
	}

	/**
	 * Mô phỏng lại bàn cờ đang hiển thị trên giao diện, 
	 * ánh xạ vào tham số <b><code>table</code></b> <br>
	 * <code>
	 *      table[col][row] = 1 // máy đánh <br>
	 *      table[col][row] = -1 // người đánh
	 * </code>
	 *
	 * @param table    - Bàn cờ được xạ từ giao điện
	 * @param size     - Kích thước của bàn cờ
	 * @param nStep    - Số nước đã đánh
	 * @param x        - Mảng lưu vị trí theo chiều ngang các ô cờ được đánh
	 * @param y        - Mảng lưu vị trí theo chiều ngang các ô cờ được đánh
	 * @param whoFirst - Xác định người đánh trước hay máy đánh trước
	 */
	public static void createTable(int[][] table, int nStep, int[] x, int[] y, int whoFirst) {
		// Reset thông số cho mảng table
		for (int i = 0; i < Constant.SIZE; i++) {
			for (int j = 0; j < Constant.SIZE; j++) {
				table[i][j] = 0;
			}
		}

		for (int i = 0; i < nStep; i++) {
			if (whoFirst == -1) {
				if (i % 2 == 0) {
					table[x[i]][y[i]] = -1;
				} else {
					table[x[i]][y[i]] = 1;
				}
			} else {
				if (i % 2 == 0) {
					table[x[i]][y[i]] = 1;
				} else {
					table[x[i]][y[i]] = -1;
				}
			// Kết thúc else
			}
		// Kết thúc for
		}
	// Kết thúc hàm
	}

	/**
	 * Kiểm tra điều kiện thắng
	 * 
	 * @param nStep    - Số nước đi hiện tại
	 * @param x        - Mảng lưu vị trí theo chiều ngang các ô cờ được đánh
	 * @param y        - Mảng lưu vị trí theo chiều ngang các ô cờ được đánh
	 * @param whoFirst - Xác định người đánh trước hay máy đánh trước
	 * @return
	 * [ 1] - Máy thắng <br>
	 * [-1] - Người thắng <br>
	 * [ 0] - Khi không có giá trị nào được đánh
	 */
	public static int checkWin(int nStep, int[] x, int[] y, int whoFirst) {
		// Tạo ma trận table có size bằng kích thước của bàn cờ
		int[][] table = new int[Constant.SIZE][Constant.SIZE];

		// Ánh xạ các giá trị đang được hiển thị trên giao diện vào bàn cờ này
		createTable(table, nStep, x, y, whoFirst);

		// Duyệt tất cả các vị trí trong table
		for (int i = 0; i < Constant.SIZE; i++) {
			for (int j = 0; j < Constant.SIZE; j++) {

				// Nếu vị trí này được người hoặc máy đánh
				if (table[i][j] != 0) {
					// Duyệt 8 trường hợp 
					// dọc tăng, dọc giảm, ngang tăng, ngang giảm,
					// Chéo chính tăng, chéo chính giảm, chéo phụ tăng, chéo phụ giảm
					for (int t = 0; t < dx.length; t++) {
						// Biến đếm giá trị cho các ô đã kiểm tra
						int sum = 0;

						for (int k = 0; k < Constant.LENGTH_WIN; k++) {
							// Vị trí column 
							int u = i + k * dx[t];
							// Vị trí row
							int v = j + k * dy[t];

							// Kiểm tra điều kiện tồn tại cho biến vị trí u, v
							if ((u >= 0) && (u < Constant.SIZE) && (v >= 0) && (v < Constant.SIZE)) {
								if (table[u][v] != table[i][j]) {
									break;
								}
								sum += table[u][v];
							} else {
								break;
							}
						}

						// Máy thắng
						if (sum == Constant.LENGTH_WIN) {
							return 1;
						}
						// Người thắng
						if (sum == -Constant.LENGTH_WIN) {
							return -1;
						}
					}
				}
			}
		}

		return 0;
	}

	/**
	 * Tìm vị trí tối ưu để máy tính đánh quân cờ
	 *
	 * @param table  - Bàn cờ được xạ từ giao điện
	 * @param length - Kích thước của ma trận duyệt
	 * @param sum    - Tổng kiểm tra
	 * @return
	 * [true] - Tìm thấy giá trị phù hợp <br>
	 * [false] - Không tìm thấy giá trị phù hợp
	 */
	public static boolean searchSum(int[][] table, int length, int sum) {
		int foundX = 0;
		int foundY = 0;

		// Duyệt tất cả các vị trí trong bàn cờ
		for (int i = 0; i < Constant.SIZE; i++) {
			for (int j = 0; j < Constant.SIZE; j++) {
				// sum < 0 : Tìm vị trí chặn
				// sum > 0 : Tìm vị trí công
				if (table[i][j] * sum >= 0) {
					// Duyệt 8 trường hợp 
					// dọc tăng, dọc giảm, ngang tăng, ngang giảm,
					// Chéo chính tăng, chéo chính giảm, chéo phụ tăng, chéo phụ giảm
					for (int t = 0; t < dx.length; t++) {
						// 
						boolean check = true;
						// Biến đếm giá trị cho các ô đã kiểm tra
						int temp_sum = 0;

						for (int k = 0; k < length; k++) {
							// Vị trí column 
							int u = i + k * dx[t];
							// Vị trí row 
							int v = j + k * dy[t];

							// Kiểm tra điều kiện tồn tại cho biến vị trí u, v
							if ((u >= 0) && (u < Constant.SIZE) && (v >= 0) && (v < Constant.SIZE)) {
								// 
								if (table[u][v] * sum >= 0) {
									temp_sum += table[u][v];

									if (table[u][v] == 0) {
										foundX = u;
										foundY = v;
									} else {
										check = false;
										break;
									}
								} else {
									check = false;
									break;
								}
							}
						}

						if (check) {
							if (temp_sum == sum) {
								nextMoveX = foundX;
								nextMoveY = foundY;
								return true;
							}
						// Kết thúc điều kiện
						}
					// Kết thúc vòng for duyệt theo các hàng, cột, đường chéo
					}
				// Kết thúc điều kiện
				}
			// Kết thúc duyệt theo hàng
			}
		// Kết thúc duyệt theo cột
		}

		return false;
	}

	/**
	 * Sử dụng thuật toán để tìm nước đi tiếp theo cho máy
	 * 
	 * @param nStep    - Số nước đi hiện tại
	 * @param x        - Mảng lưu vị trí theo chiều ngang các ô cờ được đánh
	 * @param y        - Mảng lưu vị trí theo chiều ngang các ô cờ được đánh
	 * @param whoFirst - Xác định người đánh trước hay máy đánh trước
	 */
	public static void findNextMove(int nStep, int[] x, int[] y, int whoFirst) {
		// Trường hợp máy đánh trước
		if (nStep == 0) {
			nextMoveX = 10;
			nextMoveY = 10;
			return;
		}

		int table[][] = new int[Constant.SIZE][Constant.SIZE];
		createTable(table, nStep, x, y, whoFirst);

		//
		if (searchSum(table, 5, 4)) { return; }
		if (searchSum(table, 5, -4)) { return; }

		//
		if (searchSum(table, 5, 3)) { return; }
		if (searchSum(table, 5, -3)) { return; }

		//
		if (searchSum(table, 4, -3)) { return; }
		if (searchSum(table, 4, 3)) { return; }

		//
		if (searchSum(table, 3, 2)) { return; }
		if (searchSum(table, 3, -2)) { return; }

		//
		if (searchSum(table, 2, 1)) { return; }
		if (searchSum(table, 2, -1)) { return; }
	}

}
