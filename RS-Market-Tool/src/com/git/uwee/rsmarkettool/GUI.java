package com.git.uwee.rsmarkettool;

import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {
	
	JLabel superheatHeader;
	JTable superheatTable;
	JButton superheatRefreshButton;
	
	private String[] superheatColumnNames = {"Ore Type", "Ore Cost", "Coal", "Super Heat Cost", "Bar Value", "Profit"};
	public static Object[][] superheatTableData = {
			{"Mithril", 0, 0, 0, 0, 0},
			{"Adamantite", 0, 0, 0, 0, 0},
			{"Rune", 0, 0, 0, 0, 0}
			};
	
	public GUI() {
		//Setup frame
		super("RS Market Tool"); //Frame title
		setLayout(new FlowLayout());
		
		//Header label for Super Heat Section
		superheatHeader = new JLabel("Super Heat Item:");
		add(superheatHeader);

		//Setup Super Heat table
		superheatTable = new JTable(superheatTableData, superheatColumnNames);
		superheatTable.setPreferredScrollableViewportSize(new Dimension(480, 50));
		superheatTable.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(superheatTable);
		add(scrollPane);
		
		//Setup superheatRefresh button
		superheatRefreshButton = new JButton("Refresh");
		superheatRefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//Refresh Super Heat Data:
            	SuperHeatRefresh superheatrefresh = new SuperHeatRefresh();
            	superheatrefresh.run();
            	System.out.println(superheatTableData[0][1]);
            	
            	//Update the Table Data with changes
            	superheatTable.repaint();
            }
        });
		//Add Super Heat Refresh Button to screen
		add(superheatRefreshButton);
    }
}
