import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewSimple extends JFrame implements ModelListener{
	private ElectricityCompany m;
	private ControllerSimple c;
	private JLabel label;
	public ViewSimple(ElectricityCompany m, ControllerSimple c) {
		this.m=m;
		this.c=c;
		m.addListener(this);
		label=new JLabel();
		this.setTitle("View Up");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(label);
		update();
		this.setVisible(true);
	}
	public void update(){
		label.setText("total power consumption:"+m.totalConsumption());
	}
}
