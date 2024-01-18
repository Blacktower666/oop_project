import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewGetPower extends View<ControllerGetPower> {
	private JTextField t;

	public ViewGetPower(ElectricityCompany m, ControllerGetPower c) {
		super(m, c);
		this.setTitle("View Up");
		this.setSize(400, 300);
		GridLayout g = new GridLayout(2, 1);
		this.setLayout(g);
		this.t = new JTextField("Type a consumer name here");// get the information from user
		JButton b = new JButton("Tell me the Power");
		this.add(t);
		this.add(b);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, c.getPower(t.getText()));
			}

		});
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void update() {
		// does nothing
	}
}
