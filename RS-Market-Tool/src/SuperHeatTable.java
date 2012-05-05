import java.awt.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class SuperHeatTable extends JFrame {
	ItemList itemlist = new ItemList();
	JTable SuperHeatTable;
	
	
	public SuperHeatTable() {
		itemlist.RefreshButton();
		
		setLayout(new FlowLayout());
		
		String[] columnNames = {"Ore Type", "Ore Cost", "Coal", "Super Heat Cost", "Bar Value", "Profit"};
		Object[][] data = {
				{"Mithril", itemlist.mithOREcost, itemlist.mithCOALneeded, itemlist.mithSUPERHEATcost, itemlist.mithBARcost, itemlist.mithPROFIT},
				{"Adamantite", itemlist.adamOREcost, itemlist.adamCOALneeded, itemlist.adamSUPERHEATcost, itemlist.adamBARcost, itemlist.adamPROFIT},
				{"Rune", itemlist.runeOREcost, itemlist.runeCOALneeded, itemlist.runeSUPERHEATcost, itemlist.runeBARcost, itemlist.runePROFIT},

		};
		
		SuperHeatTable = new JTable(data, columnNames);
		SuperHeatTable.setPreferredScrollableViewportSize(new Dimension(500, 50));
		SuperHeatTable.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(SuperHeatTable);
		add(scrollPane);
    }
}
