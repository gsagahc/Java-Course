package sumapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sumapp.Math.SimpleMath;
import sumapp.converters.NumberConverter;
import sumapp.exceptions.UnsupportedMathOperationException;

@RestController
public class HomeController {
	private AtomicLong counter = new AtomicLong();
	private SimpleMath simplemath = new SimpleMath();
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception 
	{
		if (!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return simplemath.sum(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));  
		
	}
	
	
	@GetMapping("/multiply/{numberOne}/{numberTwo}")
	public Double multiply(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception 
	{
		if (!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return simplemath.multily(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));  
		
	}
	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception 
	{
		if (!NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return simplemath.subtraction(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));  
		
	}
	@GetMapping("/squareroot/{numberOne}")
	public Double squareroot(
			@PathVariable(value = "numberOne") String numberOne)
		  throws Exception 
	{
		if (!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		return simplemath.squareroot( NumberConverter.convertToDouble(numberOne));  
		
	}


	public AtomicLong getCounter() {
		return counter;
	}


	public void setCounter(AtomicLong counter) {
		this.counter = counter;
	}
	

	

	
	
}
