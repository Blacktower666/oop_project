
public class ControllerCreate extends Controller {

	public ControllerCreate(ElectricityCompany m) {
		super(m);
	}

	public String create(String name, String amount, int type) {//create the right consumer
		try {
			switch (type) {
			case 0:
				m.addConsumer(new House(name, Integer.parseInt(amount)));
				break;
			case 1:
				m.addConsumer(new PowerPlant(name, Integer.parseInt(amount)));
				break;
			case 2:
				m.addConsumer(new SolarHouse(name, Integer.parseInt(amount)));
				break;
			}
		} catch (NumberFormatException e) {
			return e.getMessage();
		} catch (NotAPowerGeneratorException e) {
			return e.getMessage();
		}
		return "";

	}

}
