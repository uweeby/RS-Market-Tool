package com.git.uwee.rsmarkettool;
public class SuperHeatItem {
	int SUPERHEATcost;
	int PROFIT;
	int[] superheatArray = new int[6];
	
	SuperHeatItem(int OREcost, int COALneeded, int BARcost, int NATUREcost, int COALcost) {
		SUPERHEATcost = NATUREcost + OREcost + (COALneeded * COALcost);
		PROFIT = BARcost - SUPERHEATcost;
		
		superheatArray[1] = OREcost;
		superheatArray[2] = COALneeded;
		superheatArray[3] = SUPERHEATcost;
		superheatArray[4] = BARcost;
		superheatArray[5] = PROFIT;

	}
}
