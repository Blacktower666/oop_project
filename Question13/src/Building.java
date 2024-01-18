
public abstract class Building implements Consumer{
	private String name;
	private int power;
	public Building(String name,int power) {
		this.name=name;
		this.power=power;
	}
	public String getName() {
		return name;
	}
	public int getPower() {
		return power;
	}
	protected void setPower(int power) {
		this.power = power;
	}
	public abstract void morePower(int amount) throws NotAPowerGeneratorException;
	public void testBulding() {
		//as it is an abstract, it can't be test.
	}
}
