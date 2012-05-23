package com.git.uwee.rsmarkettool;

import javax.swing.JFrame;

public class RSMarketTool {
    public static void main(String[] args) {
    	//Create GUI
    	GUI guiObject = new GUI();
		guiObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiObject.setSize(600,160);
		guiObject.setVisible(true);
    }
}
