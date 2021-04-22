/**
 * @Project_Name Caro Game
 */
package com.hoanganh.gui.panel;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.hoanganh.common.Constant;
import com.hoanganh.gui.frame.GUI;
import com.hoanganh.logic.CaroTable;

/**
 * @author Hoang Anh
 * @since 1 thg 2, 2021
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CaroTablePanel extends BasePanel{
	private static JButton[][] b;
	private CaroTable caroTable;
	
	private static int whoFirst = Constant.USER_FIRST;
	private static boolean userX = true;
	private static boolean hasAI = true;

	private int nStep;
	// Mảng lưu vị trí đánh theo chiều ngang
	private int[] x_pos;
	// Mảng lưu vị trí đánh theo chiều dọc
	private int[] y_pos;

	// Danh sách các ô đã được đánh
	private boolean[][] used;

	

	@Override
	public void init() {
		setSize(GUI.WIDTH, GUI.HEIGHT);
		setLayout(null);
		setLocation(0, 0);
		
		b = new JButton[Constant.COLUMN][Constant.ROW];
		caroTable = new CaroTable();
		
		x_pos = new int[Constant.COLUMN * Constant.ROW];
		y_pos = new int[Constant.COLUMN * Constant.ROW];
		used = new boolean[Constant.COLUMN][Constant.ROW];
	}

	@Override
	public void addComponent() {
		// Label "Caro Game"
		JLabel lbHeader = new JLabel("Caro Game");
		lbHeader.setFont(Constant.fontHeader);
		lbHeader.setLocation(Constant.MARGIN, Constant.MARGIN);
		lbHeader.setSize(lbHeader.getPreferredSize());

		JButton btnRestart = new JButton("Bắt đầu");
		btnRestart.setFont(Constant.fontNormal);
		btnRestart.setSize(btnRestart.getPreferredSize());

		setTable(Constant.MARGIN, Constant.MARGIN + lbHeader.getY() + lbHeader.getHeight());
		add(lbHeader);
	}

	

	@Override
	public void addEvent() {
		caroTableEvent();
		
	}

	// --------------------- Private Layer ---------------------
	
	/**
	 * Phương thức tạo bảng gồm một mảng 2 chiều chứa các button, 
	 * bằng cách thiết lập các thuộc tính cho đối tượng button: <br>
	 * 
	 * - Tên <br>
	 * - Font <br>
	 * - Margin <br>
	 * - Size <br>
	 * - Location <br>
	 *
	 * Sau khi thiết lập xong giá trị cho các thuộc tính, thì add button 
	 * vào panel
	 * 
	 * @param x - Tọa độ x (pixel) của Table
	 * @param y - Tọa độ y (pixel) của Table
	 */
	private void setTable(int x, int y) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = new JButton();
				b[i][j].setName(i + "_" + j);
				b[i][j].setFont(Constant.fontNormal);
				b[i][j].setMargin(new Insets(0, 0, 0, 0));
				b[i][j].setSize(Constant.CELL_WIDTH, Constant.CELL_HIGHT);
				b[i][j].setLocation(x + i * Constant.CELL_WIDTH, y + j * Constant.CELL_HIGHT);
				add(b[i][j]);
			}
		}
	}
	
	/**
	 * Phương thức xử lý sự kiện cho các button trong bàn cờ
	 */
	private void caroTableEvent() {
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lấy về đối tượng Button đang được click
				JButton button = (JButton) e.getSource();
				// Lấy về vị trí của button đó
				String[] location = button.getName().split("_");
				// Hoành độ của button
				int x = Integer.parseInt(location[0]);
				// Tung độ của button
				int y = Integer.parseInt(location[1]);
				// Nếu button đã được chọn trước đó thì bỏ qua sự kiện
				// Nếu button chưa được chọn thì thực thi tiếp
				if (!used[x][y]) {
					used[x][y] = true;
					// Lưu tọa độ button đã đánh
					x_pos[nStep] = x;
					y_pos[nStep] = y;
					// Tăng biến đếm
					nStep++;
					if (userX) {
						// Nếu người dùng là x thì hiện X lên button
						button.setText("x");
					} else {
						// Nếu người dùng là o thì hiện O lên button
						button.setText("o");
					}

					// Tiến hành tìm nước đi tiếp theo cho máy ảo

				}
			}
		};
		
		// Thêm sự kiện onclick vào button
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j].addActionListener(action);
			}
		}
	}
	

	/**
	 * Phương thức đánh cờ của máy tính
	 * 
	 * @param nextMoveX - Tọa độ X
	 * @param nextMoveY - Tọa độ Y
	 */
	private void UpdateMove(int nextMoveX, int nextMoveY) {
		used[nextMoveX][nextMoveY] = true;
		x_pos[nStep] = nextMoveX;
		y_pos[nStep] = nextMoveY;

		nStep++;
	}

}
