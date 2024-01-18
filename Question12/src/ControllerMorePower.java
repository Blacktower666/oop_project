
public class ControllerMorePower extends Controller{

	public ControllerMorePower(ElectricityCompany m) {
		super(m);
		
	}
	public String morePower(String name,String amount) {
		try {
			m.morePower(name, Integer.parseInt(amount));
		} catch (NumberFormatException e) {
			return e.getMessage();
		} catch (UnknownConsumerException e) {
			return e.getMessage();
		} catch (NotAPowerGeneratorException e) {
			return e.getMessage();
		};
		return "";
	}

}
