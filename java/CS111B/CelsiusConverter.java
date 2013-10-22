import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class CelsiusConverter extends JFrame {

	protected JPanel panel;
	protected JLabel f_label;
	protected JLabel temperature_label;
	protected JTextField textfield;
	protected JButton calcbutton;
	private final int WINDOW_WIDTH = 250;
	private final int WINDOW_HEIGHT = 100;
	
	public CelsiusConverter() {
		
		this.setTitle("Celsius Converter");
		this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.buildPanel();
		this.add(this.panel);
		
		this.setVisible(true);
	}
	
	protected void buildPanel() {
		this.textfield = new JTextField(8);
		this.calcbutton = new JButton("Convert");
		this.f_label = new JLabel("Farenheit: ");
		this.f_label.setVisible(false);
		this.temperature_label = new JLabel("0 degrees");
		this.temperature_label.setVisible(false);
		
		//Add event listener
		calcbutton.addActionListener(new CalcButtonListener());
		
		this.panel = new JPanel();
		this.panel.add(textfield);
		this.panel.add(calcbutton);
		this.panel.add(f_label);
		this.panel.add(temperature_label);
	
	}
	
	private class CalcButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			//To go from c to f, multiply by 1.8 and add 32
			String input;
			DecimalFormat formatter = new DecimalFormat("#0.00");
			double farenheit;
			
			input = textfield.getText();
			farenheit = (Double.parseDouble(input) * 1.8) + 32;

			temperature_label.setText(formatter.format(farenheit) + " degrees");
			
			f_label.setVisible(true);
			temperature_label.setVisible(true);	
		}		
	}
	
	public static void main(String[] args) {
		new CelsiusConverter();
	}
	
}
