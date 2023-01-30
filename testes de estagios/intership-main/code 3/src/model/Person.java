package model;

public class Person {

	double weight;
	double height;
	double bmi;
	
	public void  setBmi(double bmi) {
		this.bmi = bmi;
	}
	
	public double getBmi() {
		return bmi;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
}
