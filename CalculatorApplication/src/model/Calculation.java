package model;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Stateless
@Entity
public class Calculation {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; 
	 
    private double num1;
    private double num2;
    private String operation;
    private double result;


    public Calculation() {
    }

    public Calculation(double n1, double n2, String op) {
        this.num1 = n1;
        this.num2 = n2;
        this.operation = op;
    }

    // Setters
    public void setNumber1(double n1) {
        this.num1 = n1;
    }

    public void setNumber2(double n2) {
        this.num2 = n2;
    }

    public void setOperation(String op) {
        this.operation = op;
    }
    
    public void setResult(double result) {
        this.result = result;
    }


    // Getters
    public double getNumber1() {
        return num1;
    }

    public double getNumber2() {
        return num2;
    }

    public String getOperation() {
        return operation;
    }
    
    public double getResult() {
        return result;
    }
    
    // Calculate function
    public double calculate() {
        double result = 0.0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new IllegalArgumentException("Division by zero!");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
        this.result = result; 
        return result;
    }
}
