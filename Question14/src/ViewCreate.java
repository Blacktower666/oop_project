import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ViewCreate extends View<ControllerCreate> {
	private JTextField t1;
	private JTextField t2;
	private JComboBox<String> cb;

	public ViewCreate(ElectricityCompany m, ControllerCreate c) {
		super(m, c);
		this.setTitle("View Create");
		this.setSize(400, 300);
		GridLayout g = new GridLayout(4, 1, 0, 0);
		this.setLayout(g);
		this.t1 = new JTextField("Type a consumer name here");// get the information from user
		this.t2 = new JTextField("Type an amount of power here");
		this.cb = new JComboBox<String>();// get the information from user
		cb.setVisible(true);
		cb.addItem("House");
		cb.addItem("Power Plant");
		cb.addItem("Solar House");
		JButton b = new JButton("Create");
		this.add(t1);
		this.add(t2);
		this.add(cb);
		this.add(b);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (c.create(t1.getText(), t2.getText(), cb.getSelectedIndex()) != "")
					JOptionPane.showMessageDialog(null, c.create(t1.getText(), t2.getText(), cb.getSelectedIndex()));
			}

		});
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void update() {

	}

}
