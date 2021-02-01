/**
 * @Project_Name Caro Game
 */
package com.hoanganh.gui.panel;

import javax.swing.JButton;

/**
 * @author Hoang Anh
 * @since 1 thg 2, 2021
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CaroTable extends BasePanel{

	private static final int COLUM = 15;
	private static final int ROW   = 15;
	
	int xUndo[] = new int[COLUM * ROW];
	int yUndo[] = new int[COLUM * ROW];
	
	private JButton b[][] = new JButton[COLUM + 2][ROW + 2];
	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addComponent() {
		// TODO Auto-generated method stub
		add(b);
		
	}

	

	@Override
	public void addEvent() {
		// TODO Auto-generated method stub
		
	}

	// --------------------- Private Layer ---------------------
	
	/**
	 * @param b
	 */
	private void add(JButton[][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				add(b[i][j]);
			}
		}
	}
}
