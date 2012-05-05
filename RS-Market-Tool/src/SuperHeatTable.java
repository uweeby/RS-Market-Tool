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
				{"Mithril", itemlist.mithORE, 4, itemlist.mithSuperHeatCost, itemlist.mithBAR, itemlist.mithPROFIT},
				{"Adamantite", itemlist.adamORE, 6, itemlist.adamSuperHeatCost, itemlist.adamBAR, itemlist.adamPROFIT},
				{"Rune", itemlist.runeORE, 8, itemlist.runeSuperHeatCost, itemlist.runeBAR, itemlist.runePROFIT},

		};
		
		SuperHeatTable = new JTable(data, columnNames);
		SuperHeatTable.setPreferredScrollableViewportSize(new Dimension(500, 50));
		SuperHeatTable.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(SuperHeatTable);
		add(scrollPane);
    }
}
