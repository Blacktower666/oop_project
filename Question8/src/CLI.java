import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws UnknownConsumerException, NotAPowerGeneratorException {
		ElectricityCompany ele = new ElectricityCompany("UIC Electric");
		while (true) {
			int num1 = readPosInt("Type an action (total:1 add:2 get:3 more:4 less:5 quit:6):");// read the number from user
			switch (num1) {
			case 1:
				System.out.println("Total amount of power consumed:" + ele.totalConsumption());//pritn out the sum of power
				break;
			case 2:
				int num2 = readPosInt("Type the consumer type (power plant:1 house:2 solar house:3):");
				if (num2 < 1 || num2 > 3) {//judge which consumer should be added
					System.out.println("Unknown type of consumer!");
					}
				else {
					String name = readLine("Enter the name of the consumer:");
					int power = readPosInt("Enter the initial amount of power:");
					switch (num2) {
					case 1:
						ele.addConsumer(new PowerPlant(name, power));//add a power plant
						System.out.println("Power plant \""+name+"generating "+power+" watts of power added");
						break;
					case 2:
						try {
							ele.addConsumer(new House(name, power));//add a house
							System.out.println("House \""+name+"\"generating "+power+" watts of power added");
						} catch (NotAPowerGeneratorException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 3:
						try {
							ele.addConsumer(new SolarHouse(name, power));//add a solarhouse
							System.out.println("Solor Houese \""+name+"\"generating "+power+" watts of power added");
						} catch (NotAPowerGeneratorException e) {
							System.out.println(e.getMessage());
						}
						break;
					}
				}
				break;
			case 3:
				String name = readLine("Enter the name of the consumer: ");
				int i = 0;
				for (; i < ele.consumers.size(); i++) {
					if (name.equals(ele.consumers.get(i).getName())) {//find the consumer
						System.out.println(name + " uses " + ele.consumers.get(i).getPower() + " watts");
						break;
					}
					if(i==ele.consumers.size())
						System.out.println("Consumer "+name+" unknown");
				}
				break;
			case 4:
				String name1 = readLine("Enter the name of the consumer: ");
				int power=readPosInt("Enter the amount of power: ");
				for (int i1 = 0; i1 < ele.consumers.size(); i1++) {//find the consumer
					if (name1.equals(ele.consumers.get(i1).getName())) {
						ele.consumers.get(i1).morePower(power);
						break;
					} else
						throw (new UnknownConsumerException("Consumer " + name1 + " unknown"));
				}
				break;
			case 5:
				String name2 = readLine("Enter the name of the consumer: ");
				int power1=readPosInt("Enter the amount of power: ");
				for (int i1 = 0; i1 < ele.consumers.size(); i1++) {//find the consumer
					if (name2.equals(ele.consumers.get(i1).getName())) {
						ele.consumers.get(i1).morePower(-power1);
						break;
					} else
						throw (new UnknownConsumerException("Consumer " + name2 + " unknown"));
				}
				break;
			case 6:
				System.out.println("Goodbye!");
				System.exit(0);//exit the program
				break;
			default:
				System.out.println("Unknown action!");
				break;
			}
		}
	}

	private static String readLine(String a) {
		System.out.print(a);
		// Scanner input =new Scanner(System.in);
		String s = input.nextLine();
		return s;

	}

	private static int readPosInt(String a) {
		while (true) {
			int i;
			while (true) {
				System.out.print(a);
				try {
					i = input.nextInt();// read the integers
					break;
				} catch (InputMismatchException e) {
					System.out.println("You must type an integer!");
				} finally {
					String s = input.nextLine();
				}
			}
			return i;
		}
	}
}
