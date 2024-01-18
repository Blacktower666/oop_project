import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewHistory extends View<ControllerHistory>{

	public ViewHistory(ElectricityCompany m, ControllerHistory c) {
		super(m, c);
		this.setTitle("View History");
		this.setSize(400, 300);
		this.add(new HistoryPanel(m));
		repaint();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void update() {
		repaint();
	}

}
