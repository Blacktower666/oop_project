import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewMorePower extends View<ControllerMorePower> {
	private JTextField t1;
	private JTextField t2;

	public ViewMorePower(ElectricityCompany m, ControllerMorePower c) {
		super(m, c);
		this.setTitle("View More Power");
		this.setSize(400, 300);
		GridLayout g = new GridLayout(3, 1, 0, 0);
		this.setLayout(g);
		this.t1 = new JTextField("Type a consumer name here");// get the information from user
		this.t2 = new JTextField("Type an amount of power here");// get the information from user
		JButton b = new JButton("More power");
		this.add(t1);
		this.add(t2);
		this.add(b);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (c.morePower(t1.getText(), t2.getText()) != "")
					JOptionPane.showMessageDialog(null, c.morePower(t1.getText(), t2.getText()));//show the error
			}

		});
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void update() {

	}

}
