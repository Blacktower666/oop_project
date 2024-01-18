
public class GUI {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
			// The MyFrame object will remain in memory as long
			// as the window is visible to the user.
				ElectricityCompany e=new ElectricityCompany("UIC Electric");
				ControllerSimple c=new ControllerSimple(e);
				ControllerGetPower c1=new ControllerGetPower(e);
				ControllerMorePower c2=new ControllerMorePower(e);
				ControllerCreate c3=new ControllerCreate(e);
				ViewSimple v=new ViewSimple(e,c);
				ViewGetPower v1=new ViewGetPower(e,c1);
				ViewMorePower v2=new ViewMorePower(e,c2);
				ViewCreate v3=new ViewCreate(e,c3);
			}
			});
	}
}
