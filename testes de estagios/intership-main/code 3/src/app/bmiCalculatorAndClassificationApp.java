package app;
import java.util.Scanner;

import model.Person;
import personControl.personControl;

public class bmiCalculatorAndClassificationApp {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Write your height. (ex: 1.80 ):");
		double heightInput = sc.nextDouble();
		System.out.println("Write your weight. (ex: 87.00)");
		double weightInput = sc.nextDouble();
		
		Person person = new Person();
		person.setHeight(heightInput);
		person.setWeight(weightInput);		
		personControl.bmiCalculator(person);

		System.out.println("Your BMI is: " + person.getBmi());
		System.out.print("Your BMI classification is: " + personControl.bmiClassification(person));
	
		sc.close();		
	}
}
