import java.util.ArrayList;

public class ElectricityCompany {
	private String name;
	protected ArrayList<Consumer> consumers;
	private ArrayList<ModelListener> Listeners;
	private ArrayList<Integer> history;
	public ElectricityCompany(String name) {
		this.name = name;
		this.consumers= new ArrayList<Consumer>();
		this.Listeners= new ArrayList<ModelListener>();
		this.history=new ArrayList<Integer>();
		history.add(0);
	}
	public ArrayList<Integer> getHistory() {
		return this.history;
	}
	public void addListener(ModelListener m) {
		Listeners.add(m);
	}
	public void notifyListeners() {
		for(ModelListener m:Listeners) {
			m.update();
		}
	}
	public void addConsumer(Consumer consumer) {
		consumers.add(consumer);
		history.add(this.totalConsumption());
		notifyListeners();
	}

	public int totalConsumption() {
		int sum = 0;
		for (Consumer c : consumers)//to calculate the whole power
			sum += c.getPower();
		return sum;
	}
	public int getPower(String name) throws UnknownConsumerException {
		int i = 0;
		for (; i < consumers.size(); i++) {//to find the consumer
			if (consumers.get(i).getName().equals(name))
				return consumers.get(i).getPower();
		}
		if(i==consumers.size())
			throw new UnknownConsumerException("Consumer " + name + " unknown");
		return 0;
	}
	public void morePower(String name,int amount) throws UnknownConsumerException, NotAPowerGeneratorException{
		int i = 0;
		for (; i < consumers.size(); i++) {//to find the consumer
			if (consumers.get(i).getName().equals(name)) {
				consumers.get(i).morePower(amount);
				history.add(this.totalConsumption());
				notifyListeners();
				break;
				}
		}
		if(i==consumers.size())
			throw new UnknownConsumerException("Consumer " + name + " unknown");
	}
	public static void testElectricityCompany() {
		ElectricityCompany E=new ElectricityCompany("jojo");
		try {
			E.addConsumer(new House("h1",1000));//set the consumers
			E.addConsumer(new SolarHouse("h2",500));
			E.addConsumer(new PowerPlant("h3",2000));
			System.out.println(E.totalConsumption()==-500);
			try {
				System.out.println(E.getPower("w1")==1000);//to see if we can find the customer
			} catch (UnknownConsumerException e) {
				System.out.println(e.getMessage().equals("Consumer w1 unknown"));
			}
			try {
				System.out.println(E.getPower("h1")==1000);
			} catch (UnknownConsumerException e) {
				System.out.println(e.getMessage().equals("Consumer h1 unknown"));
			}
			try {
				E.morePower("h1",500);
			} catch (UnknownConsumerException e) {
				System.out.println(e.getMessage().equals("Consumer h1 unknown"));
			}
			try {
				System.out.println(E.getPower("h1")==1500);//ensure the power change correctly
			} catch (UnknownConsumerException e) {
				System.out.println(e.getMessage().equals("Consumer h1 unknown"));
			}
		} catch (NotAPowerGeneratorException e) {
			System.out.println(e.getMessage());
		}
	}
}
