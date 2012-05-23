package com.git.uwee.rsmarkettool;
public class SuperHeatItem {
	int OREcost;
	int COALneeded;
	int SUPERHEATcost;
	int BARcost;
	int PROFIT;
	int NATUREcost;
	int COALcost;
	
	SuperHeatItem(int OREcost, int COALneeded, int BARcost, int NATUREcost, int COALcost) {
		this.OREcost = OREcost;
		this.COALneeded = COALneeded;
		this.BARcost = BARcost;
		this.NATUREcost = NATUREcost;
		this.COALcost = COALcost;
		this.SUPERHEATcost = NATUREcost + OREcost + (COALneeded * COALcost);
		this.PROFIT = BARcost - SUPERHEATcost;
	}
	
	public int getOREcost() {
		return OREcost;
	}
	public int getCOALneeded() {
		return COALneeded;
	}
	public int getSUPERHEATcost() {
		return SUPERHEATcost;
	}
	public int getBARcost() {
		return BARcost;
	}
	public int getPROFIT() {
		return PROFIT;
	}
	
}
