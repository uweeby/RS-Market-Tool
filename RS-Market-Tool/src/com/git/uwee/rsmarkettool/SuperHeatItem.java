package com.git.uwee.rsmarkettool;

public class SuperHeatItem {
	
	//Variable Declaration
	int[] superheatArray = new int[6];
	
	//Constructor
	SuperHeatItem(int _oreCost, int _coalNeeded, int _barCost, int _natureCost, int _coalCost) {
		int _superheatCost = _natureCost + _oreCost + (_coalNeeded * _coalCost);
		int _profit = _barCost - _superheatCost;
		
		superheatArray[1] = _oreCost;
		superheatArray[2] = _coalNeeded;
		superheatArray[3] = _superheatCost;
		superheatArray[4] = _barCost;
		superheatArray[5] = _profit;
	}
}
