/**
 * @Project_Name Caro Game
 */
package com.hoanganh.gui.panel;

import javax.swing.JPanel;

import com.hoanganh.gui.icommon.ICommon;

/**
 * @author Hoang Anh
 * @since 1 thg 2, 2021
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class BasePanel extends JPanel implements ICommon {
	public BasePanel() {
		init();
		addComponent();
		addEvent();
	}
}
