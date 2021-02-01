/**
 * @Project_Name Caro Game
 */
package com.hoanganh.main;

import java.util.Arrays;

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
		
		String arr[][] = new String[15][15];
		for (int j = 0; j < arr.length; j++) {
			Arrays.fill(arr[j], " ");
			System.out.println(Arrays.toString(arr[j]));
		}
	}
}
