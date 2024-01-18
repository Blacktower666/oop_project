
public class ControllerGetPower extends Controller{
	public ControllerGetPower(ElectricityCompany m) {
		super(m);
	}
	public String getPower(String name)  {
		try {
			return Integer.toString(m.getPower(name));
		} catch (UnknownConsumerException e) {
			return e.getMessage();
		}
	}
}
