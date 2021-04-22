/**
 * @Project_Name Caro Game
 */
package com.hoanganh.main;

import Sample.MainProgram;

/**
 * @author Hoang Anh
 * @since 1 thg 2, 2021
 * @version 1.0
 */
public class Main {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		GUI gui = new GUI();
//		gui.setVisible(true);

		MainProgram.InitGUI();
		MainProgram.InitEventListener();
		MainProgram.GamePlaying();
	}
}
