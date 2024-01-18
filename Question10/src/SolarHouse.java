
public class SolarHouse extends House {
	public SolarHouse(String name, int power) throws NotAPowerGeneratorException {
		super(name, power);
	}

	@Override
	public void morePower(int amount) {
		this.setPower(this.getPower()+amount);
	}

	public static void testSolarHouse() {
		try {
			SolarHouse s = new SolarHouse("jojo", 1000);
			s.morePower(-1400);
			System.out.println(s.getPower()==-400);//SolarHouse's power can be negative
		} catch (NotAPowerGeneratorException e) {
			System.out.println(e.getMessage());
		}
	}
}
