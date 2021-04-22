/**
 * @Project_Name Caro Game
 */
package com.hoanganh.gui.frame;

import javax.swing.JFrame;

import com.hoanganh.common.Constant;
import com.hoanganh.gui.icommon.ICommon;
import com.hoanganh.gui.panel.CaroTablePanel;

/**
 * @author Hoang Anh
 * @since 1 thg 2, 2021
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GUI extends JFrame implements ICommon{
	
	private CaroTablePanel caroTablePanel;
	
	/**
	 * 
	 */
	public GUI() {
		init();
		addComponent();
		addEvent();
	}

	@Override
	public void init() {
		setTitle("Caro Game");
		setResizable(true);
		setSize(Constant.WIDTH, Constant.HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
	public void addComponent() {
		caroTablePanel = new CaroTablePanel();
		add(caroTablePanel);
	}

	@Override
	public void addEvent() {
		// TODO Auto-generated method stub
		
	}

}
