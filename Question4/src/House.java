
public class House extends Building{

	public House(String name, int power) throws NotAPowerGeneratorException{
		super(name,power);
		if(power<0)//the power of house can't be negative 
			throw(new NotAPowerGeneratorException("A new house cannot generate power"));
	}

	@Override
	public void morePower(int amount) throws NotAPowerGeneratorException{
		if((this.getPower()+amount)<0)
			throw(new NotAPowerGeneratorException("A house cannot generate "+-(this.getPower()+amount)+" watts of power"));
		else
			this.setPower(this.getPower()+amount);
	}
	public static void testHouse() {
		try {
			House h1=new House("jojo",-1000);
		} catch (NotAPowerGeneratorException e1) {
			System.out.println(e1.getMessage());
		}
		try {
			House h=new House("jojo",1000);
			System.out.println(h.getName()=="jojo");
			System.out.println(h.getPower()==1000);
			h.setPower(1200);
			System.out.println(h.getPower()==1200);
			h.morePower(-1400);
		}catch(NotAPowerGeneratorException e) {
			System.out.println(e.getMessage());
		}
	}
}
