import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewSimple extends View{
	private JLabel label;
	public ViewSimple(ElectricityCompany m, Controller c) {
		super(m,c);
		label=new JLabel();
		this.setTitle("View Up");
		this.setSize(400, 300);
		this.add(label);
		update();
		this.setVisible(true);
	}
	public void update(){
		label.setText("total power consumption:"+m.totalConsumption());
	}
}
