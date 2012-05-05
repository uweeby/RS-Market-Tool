import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI();
	}

	private static void GUI() {
        JFrame frame = new JFrame("RS Market Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Setup GUI
        SuperHeatTable superheattable = new SuperHeatTable();
        superheattable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        superheattable.setSize(520, 120);
        superheattable.setVisible(true);
        superheattable.setTitle("RS Market Tool");
	}
}
