package sumapp.Math;


public class SimpleMath {

	public double sum(Double numberOne, Double numberTwo) {
	  return numberOne+numberTwo;  
	}
	
	public Double subtraction(Double numberOne, Double numberTwo) {
	return numberOne-numberTwo;  
	}
	public Double multily(Double numberOne, Double numberTwo) {
		return numberOne*numberTwo;  
		}
	
	public Double squareroot(Double numberOne) {
	  return Math.sqrt(numberOne);  
	}
	public Double division(Double numberOne, Double numberTwo) {
		return numberOne/numberTwo;  
		}
	public boolean equals(Double numberOne, Double numberTwo) {
		if  (Double.compare(numberOne, numberTwo)==0) {
			return true;
		}
		return false;  
		}
	
}
