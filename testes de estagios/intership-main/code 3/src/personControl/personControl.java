package personControl;

import model.Person;

public class personControl {

	public static double bmiCalculator(Person person) {	
		double heightCal = person.getHeight() * person.getHeight();
		double calculation = person.getWeight() / heightCal;
		person.setBmi(calculation);
		return calculation;
	}
	
	public static String bmiClassification(Person person) {

		double bmi = person.getBmi();

		if (bmi < 18.5) {
	        return "Underweight";
	    }
	    else if (bmi < 25) {
	        return "Normal";
	    }
	    else if (bmi < 30) {
	        return "Overweight";
	    }
	    else if (bmi < 34.9) {
	       return "Obesity I";
	    }
	    else if (bmi < 39.9) {
	       return "Obesity II";
	    }
	    else {
	       return "Obesity III";
	    }
	}
}
